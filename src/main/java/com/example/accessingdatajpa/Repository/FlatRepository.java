package com.example.accessingdatajpa.Repository;

import com.example.accessingdatajpa.Entities.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends JpaRepository <Flat, Integer> {
}
