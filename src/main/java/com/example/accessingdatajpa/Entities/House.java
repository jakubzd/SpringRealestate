package com.example.accessingdatajpa.Entities;

import javax.persistence.Entity;

@Entity
public class House extends Property{
    private int nr_of_floors;

    public House() {}

    public void setNr_of_floors(int nr_of_floors) {
        this.nr_of_floors = nr_of_floors;
    }

    public int getNr_of_floors() {
        return this.nr_of_floors;
    }
}
