package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * This utility reads test data from an Excel (.xlsx) file.
 * It is used to feed multiple rows of data into a single @Test method.
 */
public class ExcelUtils {

	public static Object[][] getTestData(String excelFileName, String sheetName) {
		Object[][] data = null;

		try {
			// 1. Point to where the Excel files will be stored
			String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + excelFileName;
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);

			// 2. Open the Excel Workbook and target the specific Sheet
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// 3. Count rows and columns (ignoring the header row)
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getLastCellNum();

			// Initialize the data grid (rowCount - 1 because we skip the header row)
			data = new Object[rowCount - 1][colCount];
			DataFormatter formatter = new DataFormatter();

			// 4. Loop through the Excel sheet and copy data into our Java array
			for (int i = 1; i < rowCount; i++) { // Start at 1 to skip headers
				for (int j = 0; j < colCount; j++) {
					// DataFormatter ensures we read numbers, dates, and text all as clean Strings
					data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
				}
			}

			// Clean up memory
			workbook.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("Error reading Excel file: " + e.getMessage());
		}

		return data;
	}
}

