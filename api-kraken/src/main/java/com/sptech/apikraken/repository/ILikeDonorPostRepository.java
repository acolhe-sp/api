package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.LikeDonorPost;
import com.sptech.apikraken.entity.keys.LikeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeDonorPostRepository extends JpaRepository<LikeDonorPost, LikeKey> {

    Long countByPostNgoId(Integer id);

}
