package com.example.stockData.Service;
import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.stockData.Model.StockObject;

import lombok.AllArgsConstructor;
import yahoofinance.YahooFinance;

@AllArgsConstructor
@Service
public class StockService
{
	public StockObject searchStock(final String ticker)
	{
		try
		{
			return new StockObject(YahooFinance.get(ticker));
		}
		catch(IOException e)
		{
			System.out.println("Error");
		}
		return null;
	}
	public BigDecimal findPrice(final StockObject stock) throws IOException
	{
		//get Stock from Yahoo finance API
		return stock.getStock().getQuote(true).getPrice();
	}

}

