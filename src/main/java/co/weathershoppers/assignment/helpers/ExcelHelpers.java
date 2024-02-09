package co.weathershoppers.assignment.helpers;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static co.weathershoppers.assignment.helpers.PathHelper.getFile;

public class ExcelHelpers {
    public static String getValueFromExcelSheet(String fileName, String sheetName, int rowNumber) throws IOException {
        String filePath = getFile(fileName);
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        DataFormatter formatter = new DataFormatter();
        int row = rowNumber - 1;
        return String.valueOf(formatter.formatCellValue(sheet.getRow(row).getCell(1)));
    }

    public static String getValueFromExcelSheet(String fileName, String sheetName, int rowNumber, int columnNumber)
            throws IOException {
        String filePath = getFile(fileName);
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        DataFormatter formatter = new DataFormatter();
        int row = rowNumber - 1;
        int column = columnNumber - 1;
        return String.valueOf(formatter.formatCellValue(sheet.getRow(row).getCell(column)));
    }

}

