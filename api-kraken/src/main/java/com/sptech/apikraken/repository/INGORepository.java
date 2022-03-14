package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.NGO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INGORepository extends JpaRepository<NGO, Integer> {

    List<NGO> findByCnpj(String cnpj);

}
