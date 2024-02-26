package Utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchData {

    public static List<List<String>> testData = new ArrayList<>();

    public static List<List<String>> getTestData() {

        try {
            String src = System.getProperty("user.dir");
            XSSFWorkbook xsf = new XSSFWorkbook(src + "/TestData.xlsx");
            XSSFSheet sheet = xsf.getSheetAt(0);

            for(int i=2; i<=3; i++) {
                List<String> line = new ArrayList<>();
                line.add(sheet.getRow(i).getCell(0).getStringCellValue());
                line.add(sheet.getRow(i).getCell(1).getStringCellValue());
                line.add(sheet.getRow(i).getCell(2).getStringCellValue());
                testData.add(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return testData;
    }

}
