package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadDataFromXLSFile {
	
	public static Object[] readDataFromXLS(String filepath) throws IOException
	{
		FileInputStream fi=new FileInputStream(new File(filepath));
		Workbook wb= new HSSFWorkbook(fi);
		HSSFSheet sheet=(HSSFSheet) wb.getSheetAt(0);
		int rows=sheet.getLastRowNum()+1;
		int cols=sheet.getRow(0).getLastCellNum();
		Object obj[][]=new Object[rows][cols];
		for(int i=0;i<rows;i++)
		{
			HSSFRow currRow=sheet.getRow(i);
			for(int j=0;j<cols;j++)
			{
				HSSFCell currCell=currRow.getCell(j);
				if(currCell.getCellType()==HSSFCell.CELL_TYPE_STRING)
				{
					obj[i][j]=currCell.getStringCellValue();
				}
				else if(currCell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC)
				{
					obj[i][j]=currCell.getNumericCellValue();
				}
				
			}
		}
		
		
		return obj;
	}

}
