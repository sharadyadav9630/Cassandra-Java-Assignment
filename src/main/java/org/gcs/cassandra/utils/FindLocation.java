package org.gcs.cassandra.utils;

import java.util.HashMap;
import java.util.Map;

public class FindLocation {

    public static Coordinate getLatAndLong(String locationName){
        Map<String,Coordinate> map = new HashMap<>();

        map.put("Glasgow",new Coordinate(55.864239,-4.251806));
        map.put("Edinburgh",new Coordinate(55.953251,-3.188267));
        map.put("Aberdeen",new Coordinate(57.149715,-2.094278));
        map.put("Hamilton",new Coordinate(43.255722,-79.871101));
        map.put("Falkirk",new Coordinate(56.001877,-3.783913));
        map.put("Cambuslang",new Coordinate(55.814941,-4.166450));
        map.put("India",new Coordinate(20.593683,78.962883));
        map.put("Chennai",new Coordinate(13.082680,80.270721));
        map.put("Nepal",new Coordinate(28.394857,84.124008));
        map.put("India Ocean",new Coordinate(-28.3948569,84.12400777777778));

        return map.get(locationName);
    }

    public static String getLocation(double lat,double lon){
        Map<Coordinate,String> map = new HashMap<>();

        map.put(new Coordinate(55.864239,-4.251806),"55N,4E");
        map.put(new Coordinate(55.953251,-3.188267),"55N,3W");
        map.put(new Coordinate(57.149715,-2.094278),"57N,2W");
        map.put(new Coordinate(43.255722,-79.871101),"43N,79W");
        map.put(new Coordinate(56.001877,-3.783913),"56N,3E");
        map.put(new Coordinate(55.814941,-4.166450),"55N,4W");
        map.put(new Coordinate(20.593683,78.962883),"20N,78E");
        map.put(new Coordinate(13.082680,80.270721),"13N,80E");
        map.put(new Coordinate(28.394857,84.124008),"28N,84E");
        map.put(new Coordinate(-28.3948569,84.12400777777778),"28S,84E");

        return map.get(new Coordinate(lat,lon));
    }

}
