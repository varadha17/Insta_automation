package vivid.commonUtilties;

public abstract class excelComponent {
	
	public abstract String getCellDatafromExcel(int row, int column, String sheetName);
	public abstract int getRowCount(String sheetName);

}
