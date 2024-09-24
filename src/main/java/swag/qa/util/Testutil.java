package swag.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import swag.qa.base.Testbase;



public class Testutil extends Testbase {

    public static String TESTDATA_SHEET_PATH = "C:\\Users\\hinai\\New workspace\\freeCRM\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    private static Workbook book;
    private static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
            book = WorkbookFactory.create(file);
            sheet = book.getSheet(sheetName);

            if (sheet == null) {
                return new Object[0][0]; // Return empty array if sheet not found
            }

            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(0).getLastCellNum();
            Object[][] data = new Object[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int k = 0; k < cols; k++) {
                    if (sheet.getRow(i + 1).getCell(k) != null) {
                        data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                    } else {
                        data[i][k] = ""; // Handle empty cells
                    }
                    System.out.println(data[i][k]);
                }
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return new Object[0][0]; // Return empty array if error occurs
        } finally {
            try {
                if (file != null) {
                    file.close(); // Ensure the file input stream is closed
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void takeScreenshotAtEndOfTest(String fileName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        try {
            FileUtils.copyFile(srcFile, new File("C:\\Users\\hinai\\New workspace\\freeCRM\\src\\main\\java\\Screenshots\\" + fileName + ".png"));
            // Alternatively, save to project directory:
            // FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace(); // Handle file copy exceptions
        }
    }

	
}
