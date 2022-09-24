/*package com.example.loginapp.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import com.example.loginapp.modal.*;
import com.example.loginapp.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginServiceImpl implements LoginService {
@Autowired
LoginRepository loginRepository;

@Override
public ArrayList<User> findAllUsers(){
	return(ArrayList<User>)loginRepository.findAll();
}

@Override
public boolean findAllUsersByUsername(String username, String password) {
	Optional<User>opt=loginRepository.findById(username);
	System.out.println();
	if(opt.isPresent()) {
		if(password.equals(opt.get().getPassword()))
			return true;
		else
			return false;
					
				
		
	}else {
		return false;
	}
}

public void addUser() {
	ArrayList<User> user=new ArrayList<User>();
	user.add(new User("jeet.shah","jeet@123"));
	for(User obj:user) {
		loginRepository.save(obj);
	}
}
}*/
