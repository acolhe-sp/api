package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Integer> {
}
