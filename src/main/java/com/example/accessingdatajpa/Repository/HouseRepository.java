package com.example.accessingdatajpa.Repository;

import com.example.accessingdatajpa.Entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository <House, Integer>{
}
