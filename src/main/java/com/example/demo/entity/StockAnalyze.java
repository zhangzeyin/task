package com.example.demo.entity;

import java.util.List;

public class StockAnalyze {
	private String stockName;
	
	private Double avg;
	
	private Double max;
	
	private Double min;
	
	private List<YearDate> yearDates;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	
	public List<YearDate> getYearDates() {
		return yearDates;
	}

	public void setYearDates(List<YearDate> yearDates) {
		this.yearDates = yearDates;
	}


	public StockAnalyze() {
		super();
	}

	public StockAnalyze(String stockName, Double avg, Double max, Double min, List<YearDate> yearDates) {
		super();
		this.stockName = stockName;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.yearDates = yearDates;
	}
	
	
	

}
