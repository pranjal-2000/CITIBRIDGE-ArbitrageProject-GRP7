package com.example.stockData.Service;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.lang.Math;
import com.example.stockData.Model.StockObject;

public class ArbitrageImp 
{
	ArrayList<String> stockList=new ArrayList<String>(List.of("BAJFINANCE","TATASTEEL","RELIANCE","ICICIBANK","MARUTI","WIPRO","HDFC","TITAN","TCS","TATAMOTORS","RBLBANK","DMART","BANKBARODA","NAUKRI","SIEMENS","BATAINDIA"));
	public List<StockObject> opportunity() 	{  
		//calculate arbitrage opportunity
		try
		{
			BigDecimal priceN,priceB,diff,diff_per,zero;
			zero=BigDecimal.ZERO;
			String name,stock_nse,stock_bse;
			List<StockObject> opportunities=new ArrayList<StockObject>();
			StockService stockService=new StockService();
			System.out.println("Company"+"\t"+"NSE Price"+"\t"+"BSE Price"+"\t"+"Difference");
			for(int i=0;i<stockList.size();i++)
			{
				name=stockList.get(i);
				stock_nse=name+".NS";        // nse stock
				stock_bse=name+".BO";        //bse stock
				StockObject stockn=stockService.searchStock(stock_nse);
				StockObject stockb=stockService.searchStock(stock_bse);
				priceN=stockService.findPrice(stockn);
				priceB=stockService.findPrice(stockb);
				diff=(priceN.subtract(priceB)).abs();
				if(diff.compareTo(zero)!=0)
				{
					StockObject arb_opp=new StockObject(name,priceN,priceB,diff);
					opportunities.add(arb_opp);
					//System.out.print(st+"\t"+priceN+"\t"+priceB+"\t"+diff);
					//System.out.println();
				}
			}
			Collections.sort(opportunities,StockObject.DiffPriceComparator);
			return opportunities;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
    }
}