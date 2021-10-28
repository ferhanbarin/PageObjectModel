package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReusableMethodKullanimi {

/*
    1) https://the-internet.herokuapp.com/windows adresine gidiniz.
    2) "Click Here" yazisina basalim.
    3) Yeni sayfada "New Window" yazisinin göründügünü test edelim.
*/

    @Test
    public void test() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        String firstPageHandle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        Set <String> allPagesHandle = Driver.getDriver().getWindowHandles();

        String secondPageHandle = "";
        for (String each: allPagesHandle) {
            if (!each.equals(firstPageHandle)) {
                secondPageHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(secondPageHandle);

        System.out.println(Driver.getDriver().getTitle());

        WebElement newWindowTextElement = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowTextElement.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void testReusableIle() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");

        WebElement newWindowTextElement = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowTextElement.isDisplayed());

        Driver.closeDriver();
    }
}
