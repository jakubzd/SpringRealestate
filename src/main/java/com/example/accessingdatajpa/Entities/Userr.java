package com.example.accessingdatajpa.Entities;


import javax.persistence.*;
@Entity
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.JOINED)
public class Userr {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int userID;
    private String name;
    private String email;

    @Column(name = "type", insertable = false, updatable = false)
    protected String type;


    public Userr(){}


        public Userr(String name,  String email){
        this.email = email;
        this.name = name;
        }
        public String getName(){return  name;}

        public String getEmail(){return email;}

        public String getType() {return type;}


    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type){this.type = type;}

}

