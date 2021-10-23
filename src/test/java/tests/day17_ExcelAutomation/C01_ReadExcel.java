package tests.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C01_ReadExcel {

/*
    7. Dosya yolunu bir String degiskene atayalim.
    8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim.
    9. Workbook objesi olusturalim, parameter olarak fileInputStream objesini girelim.
    10. WorkbookFactory.create(fileInputStream)
    11. Worksheet objesi olusturun. workbook.getSheetAt(index)
    12. Row objesi olusturun. sheet.getRow(index)
    13. Cell objesi olusturun. row.getCell(index)
*/

    @Test
    public void readExcel() throws IOException {

        String path = "src/test/java/resources/Countries.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(4);

        Cell cell = row.getCell(1);

        System.out.println(cell);
    }

    @Test
    public void test() throws IOException {

        String path = "src/test/java/resources/Countries.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Cell cell = workbook.getSheet("Sayfa1").getRow(5).getCell(3);
        System.out.println(cell);

        // Secilen hücredeki yazinin Luanda oldugu test edin.
        Assert.assertEquals(cell.toString(), "Luanda"); // cell'in data türü Cell, "Luanda" ise String data türleri farkli oldugu icin bu ikisi equal olamaz.
        // Cell data türü yazdirilabilir ancak String method'lari ile kullanilamaz. String Manipulation yapmak icin CELL data türünü String'e CAST yapmaliyiz.


        // Index'i 3 olan satirdaki index'i 2 olan hücredeki yaziyi büyük harfle yazdirin.

        Cell cell1 = workbook.getSheet("Sayfa1").getRow(3).getCell(2);
        System.out.println(cell1.toString().toUpperCase());


        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()); // getLastRowNum() bize son satirin index'ini verir. - 190
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows()); // getPhysicalNumberOfRows() ise fiili olarak kullanilan satir sayisini verir. - 191
        System.out.println(workbook.getSheet("Sayfa1").getFirstRowNum()); // 0

        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum()); // -1
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows()); // 0
        System.out.println(workbook.getSheet("Sayfa2").getFirstRowNum()); // -1
    }

    @Test
    public void test2() throws IOException {

        // Tablodaki 2. sütunu bir liste olarak yazdirin.
        List <String> ikinciSutun = new ArrayList<>();

        String path = "src/test/java/resources/Countries.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        for (int i=0; i<=workbook.getSheet("Sayfa1").getLastRowNum(); i++) {

            ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }

        System.out.println(ikinciSutun);


        // A ile baslayan sehirleri liste yapip, yazdirin.

        List <String> aIleBaslayanSehirler = new ArrayList<>();
        for (String each : ikinciSutun) {
            if (each.startsWith("A")) {
                aIleBaslayanSehirler.add(each);
            }
        }

        System.out.println(aIleBaslayanSehirler);

        // Eger tüm datayi JAVA'dan kullanilabilir bir collection'a cevirmek istersek en uygun yapi MAP olur.
        // MAP icin UNIQ degerlere sahip bir sütunu key, geriye kalan tüm sütunlari ise virgülle ayrilan String'ler olarak value yapmaliyiz.
        // key=Turkey  value=Ankara, Turkiye, Ankara

        Map <String, String> ülkelerMap = new HashMap<>();
        String key = "";
        String value = "";
        for (int i=0; i<=workbook.getSheet("Sayfa1").getLastRowNum(); i++) {

            key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ülkelerMap.put(key, value);
        }

        System.out.println(ülkelerMap);

        // Biz JAVA method'larini ve collections'i kullanarak excel'deki datalari manipule edebilecegimiz JAVA ortamina alabiliriz.
    }
}
