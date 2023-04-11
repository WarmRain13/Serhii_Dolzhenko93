package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;


public class InfoStation {
    private TreeMap<String, List<String>> stations;
    private TreeSet<Line> lineList;
    private List<TreeSet<Station>> connections;

    public InfoStation(){
        this.stations = new TreeMap<>();
        this.lineList = new TreeSet<Line>();
        this.connections = new ArrayList<>();
    }

    public void addStation(String numberLine, List<String> station){
        stations.put(numberLine,station);
    }

    public TreeMap<String, List<String>> getStations(){
        return stations;
    }

    public void addLine(com.company.Line line){
        lineList.add(line);
    }

    public TreeSet<com.company.Line> getLineList(){
        return lineList;
    }

    public void addConnections(TreeSet<Station> connect){
        connections.add(connect);
    }

    public List<TreeSet<Station>> getConnection(){
        return connections;
    }
}
