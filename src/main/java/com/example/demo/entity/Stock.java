package com.example.demo.entity;

import java.util.Date;

public class Stock {

	private String stockName;

	private String stockCode;
	
	private Date time;

	private double openingQuotation; // 开盘

	private double closingQuotation; // 收盘

	private double theHighest; // 最高

	private double lowest; // 最低

	private long turnover; // 成交量

	private long volumeOfTransaction; // 成交额

	private double amplitude; // 振幅
	
	private String stockId;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public double getOpeningQuotation() {
		return openingQuotation;
	}

	public void setOpeningQuotation(double openingQuotation) {
		this.openingQuotation = openingQuotation;
	}

	public double getClosingQuotation() {
		return closingQuotation;
	}

	public void setClosingQuotation(double closingQuotation) {
		this.closingQuotation = closingQuotation;
	}

	public double getTheHighest() {
		return theHighest;
	}

	public void setTheHighest(double theHighest) {
		this.theHighest = theHighest;
	}

	public double getLowest() {
		return lowest;
	}

	public void setLowest(double lowest) {
		this.lowest = lowest;
	}

	public long getTurnover() {
		return turnover;
	}

	public void setTurnover(long turnover) {
		this.turnover = turnover;
	}

	public long getVolumeOfTransaction() {
		return volumeOfTransaction;
	}

	public void setVolumeOfTransaction(long volumeOfTransaction) {
		this.volumeOfTransaction = volumeOfTransaction;
	}

	public double getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}
	
	

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public Stock() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Stock(String stockName, String stockCode,Date time,double openingQuotation, double closingQuotation,
			double theHighest, double lowest, long turnover, long volumeOfTransaction, double amplitude, String stockId) {
		super();
		this.stockName = stockName;
		this.stockCode = stockCode;
		this.openingQuotation = openingQuotation;
		this.closingQuotation = closingQuotation;
		this.theHighest = theHighest;
		this.lowest = lowest;
		this.turnover = turnover;
		this.volumeOfTransaction = volumeOfTransaction;
		this.amplitude = amplitude;
		this.time = time;
		this.stockId =stockId;
	}
	
	

}
