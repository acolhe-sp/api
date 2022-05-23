package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByNgoIdOrderByIdDesc(Integer id);

}
