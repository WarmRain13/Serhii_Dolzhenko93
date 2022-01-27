import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        List<Flight> flightList = new ArrayList<>();


        for(Terminal terminal: airport.getTerminals()){
            List<Flight> flightStream = terminal.getFlights().stream()
                    .filter(f -> (f.getDate().getTime() <= System.currentTimeMillis() + 7200000) && (f.getDate().getTime()>= System.currentTimeMillis()))
                    .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                    .collect(Collectors.toList());
            flightList.addAll(flightStream);
        }
        System.out.println("Рейсы, вылетающие в ближайшие 2 часа: " + flightList);

        return flightList;
    }

}