package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer> {
}
