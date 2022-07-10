package com.example.javase.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import lombok.Data;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        List<Map<String, Object>> sheetList = new ArrayList<>();

        List<User> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("user1" + i);
            user.setPassword("123456");
            list1.add(user);
        }
        Map<String, Object> m1 = new HashMap<>();
        ExportParams exportParams = new ExportParams(null, "sheet1", ExcelType.XSSF);
        m1.put("title", exportParams);
        m1.put("entity", User.class);
        m1.put("data", list1);
        sheetList.add(m1);


        List<Map<String, List<Map<String, String>>>> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, Object> map = new HashMap<>();
        }
        Map<String, Object> m2 = new HashMap<>();
        ExportParams exportParam2 = new ExportParams(null, "sheet2", ExcelType.XSSF);
        m2.put("title", exportParam2);
        m2.put("entity", Map.class);
        m2.put("data", list2);
        sheetList.add(m2);

        Workbook workbook = ExcelExportUtil.exportExcel(sheetList, ExcelType.XSSF);


        File file = new File("./test.xlsx");
        try (FileOutputStream os = new FileOutputStream(file)) {
            workbook.write(os);
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


@Data
class User {
    @Excel(name = "username")
    private String username;
    @Excel(name = "password")
    private String password;
}