package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.FollowDonorNGO;
import com.sptech.apikraken.entity.keys.FollowKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFollowDonorNGORepository extends JpaRepository<FollowDonorNGO, FollowKey> {

    long countByDonorId(Integer id);

    List<FollowDonorNGO> findAllByDonorId(Integer id);

}
