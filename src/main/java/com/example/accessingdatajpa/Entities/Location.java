package com.example.accessingdatajpa.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int LocationID;
    private String City;
    private String PostalArea;
    private String PostCode;
    private String County;

    public Location(){}

    public Location(String City, String PostalArea, String PostCode, String County){
        this.City = City;
        this.PostalArea = PostalArea;
        this.PostCode = PostCode;
        this.County = County;
    }

    public String getCity() {
        return City;
    }

    public String getCounty() {
        return County;
    }

    public String getPostalArea() {
        return PostalArea;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setCounty(String county) {
        County = county;
    }

    public void setPostalArea(String postalArea) {
        PostalArea = postalArea;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }
}

