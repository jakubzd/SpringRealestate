package com.example.accessingdatajpa.Entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class POI {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getPOI_Point() {
        return POI_Point;
    }

    public void setPOI_Point(Point POI_Point) {
        this.POI_Point = POI_Point;
    }

    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Point POI_Point;
    public POI() {}
}
