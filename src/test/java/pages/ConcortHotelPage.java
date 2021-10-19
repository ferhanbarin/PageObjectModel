package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {

    WebDriver driver;

    public ConcortHotelPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (linkText = "Log in")
    public WebElement loginMenu;

    @FindBy (xpath = "//input[@id='UserName']")
    public WebElement username;

    @FindBy (xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy (id = "btnSubmit")
    public WebElement loginAccount;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement wrongPassword;

    @FindBy(xpath="//span[text()='ListOfUsers']")
    public WebElement succesLoginTextElement;
}
