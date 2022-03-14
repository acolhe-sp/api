package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDonorRepository extends JpaRepository<Donor, Integer> {

    List<Donor> findByCpf(String cpf);

}
