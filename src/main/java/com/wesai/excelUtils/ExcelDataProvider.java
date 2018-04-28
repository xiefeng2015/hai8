package com.wesai.excelUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * @description:
 * 读取Excel数据<br>
 * 说明：<br>
 * Excel放在Data文件夹下<br>
 * Excel命名方式：测试类名.xls<br>
 * Excel的sheet命名方式：测试方法名<br>
 * Excel第一行为Map键值<br>
 */
public class ExcelDataProvider {

    private Workbook book = null;
    private static Sheet sheet = null;
    private static int rowNum = 0;
    public static int currentRowNo = 0;
    private int columnNum = 0;
    private String[] columnnName;
    private String path = null;
    private InputStream inputStream = null;
    public static Logger logger = Logger.getLogger(ExcelDataProvider.class.getName());

    /**
     * @description
     * 2个参数：<br>
     * moduleName - 模块的名称
     * caseNum - 测试用例编号
     **/
    public Map<String, Object> GetExcelData(String moduleName, String caseNum) {
        try {
            //文件路径
            path = "data/" + moduleName + "Data.xls";
            inputStream = new FileInputStream(path);
            book = Workbook.getWorkbook(inputStream);
            sheet = book.getSheet(caseNum); // 读取第一个sheet
            rowNum = sheet.getRows(); // 获得该sheet的 所有行
            Cell[] cell = sheet.getRow(0);// 获得第一行的所有单元格
            columnNum = cell.length; // 单元格的个数 值 赋给 列数
            columnnName = new String[cell.length];// 开辟 列名的大小
            for (int i = 0; i < cell.length; i++) {
                columnnName[i] = cell[i].getContents().toString(); // 第一行的值
                // 被赋予为列名
            }
            ExcelDataProvider.currentRowNo++;
        } catch (FileNotFoundException e) {
            logger.error("没有找到指定的文件：" + "[" + path + "]");
            Assert.fail("没有找到指定的文件：" + "[" + path + "]");
        } catch (Exception e) {
            logger.error("不能读取文件： [" + path + "]",e);
            Assert.fail("不能读取文件： [" + path + "]");
        }
        return this.next();
    }

    /**
     * @description 通过指定的序号获取外部数据源excel的测试数据
     * 重载+1
     */
    public Map<String, Object> GetExcelData(String moduleName, String caseNum, int index) {
        try {
            //文件路径
            path = "data/" + moduleName + "Data.xls";
            inputStream = new FileInputStream(path);
            book = Workbook.getWorkbook(inputStream);
            sheet = book.getSheet(caseNum); // 读取第一个sheet
            rowNum = sheet.getRows(); // 获得该sheet的 所有行
            Cell[] cell = sheet.getRow(0);// 获得第一行的所有单元格
            columnNum = cell.length; // 单元格的个数 值 赋给 列数
            columnnName = new String[cell.length];// 开辟 列名的大小
            for (int i = 0; i < cell.length; i++) {
                // 被赋予为列名
                columnnName[i] = cell[i].getContents().toString(); // 第一行的值
            }
            ExcelDataProvider.currentRowNo = index;
        } catch (FileNotFoundException e) {
            logger.error("没有找到指定的文件：" + "[" + path + "]");
            Assert.fail("没有找到指定的文件：" + "[" + path + "]");
        } catch (Exception e) {
            logger.error("不能读取文件： [" + path + "]",e);
            Assert.fail("不能读取文件： [" + path + "]");
        }
        return this.next();
    }

    /**是否还有下个内容*/
    public boolean hasNext() {
        if (ExcelDataProvider.rowNum == 0 ||
                ExcelDataProvider.currentRowNo >= ExcelDataProvider.rowNum) {
            try {
                inputStream.close();
                book.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } else {
            // sheet下一行内容为空判定结束
            try {
                if ((sheet.getRow(++currentRowNo))[0].getContents().equals(""))
                    return false;
                --currentRowNo;
            } catch (Exception e) {
                logger.info("迭代完数据，共： [" + --currentRowNo + "] 行");
                return false;
            }
            return true;
        }
    }

    /**返回内容*/
    public Map<String, Object> next() {
        Cell[] c = sheet.getRow(ExcelDataProvider.currentRowNo);
        Map<String, Object> data = new HashMap<String, Object>();
        for (int i = 0; i < this.columnNum; i++) {
            String temp = "";
            try {
                temp = c[i].getContents().toString();
            } catch (ArrayIndexOutOfBoundsException ex) {
                temp = "";
            }
            data.put(this.columnnName[i], temp);
        }
        return data;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove unsupported.");
    }
}
