package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WebParser {

    private final String url = "https://skillbox-java.github.io";



     public WebParser() throws IOException {
        //String htmlFile = parseFile( "data/metro.html");

         Document doc = Jsoup.connect(url).get();

        Elements lineElements = doc.select("div.js-toggle-depend");
        Elements stationElement = doc.select("div.js-depend");

        LinkedHashMap<String, String> linesNameAndNumber = new LinkedHashMap<>();
        LinkedHashMap<String, String> stationNameAndLine = new LinkedHashMap<>();

        for(Element itemLn : lineElements){
            String numberLn = itemLn.select("span").attr("data-line");
            String nameLn = itemLn.text();

            linesNameAndNumber.put(numberLn,nameLn);

            System.out.println(numberLn + " - " + nameLn);

        }

        for(Element itemSt : stationElement){
            String numberSt = itemSt.attr("data-depend-set").replaceAll("lines-", " ");
            String nameSt = itemSt.select("span.name").text();

            stationNameAndLine.put(numberSt, nameSt);

            System.out.println(numberSt + " - " + nameSt);
        }

     }

}
