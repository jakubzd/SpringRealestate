package com.example.accessingdatajpa.Repository;

import com.example.accessingdatajpa.Entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
}
