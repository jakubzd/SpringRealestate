package com.example.accessingdatajpa.Controlers;

import com.example.accessingdatajpa.Context;
import com.example.accessingdatajpa.Entities.*;
import com.example.accessingdatajpa.Services.PropertyCSVImporter;
import com.example.accessingdatajpa.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
public class PropertyControler {
    Context context = Context.getInstance();
    @Autowired
    private PropertyRepository propertyRepository;
    public String addHouse(int price, int size, int bedrooms, int bathrooms, int kitchens, int year_buit, int nrOfFloors, Seller seller){
        House house = new House();
        house.setPrice(price);
        house.setSize(size);
        house.setBedrooms(bedrooms);
        house.setBathrooms(bathrooms);
        house.setKitchens(kitchens);
        house.setYear_built(year_buit);
        house.setNr_of_floors(nrOfFloors);
        house.setSeller(seller);
        propertyRepository.save(house);
        return "Saved";
    }
    public String addFlat(int price, int size, int bedrooms, int bathrooms, int kitchens, int year_buit, int floorNr, Seller seller){
        Flat flat = new Flat();
        flat.setPrice(price);
        flat.setSize(size);
        flat.setBedrooms(bedrooms);
        flat.setBathrooms(bathrooms);
        flat.setKitchens(kitchens);
        flat.setYear_built(year_buit);
        flat.setFloor_nr(floorNr);
        flat.setSeller(seller);
        propertyRepository.save(flat);
        return "Saved";
    }
    public List<Property> getAllProperties(){
        return propertyRepository.findAll();
    }
    public List<Property> findPropertyByIdGreaterThan(int id){
        return propertyRepository.findPropertyByIdGreaterThan(id);
    }

    public void loadPropertyFromPath(String path){
        Context context = Context.getInstance();
        PropertyCSVImporter propertyCSVImporter = new PropertyCSVImporter();
        List<String> list = propertyCSVImporter.importFromCSVPath(path);
        for(String line : list){
            String[] lineElements = line.split(";");
            switch (lineElements[0]) {
                case "H":
                    this.addHouse(parseInt(lineElements[1]), parseInt(lineElements[2]), parseInt(lineElements[3]), parseInt(lineElements[4]), parseInt(lineElements[5]), parseInt(lineElements[6]), parseInt(lineElements[7]), (Seller)context.getCurrentUser());

                case "F":
                    this.addFlat(parseInt(lineElements[1]), parseInt(lineElements[2]), parseInt(lineElements[3]), parseInt(lineElements[4]), parseInt(lineElements[5]), parseInt(lineElements[6]), parseInt(lineElements[7]), (Seller)context.getCurrentUser());
            }
        }
    }
}





