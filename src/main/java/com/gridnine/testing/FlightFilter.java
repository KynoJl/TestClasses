package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class FlightFilter {

    public FlightFilter() {
    }


    public Set<Flight> getDepartureBefore(List<Flight> flights) {
        LocalDateTime nowTime = LocalDateTime.now();
        Set<Flight> flightResult = new HashSet<>();
        List<Segment> segments = new ArrayList<>();
        for (Flight flight : flights ) {
            segments.addAll(flight.getSegments());
            while (segments.size() > 0) {
                LocalDateTime departure = (segments.get(0).getDepartureDate());
                LocalDateTime arrivalTime = (segments.remove(0).getArrivalDate());
                if(departure.isAfter(nowTime)) {
                   showFLight(flight, departure, arrivalTime);
                    flightResult.add(flight);
                }
            }

        }
        return flightResult;
    }

    public Set<Flight> getArrivalLessDeparture(List<Flight> flights) {
        Set<Flight> flightResult = new HashSet<>();
        List<Segment> segments = new ArrayList<>();
        for (Flight flight : flights ) {
            segments.addAll(flight.getSegments());
            while (segments.size() > 0) {
                LocalDateTime departure = (segments.get(0).getDepartureDate());
                LocalDateTime arrival = (segments.remove(0).getArrivalDate());
                if(arrival.isBefore(departure)) {
                    showFLight(flight, departure, arrival);
                    flightResult.add(flight);
                }
            }
        }
        return flightResult;
    }

    public Set<Flight> getFlightWithTransferMoreThanTwoHours(List<Flight> flights) {
        Set<Flight> flightResult = new HashSet<>();
        List<Segment> segments = new ArrayList<>();
        for (Flight flight : flights ) {
            segments.addAll(flight.getSegments());
            if (segments.size() > 0) {
                while (segments.size() > 2) {
                    LocalDateTime arrival = segments.remove(1).getArrivalDate();
                    LocalDateTime departure = segments.remove(1).getDepartureDate();
                    if(departure.isAfter(arrival.plusHours(2))) {
                        showTransfer(flight, arrival, departure);
                        flightResult.add(flight);
                    }
                }
            }
        }
        return flightResult;
    }

    private void showFLight(Flight flight, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        DateTimeFormatter dfmt = getDateFormatter();
        System.out.println("Flight "+ flight.getId() + " Вылет: " + departureDate.format(dfmt) + " Прилёт: " + arrivalDate.format(dfmt));


    }
    private DateTimeFormatter getDateFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }

    private void showTransfer(Flight flight, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        DateTimeFormatter dateTimeFormatter = getDateFormatter();
        System.out.println( "Flight "+ flight.getId()  + "\n" +  dateTimeFormatter.format(arrivalTime) + "\n" + dateTimeFormatter.format(departureTime));
    }
}
