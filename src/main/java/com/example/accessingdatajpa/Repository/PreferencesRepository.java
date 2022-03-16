package com.example.accessingdatajpa.Repository;

import com.example.accessingdatajpa.Entities.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferencesRepository extends JpaRepository<Preferences, Integer> {
}
