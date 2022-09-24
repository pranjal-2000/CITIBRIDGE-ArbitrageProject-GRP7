package com.example.loginapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginapp.modal.SavedStock;
import com.example.loginapp.modal.User;
import com.example.loginapp.repository.LoginRepository;
import com.example.loginapp.repository.SavedPgContentRepository;
import com.example.loginapp.repository.SavedRepository;
import com.example.stockData.Model.StockObject;
import com.example.stockData.Service.ArbitrageImp;
//import com.example.loginapp.service.LoginServiceImpl;
@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginRepository repo;
	
	@Autowired
	private SavedRepository repo1;
	
	@Autowired
	private SavedPgContentRepository repo2;
	
	User curruser=new User();
	//LoginServiceImpl loginServiceImpl;
	
	/*@PostMapping("/")
	public void add() {
		loginServiceImpl.addUser();
 }*/
	
	/*@GetMapping("/findbyusername/{username}/{password}")
	public boolean getUsersUsingUsername(@PathVariable String username , @PathVariable String password) {
		return loginServiceImpl.findAllUsersByUsername(username,password);
	}*/
	
	/*@GetMapping("/findall")
	public ArrayList<User> getAllUsers() {
		return loginServiceImpl.findAllUsers();
	}*/
	
	
	@PostMapping("/user/login")
	public ResponseEntity<?> loginUser(@RequestBody User userData)
	{
		curruser=userData;
		System.out.println(userData);
		User user=repo.findByUsername(userData.username);
		if(user.getPassword().equals(userData.password))
		{
			return ResponseEntity.ok(user);
		}
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}
	
	
	@GetMapping("/mainpg")
	@ResponseBody
	public List<StockObject> showData()
	{
		ArbitrageImp opp=new ArbitrageImp();
		List<StockObject> stocklist=opp.opportunity();
		System.out.println("ok");
		return stocklist;
	}

	@PostMapping("/save")
	public ResponseEntity<?> addStock(@RequestBody SavedStock st)
	{
		st.username=curruser.username;
		repo1.save(st);
		System.out.println("saved");
		String res="ok";
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/findstock")
	public List<SavedStock> findstock()
	{
		List<SavedStock> savedOpt=repo2.getsavedstocks(curruser.username);
		System.out.println(curruser.username);
		System.out.println(savedOpt.size());
		return savedOpt;
	}
}
