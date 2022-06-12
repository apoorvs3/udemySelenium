package assignment1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteInFile {
	public static void writeInTxt(LinkedList<String> ls) throws IOException {
		//writing in text
//		String path = System.getProperty("user.dir")+"/src/test/java/assignment1/files/test1.txt";
//		File f = new File(path);
//		FileWriter fw = new FileWriter(f);
//		BufferedWriter writer = new BufferedWriter(fw);
//
//		
//		for(int i=0; i<ls.size(); i++) {
//			writer.write(ls.get(i));
//			writer.newLine();
//		}
//		writer.close();
		
		
		//writing in CSV
//		String path = System.getProperty("user.dir")+"/src/test/java/assignment1/files/Test1.csv";
//		File f= new File(path);
//		FileWriter fw = new FileWriter(f);
//		BufferedWriter writer = new BufferedWriter(fw);
//		
//		for(int i=0; i<ls.size(); i++) {
//			writer.write(ls.get(i));
//			writer.newLine();
//		}
//		writer.close();
		
		
	}
	public static void WriteInExcel(LinkedList<String> ls) throws IOException {
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet0 = workbook.createSheet("sheet");
		
//		Row row= sheet0.createRow(0);
		for(int cols=0; cols<ls.size();cols++) {
			Row row= sheet0.createRow(cols);
			Cell cell = row.createCell(0);
			cell.setCellValue(ls.get(cols));
		}
		
		String path = System.getProperty("user.dir")+"/src/test/java/assignment1/files/Test3.xlsx";
		File f = new File(path);
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);
		fos.close();
		System.out.println("Excel created");
	}
	
	
}
