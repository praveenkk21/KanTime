package org.example;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

 public class exceldriven {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;

    public void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        //Create an object of File class to open xls file
        File file = new File(excelFilePath);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        //creating workbook instance that refers to .xls file
        workbook = new XSSFWorkbook(inputStream);

        //creating a Sheet object
        sheet = workbook.getSheet(sheetName);

    }

    public String getCellData(int rowNumber, int cellNumber) {
        //getting the cell value from rowNumber and cell Number
        cell = sheet.getRow(rowNumber).getCell(cellNumber);

        //returning the cell value as string
        //return cell.getStringCellValue();

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                // Assuming whole numbers, convert to String
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                // Handle boolean values (e.g., convert to "true" or "false")
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                // Handle formulas (e.g., evaluate and convert to String)
                return cell.getStringCellValue(); // Might throw exception if formula evaluation fails
            default:
                // Handle other cell types (throw exception or return a default value)
                return ""; // Or throw an exception for unexpected data types
        }
    }

    public int getRowCountInSheet() {
        int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        return rowcount;
    }

    public void setCellValue(int rowNum, int cellNum, String cellValue, String excelFilePath) throws IOException {
        //creating a new cell in row and setting value to it
        sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
    }

}

//  @Test
//    public class getExcel {
//        public void testExcel() throws IOException {
//            exceldriven exc = new exceldriven();
//            exc.setExcelFile("resources/data.xlsx","praveen");
//            System.out.println(exc.getRowCountInSheet());
//            System.out.println(exc.getCellData(1,1));
//            exc.setCellValue(2,3,"shwenky","resources/data.xlsx");
//            System.out.println(exc.getRowCountInSheet());
//        }
//    }

    // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//connection = DriverManager.getConnection(url, username, password);
// String query = "select * from ProcessMaster with (nolock)";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(query);
//        String login_id = null;
//        if (resultSet.next()) {
//            String columnName = resultSet.getMetaData().getColumnName(12);
//            Object columnValue = resultSet.getObject(12);
//            login_id = new customLibrary().jsonParseForSQL(String.valueOf(columnValue), columnNameofTable);
//            //connection.close();
//            return (replaceDoubleQuotes(login_id));
//        }
//jdbc:sqlserver://" + dataSource + ":1433;databaseName=" + initialCatalog + ";encrypt=false;"


//KeyWord Driven
//Function Library
//Excel Sheet to store Keywords
//Design Test Case Template
//Object Repository for Elements/Locators
//Test Scripts or Driver Script