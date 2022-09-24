package com.example.stockData.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import yahoofinance.Stock;

@Getter
@With
@AllArgsConstructor
public class StockObject 
{
	private Stock stock;
	private LocalDateTime lastAccessTime;
	private String company_name;
	private BigDecimal nse_price;
	private BigDecimal bse_price;
	private BigDecimal diff;
	
	public StockObject(Stock stock)
	{
		this.stock=stock;
	}
	
	public StockObject(String name,BigDecimal nse,BigDecimal bse,BigDecimal difference)
	{
		this.company_name=name;
		this.nse_price=nse;
		this.bse_price=bse;
		this.diff=difference;
		lastAccessTime=LocalDateTime.now();
	}

	public Stock getStock() {
		return stock;
	}

	public LocalDateTime getLastAccessTime() {
		return lastAccessTime;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public void setLastAccessTime(LocalDateTime lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public void setNse_price(BigDecimal nse_price) {
		this.nse_price = nse_price;
	}

	public void setBse_price(BigDecimal bse_price) {
		this.bse_price = bse_price;
	}

	public void setDiff(BigDecimal diff) {
		this.diff = diff;
	}

	public BigDecimal getNse_price() {
		return nse_price;
	}

	public BigDecimal getBse_price() {
		return bse_price;
	}

	public BigDecimal getDiff() {
		return diff;
	}
	public static Comparator<StockObject> DiffPriceComparator = new Comparator<StockObject>() {
			public int compare(StockObject s1, StockObject s2) {
  
            // descending order
            // return
			//BigDecimal d1=s1.diff;
			//BigDecimal d2=s2.diff;
			//BigDecimal d=d2.subtract(d1);
			//int compare=d.intValue();
            return s2.diff.compareTo(s1.diff);
        }
	};
}
