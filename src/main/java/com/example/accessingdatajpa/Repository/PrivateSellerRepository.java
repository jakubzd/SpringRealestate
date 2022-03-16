package com.example.accessingdatajpa.Repository;

import com.example.accessingdatajpa.Entities.PrivateSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateSellerRepository extends JpaRepository<PrivateSeller, Integer> {
}
