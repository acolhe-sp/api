package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IDonorRepository extends JpaRepository<Donor, Integer> {

    List<Donor> findByCpf(String cpf);

    @Transactional
    @Modifying
    @Query("update tb_donor d set d.cpf_donor = ?2, d.rg_donor = ?3 where ngo.id_ngo = ?1")
    void updateDocumentos(Integer id, String cpf, String rg);

}
