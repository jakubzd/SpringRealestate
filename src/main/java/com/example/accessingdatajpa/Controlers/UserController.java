package com.example.accessingdatajpa.Controlers;

import com.example.accessingdatajpa.Context;
import com.example.accessingdatajpa.Entities.*;
import com.example.accessingdatajpa.Repository.PreferencesRepository;
import com.example.accessingdatajpa.Repository.PropertyRepository;
import com.example.accessingdatajpa.Repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@Controller
public class UserController {

	@Autowired
	private PropertyRepository propertyRepository;
	@Autowired
	private UserrRepository userrRepository;
	@Autowired
	private PreferencesRepository preferencesRepository;
	Context context;
	public UserController(){
		this.context = Context.getInstance();
	}

	public Userr addNewUser (String name, String email, String type) {
		if(type.equals("Seller")){
			Seller n = new Seller();
			n.setName(name);
			n.setEmail(email);
			n.setType("Seller");
			userrRepository.save(n);
			return n;
		}
		else if(type.equals("AppUser")){
			AppUser n = new AppUser();
			n.setName(name);
			n.setEmail(email);
			n.setType("AppUser");
			userrRepository.save(n);
			return n;
		}
		else return null;
	}
	public List<Userr> getAllUsers() {
		return userrRepository.findAll();
	}
	public List<Userr> findUserrByName(String name){
		return userrRepository.findUserrByName(name);
	}

	public Preferences addNewPreference(int price, int nr_of_bedrooms){
		Preferences p = new Preferences();
		p.setNr_of_bedrooms(nr_of_bedrooms);
		p.setAppuser(((AppUser)context.getCurrentUser()));
		p.setPrice(price);
		preferencesRepository.save(p);
		AppUser user = ((AppUser)context.getCurrentUser());
		user.getPreferences().add(p);
		userrRepository.save(user);
		return p;
	}
	public List<Property> propertiesEvaluation(List<Property> propertiesToEvaluate, Preferences preference){
		if(propertiesToEvaluate.size() == 0){return null;}
		List<Property> evaluatedProperties = new ArrayList<Property>();
		int index = (propertiesToEvaluate.get(propertiesToEvaluate.size()-1)).getId();
		preference.setLastPropertyChecked(index);
		for(Property property : propertiesToEvaluate){
			if(property.getBedrooms() >= preference.getNr_of_bedrooms() && property.getPrice() <= preference.getPrice()){
				evaluatedProperties.add(property);
			}
		}
		preference.setPropertiesToPref(evaluatedProperties);
		preferencesRepository.save(preference);
		return evaluatedProperties;
	}
}
