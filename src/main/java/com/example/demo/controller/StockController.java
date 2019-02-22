package com.example.demo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.example.demo.util.HttpRestUtil;

@Controller
public class StockController {

	@Autowired
	private StockDao stockDao;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping("/findStock")
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

		return stockAnalyze;
	}
	
}
