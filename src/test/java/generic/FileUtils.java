package generic;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtils {

	public static String getPptValue(String file, String key) {
		String value = "";

		Properties p = new Properties();
		try {
			p.load(new FileInputStream(file));
			value = p.getProperty(key);
		} catch (Exception e) {

		}

		return value;
	}

	public static String getXlCellValue(String path, String sheet, int r, int c) {
		String value = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			value = wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
			wb.close();
		} catch (Exception e) {
		}
		return value;
	}
}
