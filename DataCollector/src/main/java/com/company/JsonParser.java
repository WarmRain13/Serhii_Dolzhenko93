package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JsonParser {
    private String infoFile = Files.readString(Path.of("DataCollector/src/main/resources/info.json"));

    private String jsonFile;
    Map<String, List<Station>> array;

    public JsonParser(String file, Map<String, List<Station>> array) throws IOException {
        this.jsonFile = Files.readString(Paths.get(file));
        this.array = array;
    }
    public void parsePrint() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonData = objectMapper.readTree(jsonFile);
        for (JsonNode jd : jsonData) {
            String station = String.valueOf(jd.get("station_name").asText());
            String depth = String.valueOf(jd.get("depth").asText());
            System.out.println("Станция - " + station + ", глубина - " + depth);
        }
    }
    public void parseUpdateInfo() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonInfo = objectMapper.readTree(infoFile);
        JsonNode jsonData = objectMapper.readTree(jsonFile);

        for (JsonNode jo : jsonData) {
            for (JsonNode ji : jsonInfo) {
                for (JsonNode jn : ji) {
                    if (jn.get("name").asText().contains(jo.get("station_name").asText())) {
                        ObjectNode jnNode = (ObjectNode) jn;
                        jnNode.put("depth", jo.get("depth").asText());
                        for (List<Station> arr : array.values()) {
                            for (Station st : arr) {
                                if (st.getName().contains(jo.get("station_name").asText())){
                                    st.setDepth(jo.get("depth").asText());
                                }
                            }
                        }
                        File output = new File("DataCollector/src/resources/info.json");
                        objectMapper.writeValue(output, jsonInfo);
                    }
                }
            }
        }

    }
}
