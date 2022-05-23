package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IDonorRepository extends JpaRepository<Donor, Integer> {

    List<Donor> findByCpf(String cpf);

    Donor findByUserId(Integer id);

    @Transactional
    @Modifying
    @Query("update Donor d set d.cpf = ?2, d.rg = ?3 where d.id = ?1")
    void updateDocuments(Integer id, String cpf, String rg);

    @Transactional
    @Modifying
    @Query("update Donor d set d.notifications = ?2 where d.id = ?1")
    void updateNotifications(Integer id, List<Post> notifications);

}
