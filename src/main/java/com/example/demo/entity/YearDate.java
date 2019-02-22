package com.example.demo.entity;

public class YearDate {
	
	private String year;
	
	private Double yearAvg;
	
	private Double yearMax;
	
	private Double yearMin;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Double getYearAvg() {
		return yearAvg;
	}

	public void setYearAvg(Double yearAvg) {
		this.yearAvg = yearAvg;
	}

	public Double getYearMax() {
		return yearMax;
	}

	public void setYearMax(Double yearMax) {
		this.yearMax = yearMax;
	}

	public Double getYearMin() {
		return yearMin;
	}

	public void setYearMin(Double yearMin) {
		this.yearMin = yearMin;
	}

	public YearDate() {
		super();
	}

	public YearDate(String year, Double yearAvg, Double yearMax, Double yearMin) {
		super();
		this.year = year;
		this.yearAvg = yearAvg;
		this.yearMax = yearMax;
		this.yearMin = yearMin;
	}
	
	

}
