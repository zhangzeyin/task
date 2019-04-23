package com.example.demo.util;
 
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
*
* @author gw
* @version 2017年3月10日 上午8:07:52
*/
public class ExcelUtil {
	
	/**
	 * 
	 * @methodName:getHSSFWorkbook
	 * * @param sheetName
	 * * @param title 表头
	 * * @param values 表格内容
	 * * @param wb
	 * * @return
	 * @return HSSFWorkbook
	 * @author gw 
	 * @date 2017年3月10日上午11:19:20
	 */
	public static XSSFWorkbook getHSSFWorkbook(String sheetName, String []title, String [][]values, XSSFWorkbook  wb){
		//第一步，创建一个webbook,对应一个Excel文件
		//第二步，在webbook中添加一个sheet,对应excel文件中的sheet
		XSSFSheet  sheet =  wb.getSheet(sheetName);
		//第三步，在sheet中添加表头第0行
		XSSFRow  row = sheet.createRow(0);
		//第四步，创建单元格，并设置表头，设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//创建一个居中格式
		
		XSSFCell cell = null;
		
		//创建标题
		for(int i=0;i<title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		
		//创建内容
		for(int i=0;i<values.length;i++){
			row = sheet.createRow(i+1);
			for(int j=0;j<values[i].length;j++){
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		return wb;
	}
}
