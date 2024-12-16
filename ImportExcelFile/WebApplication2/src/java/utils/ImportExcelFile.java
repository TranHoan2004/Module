/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.IOException;
import java.io.InputStream;
import jakarta.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ADMIN
 */
public class ImportExcelFile {

    private static List<List<String>> readExcelFile(InputStream inputStream) {
        List<List<String>> data = new ArrayList<>();
        try (XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            XSSFSheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên
            for (Row row : sheet) {
                List<String> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    // Đọc dữ liệu từ từng ô
                    switch (cell.getCellType()) {
                        case STRING ->
                            rowData.add(cell.getStringCellValue());
                        case NUMERIC ->
                            rowData.add(String.valueOf(cell.getNumericCellValue()));
                        case BOOLEAN ->
                            rowData.add(String.valueOf(cell.getBooleanCellValue()));
                        default ->
                            rowData.add("");
                    }
                }
                data.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static List<List<String>> getData(Part part) throws Exception {
        if (part == null) {
            throw new Exception("Part is null");
        }
        InputStream fileContent = part.getInputStream();
        return readExcelFile(fileContent);
    }
}
