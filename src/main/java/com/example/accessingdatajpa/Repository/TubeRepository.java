package com.example.accessingdatajpa.Repository;

import com.example.accessingdatajpa.Entities.Tube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TubeRepository extends JpaRepository<Tube, Integer>{
}
