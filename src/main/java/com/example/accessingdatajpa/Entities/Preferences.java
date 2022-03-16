package com.example.accessingdatajpa.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Preferences {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private int Pref_Id;
        private int price;
        private int size;
        private int nr_of_bedrooms;
        private int nr_of_kitchens;
        private int nr_of_bathrooms;
        private int yearbuilt;
        private int lastPropertyChecked;

        public AppUser getAppuser() {
                return appuser;
        }

        public void setAppuser(AppUser appuser) {
                this.appuser = appuser;
        }

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "userid")
        private AppUser appuser;

        public List<Property> getPropertiesToPref() {
        return propertiesToPref;
        }

        public void setPropertiesToPref(List<Property> propertiesToPref) {
        this.propertiesToPref = propertiesToPref;
        }

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "prefANDprop",joinColumns = @JoinColumn(name = "poi_id"), inverseJoinColumns = @JoinColumn(name = "pref_id"))
        List<Property> propertiesToPref;


        public int getLastPropertyChecked() {
        return lastPropertyChecked;
        }

        public void setLastPropertyChecked(int lastPropertyChecked) {
        this.lastPropertyChecked = lastPropertyChecked;
        }

        public Preferences() {}

        public int getSize() {
            return this.size;
        }

        public int getPrice() {
            return this.price;
        }

        public int getNr_of_bathrooms() {
            return this.nr_of_bathrooms;
        }

        public int getNr_of_bedrooms() {
            return this.nr_of_bedrooms;
        }

        public int getNr_of_kitchens() {
            return this.nr_of_kitchens;
        }

        public int getYearbuilt() {
            return this.yearbuilt;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setNr_of_bathrooms(int nr_of_bathrooms) {
            this.nr_of_bathrooms = nr_of_bathrooms;
        }

        public void setNr_of_bedrooms(int nr_of_bedrooms) {
            this.nr_of_bedrooms = nr_of_bedrooms;
        }

        public void setNr_of_kitchens(int nr_of_kitchens) {
            this.nr_of_kitchens = nr_of_kitchens;
        }

        public void setYearbuilt(int yearbuilt) {
            this.yearbuilt = yearbuilt;
        }

        public String toString(){
                return "Preferences: " + " price: " + this.price +" nr of bedrooms: "+ this.nr_of_bedrooms;
        }
}
