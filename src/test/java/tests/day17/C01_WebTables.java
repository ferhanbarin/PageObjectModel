package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortHotelPage;
import utilities.Driver;

public class C01_WebTables {

/*
    1. Pages sayfasinda bir method oluşturun : printData(int row, int column);
    a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.

    2. Ve bu metodu printData() methodunu cagirmak icin kullanin.
    a. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır.
    3. Yazdirilan datanin olmasi gereken dataya (USA) esit oldugunu test edin.
*/

    @Test
    public void test() {

        QAConcortHotelPage qaConcortHotelPage = new QAConcortHotelPage();
        qaConcortHotelPage.concortHotelLogin();
        qaConcortHotelPage.hotelManagement.click();
        qaConcortHotelPage.hotelRooms.click();

        String actualData = qaConcortHotelPage.printData(3, 5);

        // Assert'i bu class'da yapmak istiyorsak istenen datanin bu class'a dönmesini saglamaliyiz.
        Assert.assertEquals(actualData, "USA");

        Driver.closeDriver();
    }
}
