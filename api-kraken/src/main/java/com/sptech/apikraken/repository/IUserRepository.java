package com.sptech.apikraken.repository;

import com.sptech.apikraken.dto.UserDTO;
import com.sptech.apikraken.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    List<User> findByEmail(String email);

    User findByEmailAndPassword(String email, String pass);



}
