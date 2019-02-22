package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Stock;

public interface StockDao {
	
	int insertStockList(List<Stock> stocks);

	void deleteById(String stockId);

}
