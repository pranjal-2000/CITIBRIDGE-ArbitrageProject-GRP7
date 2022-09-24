package com.example.loginapp.modal;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="savedstock")
public class SavedStock 
{
	public String username;
	public String name;
	public BigDecimal nseprice;
	public BigDecimal bseprice;
	public BigDecimal difference;
	@Id
	@GeneratedValue(strategy=GenerationType
	.AUTO)
	public int id;
	public SavedStock() {
		super();
	}
	public SavedStock(String username, String name, BigDecimal nseprice, BigDecimal bseprice, BigDecimal difference) {
		super();
		this.username = username;
		this.name = name;
		this.nseprice = nseprice;
		this.bseprice = bseprice;
		this.difference = difference;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getNseprice() {
		return nseprice;
	}
	public void setNseprice(BigDecimal nseprice) {
		this.nseprice = nseprice;
	}
	public BigDecimal getBseprice() {
		return bseprice;
	}
	public void setBseprice(BigDecimal bseprice) {
		this.bseprice = bseprice;
	}
	public BigDecimal getDifference() {
		return difference;
	}
	public void setDifference(BigDecimal difference) {
		this.difference = difference;
	}
}
