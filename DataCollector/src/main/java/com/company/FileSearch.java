package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class FileSearch {
    private  String path;
    List<String> array = new ArrayList<>();

    public FileSearch(String path){
        this.path = path;
    }

    public  List<String > search(String text){
        File file = new File(text);
        if(file.isFile()){
            if(text.contains(".json") || text.contains(".csv")){
                array.add(String.valueOf(file.getAbsoluteFile()));
            }
        }else {
            for(File f : file.listFiles()){
                search(f.getPath());
            }
        }
        return array;
    }
    public String unpacking() throws IOException {
        File f = new File(path);
        String from = f.getName();
        int i = from.indexOf(".");
        String out = Path.of(path).getParent() + "/" + from.substring(0, i) + "/";

        FileInputStream inputStream = new FileInputStream(path);
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        while(true){
            ZipEntry entry = zipInputStream.getNextEntry();
            if(entry == null){
                break;
            }
            File file = new File(out + entry.getName());
            if(entry.getName().contains("__MACOSX")){
                continue;
            }
            if(entry.isDirectory()){
                file.mkdirs();
            }else {
                byte[] bytes = zipInputStream.readAllBytes();
                Files.write(Path.of(file.getAbsolutePath()), bytes, StandardOpenOption.CREATE);
            }
        }
        String end = Path.of(path).getParent() + "/" + from.substring(0,i);
        return end;
    }
}
