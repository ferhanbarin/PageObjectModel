package tests.day16;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_WebTables {

/*
    Bir class oluşturun : C02_WebTables
    ● login() metodun oluşturun ve oturum açın.
    ● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin .
    ○ Username : manager
    ○ Password : Manager1!
    ● table() metodu oluşturun.
    ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    ● printRows() metodu oluşturun //tr
    ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    ○ 4.satirdaki(row) elementleri konsolda yazdırın.
*/

    @Test
    public void webTables() throws InterruptedException {

        QAConcortHotelPage qaConcortHotelPage = new QAConcortHotelPage();
        qaConcortHotelPage.concortHotelLogin();
        qaConcortHotelPage.hotelManagement.click();
        qaConcortHotelPage.hotelRooms.click();

        System.out.println("Tablodaki sütün sayisi : " + qaConcortHotelPage.basliklarListesi.size());
        // Eger tüm tablo body'sini hücrelere ayirmadan tek bir String olarak görmek istersek, tüm body'i tek bir WebElement olarak locate edebiliriz.
        // Bu yaklasim, tabloda HAPPY HOTEL varmi? gibi sorular icin ideal bir cözüm olur.

        Thread.sleep(1000);

        System.out.println(qaConcortHotelPage.tBodyTumu.getText());
        Assert.assertTrue(qaConcortHotelPage.tBodyTumu.getText().contains("HAPPY HOTEL"));

        for (WebElement each: qaConcortHotelPage.basliklarListesi) {
            System.out.println(each.getText());
        }

        System.out.println("Tablodaki satir sayisi : " + qaConcortHotelPage.satirlarListesi.size());

        System.out.println("Tablodaki birinci satir : " + qaConcortHotelPage.birinciSatir.getText());

        for (int i=0; i<qaConcortHotelPage.satirlarListesi.size(); i++) {
            System.out.println(i+1 + ". satir : " + qaConcortHotelPage.satirlarListesi.get(i).getText());
        }

        for (WebElement each: qaConcortHotelPage.dördüncüSutunListesi) {
            System.out.println(each.getText());
        }

        Driver.closeDriver();
    }
}
