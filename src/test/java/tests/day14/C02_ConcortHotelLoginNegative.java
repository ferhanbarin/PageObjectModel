package tests.day14;

import org.testng.Assert;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C02_ConcortHotelLoginNegative extends TestBase {

/*
    Bir test method olustur. NegativeLoginTest()
    https://www.concorthotel.com/ adresine git.
    Login butonuna bas.
    Test data username: manager1
    Test data password : manager1!
    Degerleri girildiginde sayfaya girilemedigini test et.
*/

    public void negativeTest() {

        driver.get("https://www.concorthotel.com/");

        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);

        concortHotelPage.loginMenu.click();
        concortHotelPage.username.sendKeys("manager1");
        concortHotelPage.password.sendKeys("manager1!");
        concortHotelPage.loginAccount.click();

        Assert.assertTrue(concortHotelPage.wrongLogin.isDisplayed());
    }
}
