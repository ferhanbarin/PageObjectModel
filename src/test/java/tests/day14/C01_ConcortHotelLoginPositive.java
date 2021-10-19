package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C01_ConcortHotelLoginPositive extends TestBase {

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

        driver.get("https://www.concorthotel.com/");

        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.loginMenu.click();
        concortHotelPage.username.sendKeys("manager");
        concortHotelPage.password.sendKeys("Manager1!");
        concortHotelPage.loginAccount.click();

        Assert.assertTrue(concortHotelPage.succesLoginTextElement.isDisplayed());
    }
}
