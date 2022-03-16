package com.example.accessingdatajpa.Entities;

import javax.persistence.Entity;

@Entity
public class Tube extends POI{
    private String stationName;

    public Tube() {}

    public String getStation_name() {
        return this.stationName;
    }

    public void setStation_name(String station_name) {
        this.stationName = station_name;
    }
}
