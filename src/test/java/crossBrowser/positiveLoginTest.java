package crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class positiveLoginTest extends TestBaseCross {

    // Cross Browser testte TestBase class'ina geri dönüyoruz. Bunun sebebi @parameter notasyonunu kullanmak.
    // Dolayisiyla Driver.getDriver() ve Pages sayfalarindaki locator'lari kullanamayiz.

/*
    Bir test method olustur. positiveLoginTest()
    https://qa-environment.concorthotel.com/ adresine git.
    Login butonuna bas.
    Test data username: manager ,
    Test data password : Manager1!
    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et.
*/

    @Test
    public void test() {

        driver.get(ConfigReader.getProperty("CHQAURL"));

        driver.findElement(By.linkText("Log in")).click();

        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys(ConfigReader.getProperty("CHValidUsername"));
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(ConfigReader.getProperty("CHValidPassword"));

        driver.findElement(By.id("btnSubmit")).click();

        WebElement succesLoginText = driver.findElement(By.xpath("//span[text()='ListOfUsers']"));
        Assert.assertTrue(succesLoginText.isDisplayed());
    }
}
