package com.example.demo.util;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.dao.StockDao;
import com.example.demo.entity.StockAnalyze;


public class MyThread extends Thread {
	private String name;

    private XSSFWorkbook  wb;
    
    private String []title ;

    private List<StockAnalyze> c;
    private StockDao stockDao;

    @Override
    public void run() {

    List<StockAnalyze> list = stockDao.findAll();
    String [][]values = new String[50000][];

       for(int i=0;i<50000;i++){
            values[i] = new String[title.length];
            //将对象内容转换成string
            StockAnalyze obj = list.get(i);
            values[i][0] = obj.getStockName();
            values[i][1] = obj.getAvg()+"";//付款金额
       
            values[i][2] =obj.getMax()+"";//付款时间
            values[i][3] = obj.getMin()+"";//确认人
        }
       
    	   ExcelUtil.getHSSFWorkbook(name, title, values, wb);
           
           c.add(new StockAnalyze());
    }

	public MyThread(String name, XSSFWorkbook  wb, String[] title, StockDao stockDao, List<StockAnalyze> c) {
		super();
		this.name = name;
		this.wb = wb;
		this.title = title;
		this.stockDao = stockDao;
		this.c=c;
	}
    
    
    
}
