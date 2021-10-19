package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PositiveTestConfigReader extends TestBase {

/*
    1) Bir Class olustur : PositiveTest
    2) Bir test method olustur. positiveLoginTest()
    https://www.concorthotel.com/ adresine git.
    Login butonuna bas.
    Test data username: manager
    Test data password : Manager1!
    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et.
*/
    @Test
    public void positiveTest() {

        driver.get(ConfigReader.getProperty("CHURL"));

        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.loginMenu.click();
        concortHotelPage.username.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        concortHotelPage.password.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.loginAccount.click();

        Assert.assertTrue(concortHotelPage.succesLoginTextElement.isDisplayed());
    }
}
