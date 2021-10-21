package tests.day16;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;


public class C01_E2ETest2 {

/*
    3. https://qa-environment.concorthotel.com/ adresine gidin.
    4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
    a. Username : manager  b. Password  : Manager1!
    5. Login butonuna tıklayın.
    6. Hotel Management menusunden Add Hotel Room butonuna tıklayın.
    7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    8. Save butonuna basin.
    9. "HotelRoom was inserted successfully" textinin göründüğünü test edin.
    10. OK butonuna tıklayın.
    11. Hotel rooms linkine tıklayın.
    12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın.
*/

    @Test
    public void createHotelRoom() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAURL"));

        QAConcortHotelPage qaConcortHotelPage = new QAConcortHotelPage();
        qaConcortHotelPage.concortHotelLogin();
        qaConcortHotelPage.hotelManagement.click();
        qaConcortHotelPage.hotelRooms.click();
        qaConcortHotelPage.addHotelRoom.click();

        Select select = new Select(qaConcortHotelPage.idHotelDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddRoomIDHotel"));

        Thread.sleep(2000);

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().fullName()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHQAAddRoomDescription")).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHQAAddRoomPrice")).perform();

        select = new Select(qaConcortHotelPage.selectRoomTypeDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQARoomType"));

        actions.sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1, 2))).sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(0, 5)))
                .sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE).perform();

        Thread.sleep(2000);
        qaConcortHotelPage.addRoomSave.click();

        Thread.sleep(2000);
        Assert.assertTrue(qaConcortHotelPage.addRoomSucces.isDisplayed());
        qaConcortHotelPage.addRoomSuccesAlertOk.click();

        actions.sendKeys(Keys.HOME).perform();
        qaConcortHotelPage.addHotelRoomsHome.click();

        Assert.assertTrue(qaConcortHotelPage.listOfHotelRoomsText.isDisplayed());

        Driver.closeDriver();
    }
}
