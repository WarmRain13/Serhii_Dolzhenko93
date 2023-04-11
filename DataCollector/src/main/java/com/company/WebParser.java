package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.File;
import java.io.IOException;
import java.util.*;


public class WebParser {
    private String url = "";
    private Document document;
    private Map<String, List<Station>> array = new HashMap<>();
    private InfoStation infoStation = new InfoStation();

    public WebParser(String url) throws IOException {
        this.url = url;
        this.document = gettingPageHtmlCode();
    }

    public InfoStation getInfoStation() {
        return infoStation;
    }

    public Map<String, List<Station>> getArray() {
        return array;
    }

    public Document gettingPageHtmlCode () throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc;
    }

    public void parsePage () throws IOException {
        Elements info = document.select("div[id]");
        for (Element element : info) {
            Elements nameLine = element.select("span[^data]");
            for (Element infoLine : nameLine) {
                String number = infoLine.attr("data-line");
                String name = infoLine.text();
                if (!name.isBlank() && !number.isBlank()) {
                    Line line = new Line(name, number);
                    infoStation.addLine(line);
                    array.put(number, new ArrayList<>());
                }
            }
            for (String line : array.keySet()) {
                Elements nameStations = element.select("div[data-line=" + line + "]");
                List<Station> stationList = new ArrayList<>();
                List<String> nameStation = new ArrayList<>();
                for (Element s : nameStations) {
                    Elements st = s.children();
                    for (Element infoSt : st) {
                        Elements infoS = infoSt.children();
                        Elements name = infoS.select("[class=name]");
                        Elements connect = infoS.select("[title]");
                        TreeSet<Station> connections = new TreeSet<>();
                        Station newStation = new Station(name.text(), line);
                        nameStation.add(newStation.getName());
                        stationList.add(newStation);
                        if (!connect.isEmpty()) {
                            connections.add(new Station(name.text(), line));
                            for (Element e : connect) {
                                connections.add(createConnection(e));
                            }
                            newStation.setHasConnection(true);
                            if (!connections.isEmpty()) {
                                infoStation.addConnections(connections);
                            }
                        }
                    }

                    infoStation.addStation(line, nameStation);
                    array.replace(line, stationList);

                    inJson(array);
                }
            }
        }
    }

    private void inJson(Map array) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File output = new File("DataCollector/src/main/resources/info.json");
        mapper.writeValue(output, array);
    }
    private Station createConnection(Element element) {
        String textName = element.attr("title");
        String textNumber = element.attr("class");
        int index = textNumber.lastIndexOf("-") + 1;
        int start = textName.indexOf("«") + 1;
        int end = textName.indexOf("»");
        String name = textName.substring(start, end);
        String number = textNumber.substring(index);
        Station connection = new Station(name, number);

        return connection;
    }

    public void print() {

        for (String s : array.keySet()) {
            System.out.println(s);
            for (Station w : array.get(s)) {
                System.out.println("  " + w);
            }
        }
    }
}
