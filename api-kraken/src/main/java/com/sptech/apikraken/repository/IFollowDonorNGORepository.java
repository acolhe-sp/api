package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.FollowDonorNGO;
import com.sptech.apikraken.entity.keys.FollowKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFollowDonorNGORepository extends JpaRepository<FollowDonorNGO, FollowKey> {
}
