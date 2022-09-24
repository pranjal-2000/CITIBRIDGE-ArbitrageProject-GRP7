package com.example.loginapp.repository;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginapp.modal.*;
@Repository
public interface LoginRepository extends JpaRepository<User,String> {

	User findByUsername(String username);
}
