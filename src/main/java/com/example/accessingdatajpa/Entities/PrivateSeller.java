package com.example.accessingdatajpa.Entities;

import javax.persistence.Entity;

@Entity
public class PrivateSeller extends Seller{
    private String last_name;

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
