package org.gcs.cassandra.utils;

import java.util.Objects;

public class Coordinate {
    private final double lat;
    private final double lon;
    private int hashCode;

    public Coordinate(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
        this.hashCode = Objects.hash(lat, lon);
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Coordinate that = (Coordinate) o;
        return lat == that.lat && lon == that.lon;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
