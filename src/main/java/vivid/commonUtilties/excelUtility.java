package vivid.commonUtilties;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility extends excelComponent {
	
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;

	public excelUtility(String path) {
		try {
			this.path = path;
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public String getCellDatafromExcel(int row, int column, String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		String getcell = sheet.getRow(row).getCell(column).getStringCellValue();
		return getcell;
	}

	@Override
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);

		if(index == -1) {
			return 0;
		} else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}
	}
	
}
