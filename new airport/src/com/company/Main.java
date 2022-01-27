package com.company;
import com.skillbox.airport.*;

public class Main {

    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        airport.getAllAircrafts();
        int quantity = airport.getAllAircrafts().size();

        System.out.println("Количество самолетов: " + quantity);
        System.out.println("Список самолетов: " + airport.getAllAircrafts());
    }
}
