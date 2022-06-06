package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDonationRepository extends JpaRepository<Donation, Integer> {

    List<Donation> findByDonorId(Integer id);

    List<Donation> findByNgoId(Integer id);

}