package crossBrowser;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class positiveLoginTest {

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

        Driver.getDriver().get(ConfigReader.getProperty("CHQAURL"));

        QAConcortHotelPage qaConcortHotelPage = new QAConcortHotelPage();

        qaConcortHotelPage.loginMenu.click();
        qaConcortHotelPage.username.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        qaConcortHotelPage.password.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        qaConcortHotelPage.loginAccount.click();

        Assert.assertTrue(qaConcortHotelPage.succesLoginTextElement.isDisplayed());

        Driver.closeDriver();
    }
}
