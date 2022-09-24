package com.example.loginapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.loginapp.modal.SavedStock;

@Repository
public interface SavedPgContentRepository extends JpaRepository<SavedStock,String> {
	
	
	@Query(value="SELECT * from savedstock ss where ss.username=?1",nativeQuery=true)
	public List<SavedStock> getsavedstocks(String username);

}
