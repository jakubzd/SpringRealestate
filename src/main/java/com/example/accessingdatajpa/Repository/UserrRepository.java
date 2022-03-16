package com.example.accessingdatajpa.Repository;
import com.example.accessingdatajpa.Entities.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//import net.guides.springboot2.springboot2jpacrudexample.model.Location;
@Repository
public interface UserrRepository extends JpaRepository <Userr, Integer> {
    List<Userr> findUserrByName(String name);
    Userr findTopOneUserrByEmail(String email);
    List<Userr> findUserrByEmail(String email);

}

