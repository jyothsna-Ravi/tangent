package com.tangent.libraries;

import java.io.FileInputStream;

public class ExcelLibrary 
{
public static String getExcelData(String sheetName,int rowNum,int cellNum)
{
	FileInputStream fis=new FileInputStream("./data/book1.xlsx");
	WorkBook wb=WorkBookfactory.create(fis);
	String data=wb.getsheet(sheetName.getRow(rowNum).getCell(cellNum).toString());
	return data;
}
}
