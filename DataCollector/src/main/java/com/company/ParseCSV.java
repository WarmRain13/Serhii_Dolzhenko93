package com.company;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseCSV {
    private String infoFile = Files.readString(Path.of("DataCollector/src/main/resources/info.json"));
    private String csvFile;
    private List<String> lines = new ArrayList<>();
    Map<String, List<Station>> array;

    public ParseCSV(String file, Map<String, List<Station>> array) throws IOException {
        this.csvFile = file;
        this.array = array;
    }
    public void parsePrint() throws IOException {
        lines = Files.readAllLines(Paths.get(csvFile));

        for (String line : lines) {
            if (line.contains("name")){
                continue;
            }
            System.out.println(line);
        }
    }
    public void parseUpdateInfo() throws IOException {

        lines = Files.readAllLines(Paths.get(csvFile));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonInfo = objectMapper.readTree(infoFile);

        for (String line : lines) {
            if (line.contains("name")){
                continue;
            }
            String[] text = line.split(",");
            String station = text[0];
            String date = text[1];

            for (JsonNode ji : jsonInfo) {
                for (JsonNode jn : ji) {
                    if (jn.get("name").asText().contains(station)) {
                        ObjectNode jnNode = (ObjectNode) jn;
                        jnNode.put("date", date);
                        for (List<Station> arr : array.values()) {
                            for (Station st : arr) {
                                if (st.getName().contains(station)){
                                    st.setDate(date);
                                }
                            }
                        }
                    }
                }
            }
        }
        File output = new File("DataCollector/src/main/resources/info.json");
        objectMapper.writeValue(output, jsonInfo);
    }
}
