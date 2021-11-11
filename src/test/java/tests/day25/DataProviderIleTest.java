package tests.day25;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class DataProviderIleTest {

    // @DataProvider Array ile calisir.
    @DataProvider
    public static Object[] aranacakKelimeListesi() {

        String arr[] = {"Nutella", "JAVA", "Apple"};

        return arr;
    }


    @Test (dataProvider = "aranacakKelimeListesi")
    public void test(String aranacak) {

        Driver.getDriver().get(ConfigReader.getProperty("AmazonURL"));

        // Parametre olarak girilen deger icin arama yapin.
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(aranacak + Keys.ENTER);

        WebElement sonucYazisi = Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());

        Assert.assertTrue(sonucYazisi.getText().contains(aranacak));

        Driver.closeDriver();
    }
}
