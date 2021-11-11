package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class TestBaseCross {

    protected WebDriver driver;

    @Parameters ("browser")
    @BeforeClass
    public void setup(@Optional String browser) {

        driver = DriverCross.getDriver(browser);
    }

    @AfterClass
    public void tearDown() {

        DriverCross.closeDriver();
    }
}
