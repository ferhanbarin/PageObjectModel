package tests.day15;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_E2ETest {

/*
    1. Tests packagenin altına class olusturun: D17_CreateHotel
    2. Bir metod olusturun: createHotel
    3. https://qa-environment.concorthotel.com/ adresine git.
    4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
    a. Username : manager
    b. Password  : Manager1!
    5. Login butonuna tıklayın.
    6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
    7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    8. Save butonuna tıklayın.
    9. "Hotel was inserted successfully" textinin göründüğünü test edin.
    10. OK butonuna tıklayın.
*/
    @Test
    public void createHotel() {

        QAConcortHotelPage qaConcortHotelPage = new QAConcortHotelPage();
        qaConcortHotelPage.concortHotelLogin();
        qaConcortHotelPage.hotelManagement.click();
        qaConcortHotelPage.hotelList.click();
        qaConcortHotelPage.addHotel.click();

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

        actions.click(qaConcortHotelPage.addHotelCodeBox).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().name()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).perform();

        Select select = new Select(qaConcortHotelPage.addHotelDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddHotelDropdownOption"));

        qaConcortHotelPage.addHotelSave.click();
        System.out.println(qaConcortHotelPage.addHotelSuccesText.getText());
        Assert.assertTrue(qaConcortHotelPage.addHotelSuccesText.isDisplayed());

        qaConcortHotelPage.addHotelAlertOk.click();

        Driver.closeDriver();
    }
}
