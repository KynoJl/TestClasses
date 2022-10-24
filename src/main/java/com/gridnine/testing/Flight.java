package com.gridnine.testing;

import java.util.List;

public class Flight {

    private List<Segment> segments;
    private int id = 0;

    public Flight(List<Segment> segments,int id) {
        this.segments = segments;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return "Flight "+id+ " {"  +
                "segments" +"(" + segments.size() + ") = "  + segments +
                '}' + "\n";
    }
}
