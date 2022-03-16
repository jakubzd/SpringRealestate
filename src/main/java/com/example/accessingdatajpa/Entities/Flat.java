package com.example.accessingdatajpa.Entities;

import javax.persistence.Entity;

@Entity
public class Flat extends Property{
    private int floor_nr;

    public Flat() {}

    public void setFloor_nr(int floor_nr) {
        this.floor_nr = floor_nr;
    }

    public int getFloor_nr() {
        return this.floor_nr;
    }
}

