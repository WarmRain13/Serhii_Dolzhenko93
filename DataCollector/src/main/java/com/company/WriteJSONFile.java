package com.company;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WriteJSONFile {
    private String infoFile = Files.readString(Path.of("DataCollector/src/main/resources/info.json"));
    private InfoStation infoStation;
    private Map<String, List<Station>> listStation;

    public WriteJSONFile(Map<String,List<Station>> listStation, InfoStation infoStation) throws IOException {
        this.listStation = listStation;
        this.infoStation = infoStation;
    }

    private void inJson(Map list, String text) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File output = new File(text);
        mapper.writeValue(output, list);
        String inText = Files.readString(Path.of(text));

        JsonNode jsonData = mapper.readTree(inText);
        JsonNode jStation = jsonData.get("stations");
        for (JsonNode jn : jStation) {
            ObjectNode stat = (ObjectNode) jn;
            if (jn.get("depth").isNull()) {
                stat.remove("depth");
            }
            if (jn.get("date").isNull()) {
                stat.remove("date");
            }
        }

        output = new File(text);
        mapper.writeValue(output, jsonData);
    }

    public void writeStation() throws IOException {
        String path = "DataCollector/src/main/resources/station.json";
        List<Station> stations = new ArrayList<>();
        Map<String, List<Station>> stationMap = new TreeMap<>();

        listStation.forEach((s, stationsList) -> stationsList.forEach(station -> stations.add(station)));
        stationMap.put("stations", stations);
        inJson(stationMap, path);

    }

    public void writeMap() throws IOException {
        String path = "DataCollector/src/main/resources/map.json";
        ObjectMapper mapper = new ObjectMapper();
        File output = new File(path);
        mapper.writeValue(output, infoStation);

        String inText = Files.readString(Path.of(path));
        JsonNode jsonData = mapper.readTree(inText);
        JsonNode jStation = jsonData.get("connections");
        for (JsonNode jn : jStation) {
            for (JsonNode js : jn) {
                ObjectNode stat = (ObjectNode) js;
                stat.remove("depth");
                stat.remove("date");
                stat.remove("hasConnection");
            }
        }

        output = new File(path);
        mapper.writeValue(output, jsonData);
    }
}
