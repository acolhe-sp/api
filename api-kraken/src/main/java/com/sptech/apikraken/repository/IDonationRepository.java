package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDonationRepository extends JpaRepository<Donation, Integer> {
}
