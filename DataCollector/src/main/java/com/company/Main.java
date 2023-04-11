package com.company;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args)throws IOException {
        String url = "https://skillbox-java.github.io/";
        WebParser webParser = new WebParser(url);
        webParser.parsePage();

        FileSearch fileSearch = new FileSearch("E:\\Skillbox\\stations-data.zip");
        String unZip = fileSearch.unpacking();
        List<String> listSearch = fileSearch.search(unZip);

        for (String path : listSearch) {
            if (path.contains(".json")) {
                JsonParser jsonParser = new JsonParser(path, webParser.getArray());
                jsonParser.parseUpdateInfo();
                // jsonParser.parsePrint();
            }
            if (path.contains(".csv")) {
                ParseCSV parseCSV = new ParseCSV(path, webParser.getArray());
                parseCSV.parseUpdateInfo();
                // parseCSV.parsePrint();
            }
        }

        WriteJSONFile writeJSONFile = new WriteJSONFile(webParser.getArray(), webParser.getInfoStation());
        writeJSONFile.writeStation();
        writeJSONFile.writeMap();
    }


}
