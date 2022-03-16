package com.example.accessingdatajpa.Entities;

import javax.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Property extends POI{

    private int price;
    private int size;
    private int bedrooms;
    private int bathrooms;
    private int kitchens;
    private int year_built;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private Seller seller;

    @ManyToMany(mappedBy = "propertiesToPref")
    List<Preferences> preferences;
    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setKitchens(int kitchens) {
        this.kitchens = kitchens;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public void setSize(int size) {
        this.size = size;
    }

    public void setYear_built(int year_built) {
        this.year_built = year_built;
    }


    public int getBathrooms() {
        return bathrooms;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getKitchens() {
        return kitchens;
    }

    public int getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public int getYear_built() {
        return year_built;
    }

    public String toString(){
        return "Property: "+ "size: " + this.size + "m^2, " + " bedrooms: "+ this.bedrooms + ", price: " + this.price +" $";
    }
}
