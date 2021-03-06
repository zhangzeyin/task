package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.dao.StockDao;
import com.example.demo.entity.Stock;
import com.example.demo.entity.StockAnalyze;
import com.example.demo.entity.YearDate;
import com.example.demo.util.HttpRestUtil;
import com.example.demo.util.MyThread;

@Controller
public class StockController {

	private static final String FIND_STOCK = "/findStock";

	@Autowired
	private StockDao stockDao;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(FIND_STOCK)
	@ResponseBody
	private boolean findStock(String stockid, String stockName)
			throws IOException, NumberFormatException, ParseException {

		try {
			stockDao.deleteById(stockid);
			
			String url = "http://pdfm.eastmoney.com/EM_UBG_PDTI_Fast/api/js?rtntype=5&token=4&cb=on&id=" + stockid
					+ "&type=k&authorityType=&_=1547789078748";

			MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
			String result = HttpRestUtil.HttpRestClient(url, HttpMethod.GET, params);
			
			result = result.replace("on(", "").replace(")", "");

			Map map = JSON.parseObject(result, Map.class);

			JSONArray data = (JSONArray) map.get("data");
			List<Stock> stocks = new ArrayList<Stock>();

			for (Object object : data) {
				String[] cont = ((String) object).split(",");

				Stock stock = new Stock(((String) map.get("name")), ((String) map.get("code")),
						simpleDateFormat.parse(cont[0]), Double.parseDouble(cont[1]), Double.parseDouble(cont[2]),
						Double.parseDouble(cont[3]), Double.parseDouble(cont[4]), Long.parseLong(cont[5]),
						Long.parseLong(cont[6]), Double.parseDouble("-".equals(cont[7]) ? "0" : cont[7].replace("%", "")),stockid);
				stocks.add(stock);

			}
			stockDao.insertStockList(stocks);
		} catch (Exception e) {
			return false;
		}
		
		
		return true;
	}

	@RequestMapping("/bykeyword")
	@ResponseBody
	private Object findStock(String keyword) throws IOException, NumberFormatException, ParseException {


		String url = "http://api.so.eastmoney.com/bussiness/web/QuotationLabelSearch?cb=jQuery&token=4&keyword="
				+ keyword + "&type=0&pi=1&ps=30";
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		String result = HttpRestUtil.HttpRestClient(url, HttpMethod.GET, params);
		result = result.replace("jQuery(", "").replace(")", "");

		Map map = JSON.parseObject(result, Map.class);

		return map;
	}
	
	
	@RequestMapping("/findStockAnalyze")
	@ResponseBody
	private Object findStockAnalyze(String stockId) {


		StockAnalyze stockAnalyze = stockDao.findStockAnalyze(stockId);
		
		List<YearDate> stockList = stockAnalyze.getYearDates();
	
		if(stockList.size()<4 ) {
			stockAnalyze.setFourYearsAvg("小于4年不计算均价");
		}else{
			Double avgs = 0.0;
			
    		for (int i = stockList.size()-1; i >stockList.size()-5 ; i--) {
    			avgs+=stockList.get(i).getYearAvg();
    		}	
    		stockAnalyze.setFourYearsAvg((avgs/4)+"");
		}
		
		

		return stockAnalyze;
	}
	
	
	@RequestMapping("/test")
	@ResponseBody
	private Object test(HttpServletResponse response) throws Exception {

		String fileName = "Excel2.xlsx"; 
		
		XSSFWorkbook  wb =new XSSFWorkbook ();
		List<StockAnalyze> List = new  ArrayList<StockAnalyze>();
		
		  String []title = new String[]{"付款人","付款金额","上传日期","付款时间"};//标题
		 for (int i = 0; i < 3; i++) {
	        
			wb.createSheet("name"+i);
	                Thread myThread1 = new MyThread("name"+i, wb, title, stockDao,List);     
	               
	                myThread1.start();
	        }

		while (1 == 1) {
			if (List.size() == 3) {

				
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				wb.write(os);
				
				response.reset();

				response.setContentType(
						"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
				response.setHeader("Content-Disposition",
						"attachment;filename=" + new String((fileName).getBytes(), "iso-8859-1"));
				response.setContentLength(os.toByteArray().length);
				ServletOutputStream outputStream = response.getOutputStream();
				wb.write(outputStream);

				System.out.println(
						"----------------------------------------------------------1111111111111111111111111111111111111111111111111");
				outputStream.flush();
				System.out.println(
						"----------------------------------------------------------22222222222222222222222222222222222222222222222222222");
				outputStream.close();
				System.out.println(
						"----------------------------------------------------------3333333333333333333333333333333333333333333333333333333");
				os.flush();
				System.out.println(
						"---------------------------------------------------------444444444444444444444444444444444444444444444444444444444444");
				os.close();
				System.out.println(
						"----------------------------------------------------------55555555555555555555555555555555555555555555555555555555");
				return null;
			}
			Thread.sleep(1000);
		}
	}
	
	
	
}
