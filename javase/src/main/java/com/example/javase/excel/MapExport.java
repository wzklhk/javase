package com.example.javase.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExport {
    public static void main(String[] args) {

        List<Map<String, Object>> dtoLst = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "楚阳");
        map1.put("address", "傲世九重天");
        map1.put("specialty", "九劫剑");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "叶凡");
        map2.put("address", "遮天");
        map2.put("specialty", "荒古圣体");
        // 文件名称
        dtoLst.add(map1);
        dtoLst.add(map2);

        // 导出列名和字段code
        String nameStr = "姓名,书名,特长";
        String codeStr = "name,address,specialty";

        String[] nameArr = nameStr.split(",");
        String[] codeArr = codeStr.split(",");

        List<ExcelExportEntity> entity = new ArrayList<>();
        for (int i = 0; i < nameArr.length; i++) {
            entity.add(new ExcelExportEntity(nameArr[i], codeArr[i]));
        }


        ExportParams exportParams = new ExportParams(null, null, ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, entity, dtoLst);


        File file = new File("./test.xlsx");
        try (FileOutputStream os = new FileOutputStream(file)) {
            workbook.write(os);
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
