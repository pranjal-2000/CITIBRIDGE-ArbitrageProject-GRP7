package com.example.loginapp.modal;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userlogin")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType
	.AUTO)
	public String username;
	public String password;
	public String name;
	public BigDecimal nseprice;
	public BigDecimal bseprice;
	public BigDecimal difference;
	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
