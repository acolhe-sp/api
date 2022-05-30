package com.sptech.apikraken.repository;

import com.sptech.apikraken.dto.response.ngo.NGOComplete;
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

    NGO findByUserId(Integer id);

    @Query("select new com.sptech.apikraken.dto.response.ngo.NGOComplete" +
            "(n.id, n.user.id, n.user.img, n.user.name, n.user.email, n.user.address, n.user.userType, n.cnpj, n.description, n.category, n.assessment) " +
            "from NGO n where n.category.id = ?1 order by n.assessment desc")
    List<NGOComplete> consultaNGOCompletePelaCategory(Integer categoria);

    @Query("select new com.sptech.apikraken.dto.response.ngo.NGOComplete" +
            "(n.id, n.user.id, n.user.img, n.user.name, n.user.email, n.user.address, n.user.userType, n.cnpj, n.description, n.category, n.assessment) " +
            "from NGO n where n.id = ?1")
    NGOComplete getNGOCompleteById(Integer id);

    @Query("select new com.sptech.apikraken.dto.response.ngo.NGOComplete" +
            "(n.id, n.user.id, n.user.img, n.user.name, n.user.email, n.user.address, n.user.userType, n.cnpj, n.description, n.category, n.assessment) " +
            "from NGO n order by n.assessment desc")
    List<NGOComplete> consultaNGOComplete();

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query("update NGO n set n.description = ?2 where n.id = ?1")
    void updateDescription(Integer id, String newDesc);

}
