package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

/*
    Facebook login sayfasina gidin.
    Kullanici adi : ferhanselenium@gmail.com
    Sifre : 12345
    Yazdigimizda giris yapamadigimizi test edin.
    Page sayfasinda cookiesPass() method'u olusturun.
 */

    @Test
    public void test() {

        driver.get("https://www.facebook.com/");

        FacebookPage facebookPage = new FacebookPage(driver);

        facebookPage.cookiesPass();
        facebookPage.email.sendKeys("ferhanselenium@gmail.com");
        facebookPage.password.sendKeys("12345");
        facebookPage.login.click();

        Assert.assertTrue(facebookPage.wrongLogin.isDisplayed());
    }
}
