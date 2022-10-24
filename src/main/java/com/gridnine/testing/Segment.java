package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Segment {

private LocalDateTime departureDate;
private LocalDateTime arrivalDate;

    public Segment(LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }


    @Override
    public String toString() {
        DateTimeFormatter dfmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Вылет: " + departureDate.format(dfmt) + " Прилёт: " + arrivalDate.format(dfmt);
    }
}
