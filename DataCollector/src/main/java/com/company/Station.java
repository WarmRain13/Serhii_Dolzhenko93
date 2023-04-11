package com.company;

public class Station implements Comparable<Station>{
    private String name;
    private String numberLine;
    private String depth;
    private String date;
    private boolean hasConnection = false;

    public Station(String name, String numberLine){
        this.name = name;
        this.numberLine = numberLine;
    }

    public String getNumberLine(){
        return numberLine;
    }

    public boolean isHasConnection(){
        return hasConnection;
    }

    public  void setHasConnection(boolean hasConnection){
        this.hasConnection = hasConnection;
    }

    public String getDate(){
        return date;
    }

    public String getDepth(){
        return depth;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setDepth(String depth){
        this.depth = depth;
    }

    public  String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Станция = " +name;
    }

    @Override
    public int compareTo(Station station)
    {
        int lineComparison = numberLine.compareTo(station.getNumberLine());
        if(lineComparison != 0){
            return lineComparison;
        }
        return name.compareToIgnoreCase(station.getName());
    }
}
