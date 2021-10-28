package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C01_Pages extends TestBase {

    // Amazon sayfasina gidip, "Nutella" icin arama yapin. Sonuc sayisini yazdirin ve sonuc yazisinin "Nutella" icerdigini test edin.

    @Test (groups = "birinciGrup")
    public void test() {

        driver.get("https://www.amazon.com/");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());

        Assert.assertTrue(sonucYazisi.getText().contains("Nutella"));
    }

    @Test
    public void testPOM() {

        driver.get("https://www.amazon.com/");

        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        System.out.println(amazonPage.sonucYazisi.getText());

        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Nutella"));
    }
}
