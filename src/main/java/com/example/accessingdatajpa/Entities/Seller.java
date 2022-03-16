package com.example.accessingdatajpa.Entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Seller extends Userr {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
    private List<Property> propertiesForSale;
    public Seller() {}

    public List<Property> getPropertiesForSale() {
        return propertiesForSale;
    }

    public void setPropertiesForSale(List<Property> propertiesForSale) {
        this.propertiesForSale = propertiesForSale;
    }



}
