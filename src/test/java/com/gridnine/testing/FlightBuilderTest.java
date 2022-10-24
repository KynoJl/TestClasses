package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FlightBuilderTest extends FlightBuilder {

    @Override
    public List<Flight> createFlights(){
        LocalDateTime threeDaysFromNow = LocalDateTime.now();
        return Arrays.asList(
                //A normal flight with two hour duration
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(4)),
                //A normal multi segment flight
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(1),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(4)),
                //A flight that departs before it arrives
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(8)),
                //Departure in the past
                createFlight(threeDaysFromNow.minusDays(3), threeDaysFromNow),
                //A flight with more than two hours ground time
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(1), threeDaysFromNow.plusHours(3)));
    }

}
