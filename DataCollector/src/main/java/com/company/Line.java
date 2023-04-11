package com.company;

public class Line implements Comparable<Line>{
    private String name;
    private String number;

    public Line(String name, String number){
        this.name = name;
        this.number = number;
    }

    public String getName(){return name;}

    public String getNumber() {return number;}

    @Override
    public String toString(){
        return "Линия = " + name + ", Номер линии = " + number;
    }

    @Override
    public  int compareTo(Line line){
        int stationComparison = number.compareTo(line.getNumber());
        if(stationComparison != 0){
            return stationComparison;
        }
        return name.compareToIgnoreCase(line.getName());
    }
}
