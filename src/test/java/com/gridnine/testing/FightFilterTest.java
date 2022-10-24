package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;



public class FightFilterTest {
    private FlightBuilder flightBuilder =new FlightBuilderTest();
    private FlightFilter flightFilter = new FlightFilter();

    private List<Flight> flights = flightBuilder.createFlights();

    @Test
    public void getDepartureTimeBeforeNow() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(2, flightFilter.getDepartureBefore(flights).size() );
    }

    @Test
    public void getArrivalDateLessDepartureDate() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(2, flightFilter.getArrivalLessDeparture(flights).size() );
    }

    @Test
    public void getFlightWithTransferMoreThanTwoHours() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(1, flightFilter.getFlightWithTransferMoreThanTwoHours(flights).size() );
    }
}
