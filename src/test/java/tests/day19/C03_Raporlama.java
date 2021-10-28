package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_Raporlama extends TestBaseRapor {


    // 1) Amazon sayfasina gidip "Nutella" icin arama yapalim.
    // 2) Sonuc sayisinin 1000'den az oldugunu test edelim.

    @Test
    public void test1() {
        extentTest = extentReports.createTest("Nutella Testi", "Sonuc sayisi 1000'den az olmali.");

        Driver.getDriver().get(ConfigReader.getProperty("AmazonURL"));
        extentTest.info("Amazon sayfasina gidildi.");

        WebElement search = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Nutella" + Keys.ENTER);
        extentTest.info("Nutella icin arama yapildi.");

        WebElement sonucSayisiElementi = Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));

        String sonucYazisi = sonucSayisiElementi.getText();
        String sonucArray[] = sonucYazisi.split(" ");
        int sonucSayisi = Integer.parseInt(sonucArray[2]);
        extentTest.info("Sonuc yazisi int haline getirildi.");

        Assert.assertTrue(sonucSayisi < 1000, "Sonuc 1000'den fazla.");
        extentTest.pass("Sonuc sayisinin 1000'den az oldugu test edildi.");

        Driver.closeDriver();
    }


    // 1) Amazon sayfasina gidip "Samsung" icin arama yapalim.
    // 2) Sonuc sayisinin 1000'den az oldugunu test edelim.

    @Test
    public void test2() {

        Driver.getDriver().get(ConfigReader.getProperty("AmazonURL"));
        extentTest.info("Amazon sayfasina gidildi.");

        WebElement search = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Samsung" + Keys.ENTER);
        extentTest.info("'Samsung' icin arama yapildi.");

        WebElement sonucSayisiElementi = Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));

        String sonucYazisi = sonucSayisiElementi.getText();
        String sonucArrayi[] = sonucYazisi.split(" ");
        String sonucAdedi = sonucArrayi[3];
        sonucAdedi = sonucAdedi.replace(",","");
        System.out.println(sonucAdedi);
        int sonucSayisi= Integer.parseInt(sonucAdedi);
        extentTest.info("Sonuc yazisi int haline getirildi.");

        Assert.assertTrue(sonucSayisi < 1000, "Sonuc 1000'den fazla.");
        extentTest.pass("Sonuc sayisinin 1000'den az oldugu test edildi.");

        Driver.closeDriver();
    }


    // 1) Amazon sayfasina gidip, electronic kategorisinde  "JAVA" icin arama yapalim.
    // 2) Cikan sonuclardan ilkinin isminde "JAVA" oldugunu test edelim.

    @Test
    public void test3() {
        extentTest = extentReports.createTest("JAVA Testi", "Ilk üründe JAVA olmali.")

        Driver.getDriver().get(ConfigReader.getProperty("AmazonURL"));
        extentTest.info("Amazon sayfasina gidildi.");

        WebElement dropDown = Driver.getDriver().findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Electronics");
        extentTest.info("DropDown'dan Electronics secildi.");

        WebElement search = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("JAVA" + Keys.ENTER);
        extentTest.info("JAVA kelimesi aratildi.");

        String ilkElementYazisi = Driver.getDriver().findElement(By.xpath("(//div[@class='s-expand-height s-include-content-margin s-latency-cf-section s-border-bottom'])[1]")).getText();
        Assert.assertTrue(ilkElementYazisi.contains("JAVA"));
        extentTest.pass("Ilk ürün isminde JAVA oldugu test edildi.");

        Driver.closeDriver();
    }
}
