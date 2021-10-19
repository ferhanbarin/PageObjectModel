package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NegativeTestConfigReader extends TestBase {

/*
    Bir test method olustur. NegativeLoginTest()
    https://www.concorthotel.com/ adresine git.
    Login butonuna bas.
    Test data username: manager1
    Test data password : manager1!
    Degerleri girildiginde sayfaya girilemedigini test et.
*/

    @Test
    public void test() {

        driver.get(ConfigReader.getProperty("CHURL"));

        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.loginMenu.click();
        concortHotelPage.username.sendKeys(ConfigReader.getProperty("CHInvalidUsername"));
        concortHotelPage.password.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        concortHotelPage.loginAccount.click();

        Assert.assertTrue(concortHotelPage.wrongLoginTextElement.isDisplayed());
    }
}
