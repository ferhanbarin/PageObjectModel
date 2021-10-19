package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C04_AmazonConfigReader extends TestBase {

    // Amazon sayfasina gidip, "Nutella" icin arama yapin. Sonuc sayisini yazdirin ve sonuc yazisinin "Nutella" icerdigini test edin.

    @Test
    public void test() {

        driver.get(ConfigReader.getProperty("AmazonURL"));

        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        System.out.println(amazonPage.sonucYazisi.getText());

        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Nutella"));
    }
}
