package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightBuilder {
    private int flightId;


    public FlightBuilder() {

    }

    public Flight createFlight(LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "Передайте чётное кол-во дат для сегмента");
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i], dates[i + 1]));
        }
        flightId+=1;
        return new Flight(segments,flightId);
    }

     public  List<Flight> createFlights(){
         LocalDateTime threeDaysFromNow = LocalDateTime.now();
         return Arrays.asList(
                 //A normal flight with two hour duration
                 createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                 //A normal multi segment flight
                 createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(1),
                         threeDaysFromNow.plusHours(2), threeDaysFromNow.plusHours(4)),
                 //A flight that departs before it arrives
                 createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(8)),
                 //Departure in the past
                 createFlight(threeDaysFromNow.minusDays(5), threeDaysFromNow),
                 //A flight with more than two hours ground time
                 createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                         threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)));
    }



}
