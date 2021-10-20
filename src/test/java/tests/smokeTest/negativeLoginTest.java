package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class negativeLoginTest {

    QAConcortHotelPage qaConcortHotelPage;

/*
    1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
    3 Farkli test Methodunda 3 senaryoyu test et.
    - yanlisSifre
    - yanlisKulllanici
    - yanlisSifreKullanici
    Test data yanlis username: manager1 , yanlis password : manager1
    2) https://qa-environment.concorthotel.com/ adresine git.
    3) Login butonuna bas.
    4) Verilen senaryolar ile giris yapilamadigini test et.
*/
    @Test (priority = -1)
    public void yanlisSifre() {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAURL"));

        QAConcortHotelPage qaConcortHotelPage = new QAConcortHotelPage();

        qaConcortHotelPage.loginMenu.click();
        qaConcortHotelPage.username.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        qaConcortHotelPage.password.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        qaConcortHotelPage.loginAccount.click();

        Assert.assertTrue(qaConcortHotelPage.wrongLoginTextElement.isDisplayed());
    }

    @Test (dependsOnMethods = "yanlisSifre")
    public void yanlisKullanici() {

        qaConcortHotelPage = new QAConcortHotelPage();

        qaConcortHotelPage.username.clear();
        qaConcortHotelPage.username.sendKeys(ConfigReader.getProperty("CHInvalidUsername"));
        qaConcortHotelPage.password.clear();
        qaConcortHotelPage.password.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        qaConcortHotelPage.loginAccount.click();

        Assert.assertTrue(qaConcortHotelPage.wrongLoginTextElement.isDisplayed());
    }

    @Test (dependsOnMethods = "yanlisSifre")
    public void yanlisSifreKullanici() {

        qaConcortHotelPage = new QAConcortHotelPage();

        qaConcortHotelPage.username.clear();
        qaConcortHotelPage.username.sendKeys(ConfigReader.getProperty("CHInvalidUsername"));
        qaConcortHotelPage.password.clear();
        qaConcortHotelPage.password.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        qaConcortHotelPage.loginAccount.click();

        Assert.assertTrue(qaConcortHotelPage.wrongLoginTextElement.isDisplayed());

        Driver.closeDriver();
    }
}
