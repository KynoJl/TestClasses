package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.logging.Filter;

public class Main {
    public static void main(String[] args) {
        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flights = flightBuilder.createFlights();
        FlightFilter flightFilter = new FlightFilter();

        System.out.println("Test flight set" + "\n" + flights);

        System.out.println("Flight with a departure up to the current point in time");
        flightFilter.getDepartureBefore(flights);

        System.out.println("Flight with arrival date less than departure date");
        flightFilter.getArrivalLessDeparture(flights);

        System.out.println("Flight where the total time spent on the ground exceeds two hours ");
        flightFilter.getFlightWithTransferMoreThanTwoHours(flights);

    }
}
