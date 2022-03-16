package com.example.accessingdatajpa.Entities;

import javax.persistence.Entity;

@Entity
public class School extends POI{
    private String School_name;

    public School() {}

    public void setSchool_name(String school_name) {
        this.School_name = school_name;
    }

    public String getSchool_name() {
        return this.School_name;
    }
}
