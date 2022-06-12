package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.units.qual.degrees;

public class ExcelTest {
	static Date currDate = new Date();
	static String format = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(currDate);
	public static final String frmt = format.replace(" ", "_").replace(":", "_").replace(",", "");

	public void ReadData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/data/Lookup Functions.xlsx";
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet0 = workbook.getSheet("ApproximateMatch_2");

		String val = "";
		int row_count = 0;
		int col_count = 0;
		for (Row rows : sheet0) {
			for (Cell cell : rows) {
				while (row_count <= 1) {
					col_count++;

					if (CellType.STRING == cell.getCellType()) {
						val = cell.getStringCellValue() + ",";
					} else if (CellType.NUMERIC == cell.getCellType()) {
						val = cell.getNumericCellValue() + ",";
					} else if (CellType.BLANK == cell.getCellType()) {
						val = "" + ",";
					}
					val += "\n";
					row_count++;
				}
			}
		}
		System.out.println(val);
	}

	/*
	 * public void WriteData(){ String src = System.getProperty("user.dir")
	 * +"/src/test/resources/data/Lookup Functions.xlsx"; File f = new File(src);
	 * FileInputStream fis= new FileInputStream(f); Workbook workbook =
	 * WorkbookFactory.create(fis); Sheet sheet0 =
	 * workbook.getSheet("ApproximateMatch_2"); String val = ""; int row_count=0;
	 * int col_count=0; for(Row rows: sheet0) { row_count++; for(Cell cell: rows) {
	 * while(row_count<=1) { col_count++; } if(CellType.STRING== cell.getCellType())
	 * { val= cell.getStringCellValue()+","; } else if(CellType.NUMERIC==
	 * cell.getCellType()) { val = cell.getNumericCellValue()+","; } else
	 * if(CellType.BLANK== cell.getCellType()) { val = ""+","; } } val+="\n"; }
	 * 
	 * 
	 * String
	 * dest=System.getProperty("user.dir")+"/src/test/resources/data/"+frmt+".xlsx";
	 * XSSFWorkbook workbook_d = new XSSFWorkbook(); XSSFSheet sheet0_d =
	 * workbook_d.createSheet("First_sheet");
	 * 
	 * 
	 * /*
	 * 
	 * for(Row row: sheet0) {
	 * 
	 * for(Cell cell: row) { if(CellType.NUMERIC == cell.getCellType()) {
	 * System.out.print(cell.getNumericCellValue()+ "\t"); } else
	 * if(CellType.STRING== cell.getCellType()) {
	 * System.out.print(cell.getStringCellValue()+"\t"); } else if(CellType.BLANK==
	 * cell.getCellType()) { System.out.print(""+"\t"); } } System.out.println(); }
	 * 
	 * 
	 * }
	 */
	public static void main(String[] args) {
		ExcelTest et = new ExcelTest();
		try {
			et.ReadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
