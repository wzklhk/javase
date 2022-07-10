package com.example.javase.excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class POI {
    public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();


        File file = new File("./test.xlsx");
        try (FileOutputStream os = new FileOutputStream(file)) {
            workbook.write(os);
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
