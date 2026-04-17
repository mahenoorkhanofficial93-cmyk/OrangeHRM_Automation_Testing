package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement profile;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout;

    public void logout() throws InterruptedException {
        profile.click();
        Thread.sleep(2000);
        logout.click();
    }
}