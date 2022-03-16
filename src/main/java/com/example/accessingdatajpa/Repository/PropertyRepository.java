package com.example.accessingdatajpa.Repository;

import com.example.accessingdatajpa.Entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository <Property, Integer> {
        List<Property> findPropertyByIdGreaterThan(int id);
}
