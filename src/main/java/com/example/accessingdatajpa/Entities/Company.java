package com.example.accessingdatajpa.Entities;

import javax.persistence.Entity;

@Entity
public class Company extends Seller{
    private String company_name;

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_name() {
        return company_name;
    }

}
