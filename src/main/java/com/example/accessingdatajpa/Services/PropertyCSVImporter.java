package com.example.accessingdatajpa.Services;

import java.util.ArrayList;
import java.util.List;

public class PropertyCSVImporter {

    public List<String> importFromCSVPath(String path){
        List<String> l = new ArrayList<>();
        l.add("H;352000;5000;2;1;1;2002;3;2");
        l.add("F;166000;5000;2;1;1;2001;1;5");
        return l;
    }

}
