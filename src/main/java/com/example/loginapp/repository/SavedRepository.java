package com.example.loginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginapp.modal.SavedStock;
@Repository
public interface SavedRepository extends JpaRepository<SavedStock,String> 
{
}
