package com.example.accessingdatajpa;

import com.example.accessingdatajpa.Controlers.UserController;
import com.example.accessingdatajpa.Entities.Userr;
import com.example.accessingdatajpa.Repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.accessingdatajpa.Controlers.MenuControler;

import java.util.List;

@Component
class RealestateRunner implements CommandLineRunner {

    @Autowired
    private UserController uc;
    Context context;
    @Autowired
    private MenuControler mc;
    UserrRepository userrRepository;


    @Override
    public void run(String... args) {
        mc.runMenu();
        uc.addNewUser("lol", "cc@d.dba", "Seller");
        uc.addNewUser("bb", "pog@champ.com", "AppUser");
        List <Userr> allUsers = uc.getAllUsers();
        List <Userr> usersByName = uc.findUserrByName("aa");
    }
}
