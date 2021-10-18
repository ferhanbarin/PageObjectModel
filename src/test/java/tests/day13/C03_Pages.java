package tests.day13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C03_Pages extends TestBase {

/*
    Amazon URL : https://www.amazon.com/
    DropDown menüden book kategorisini secin ve "JAVA" icin arama yapin.
    Bulunan sonuc yazisini yazin.
    Ilk ürünün isminde "Java" gectigini test edin.
 */

    @Test
    public void test() {

        driver.get("https://www.amazon.com/");

        AmazonPage amazonPage = new AmazonPage(driver);
        Select select = new Select(amazonPage.dropDown);
        select.selectByVisibleText("Books");

        amazonPage.aramaKutusu.sendKeys("JAVA" + Keys.ENTER);
        System.out.println(amazonPage.sonucYazisi.getText());

        Assert.assertTrue(amazonPage.booksJavaIlkUrun.getText().contains("Java"));
    }
}
