
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    Logger logger = Logger.getLogger(ExcelUtil.class);
    String[][] data = null;

    public HashMap<Integer, List<String>> read(String inputFile) throws IOException {
        HashMap<String, LinkedHashMap<Integer, List<String>>> outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List<String>>>();
        LinkedHashMap<Integer, List<String>> hashMap = new LinkedHashMap<Integer, List<String>>();
        String sheetName = null;
        // Create an ArrayList to store the data read from excel sheet.
        // List sheetData = new ArrayList();
        FileInputStream fis = null;
        // List<List> data = new LinkedList();

        try {
            fis = new FileInputStream(inputFile);
            // Create an excel workbook from the file system
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            // Get the first sheet on the workbook.
            for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
                XSSFSheet sheet = workBook.getSheetAt(i);
                // XSSFSheet sheet = workBook.getSheetAt(0);
                sheetName = workBook.getSheetName(i);

                Iterator rows = sheet.rowIterator();
                while (rows.hasNext()) {
                    XSSFRow row = (XSSFRow) rows.next();
                    Iterator cells = row.cellIterator();
                    List<String> data = new LinkedList<>();
                    while (cells.hasNext()) {
                        XSSFCell cell = (XSSFCell) cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        data.add(cell.getStringCellValue());
                    }
                    hashMap.put(row.getRowNum(), data);
                    // sheetData.add(data);
                }
                outerMap.put(sheetName, hashMap);
                hashMap = new LinkedHashMap<Integer, List<String>>();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return outerMap.get(sheetName);

    }

    public List<Map<String, String>> getExcelList(String fileName, String headerData) {
        XSSFWorkbook wb;
        try {
            wb = new XSSFWorkbook(new FileInputStream(fileName));

            List<Map<String, String>> tempList = new ArrayList<Map<String, String>>();
            Map<Integer, String> header = new HashMap<Integer, String>();
            String[] arg = headerData.split(",");

            for (int i = 0; i < arg.length; i++) {
                if (!arg[i].equals(""))
                    header.put(i, arg[i]);
            }

            for (Row row : wb.getSheetAt(0)) {

                Map<String, String> tempMap = new HashMap<String, String>();
                for (Cell cell : row) {
                    if (header.get(cell.getColumnIndex()) != null) {
                        switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            tempMap.put(header.get(cell.getColumnIndex()), cell.getRichStringCellValue()
                                .getString());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell))
                                tempMap.put(header.get(cell.getColumnIndex()), cell.getDateCellValue()
                                    .toString());
                            else
                                tempMap.put(header.get(cell.getColumnIndex()), Integer.toString((int) cell.getNumericCellValue()));
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            tempMap.put(header.get(cell.getColumnIndex()), cell.getCellFormula());
                            break;
                        }
                    }
                }

                tempList.add(tempMap);
            }

            return tempList;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
