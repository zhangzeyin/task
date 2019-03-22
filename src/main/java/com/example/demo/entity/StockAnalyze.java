package com.example.demo.entity;

import java.util.List;

public class StockAnalyze {
	private String stockName;
	
	private Double avg;
	
	private Double max;
	
	private Double min;
	
	private List<YearDate> yearDates;
	
	private String FourYearsAvg;
	
	private double closingQuotation; // 收盘


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
	
	


	public String getFourYearsAvg() {
		return FourYearsAvg;
	}

	public void setFourYearsAvg(String fourYearsAvg) {
		FourYearsAvg = fourYearsAvg;
	}
	
	

	public double getClosingQuotation() {
		return closingQuotation;
	}

	public void setClosingQuotation(double closingQuotation) {
		this.closingQuotation = closingQuotation;
	}

	public StockAnalyze() {
		super();
	}

	public StockAnalyze(String stockName, Double avg, Double max, Double min, List<YearDate> yearDates,
			String fourYearsAvg, double closingQuotation) {
		super();
		this.stockName = stockName;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.yearDates = yearDates;
		FourYearsAvg = fourYearsAvg;
		this.closingQuotation = closingQuotation;
	}


	
	
	

}
