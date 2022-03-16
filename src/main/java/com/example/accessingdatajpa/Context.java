package com.example.accessingdatajpa;

import com.example.accessingdatajpa.Entities.Property;
import com.example.accessingdatajpa.Entities.Userr;

import java.util.ArrayList;

public class Context {
    public Userr getCurrentUser() {
        return currentUser;
    }

    public ArrayList<Property> getPropertiesToProcess() {
        return propertiesToProcess;
    }

    public void setCurrentUser(Userr currentUser) {
        this.currentUser = currentUser;
    }

    public void setPropertiesToProcess(ArrayList<Property> propertiesToProcess) {
        this.propertiesToProcess = propertiesToProcess;
    }

    private Userr currentUser;
    private ArrayList<Property> propertiesToProcess;

    private static final Context INSTANCE = new Context();

    private Context() {
    }

    public static Context getInstance() {
        return INSTANCE;
    }


}
