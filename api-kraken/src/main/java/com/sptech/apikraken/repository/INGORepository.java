package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.NGO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface INGORepository extends JpaRepository<NGO, Integer> {

    List<NGO> findByCnpj(String cnpj);

    @Transactional
    @Modifying
    @Query("update tb_ngo ngo set ngo.description_ngo = ?2 where ngo.id_ngo = ?1")
    void updateDescription(Integer id, String newDesc);

}
