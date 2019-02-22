package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Stock;
import com.example.demo.entity.StockAnalyze;

public interface StockDao {
	
	int insertStockList(List<Stock> stocks);

	void deleteById(String stockId);
	
	StockAnalyze findStockAnalyze(String stockId);

}
