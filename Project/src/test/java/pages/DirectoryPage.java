package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.Actions;

public class DirectoryPage {

    WebDriver driver;
    WebDriverWait wait;

    public DirectoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath = "//span[text()='Directory']")
    WebElement directoryMenu;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement nameField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchBtn;

    @FindBy(xpath = "//div[contains(@class,'oxd-grid-item')]")
    WebElement resultCard;

    public void searchDirectory(String name) {

        directoryMenu.click();

        // wait for input
        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.sendKeys(name);

        // ✅ wait for suggestions
        List<WebElement> suggestions = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@role='listbox']//span")
            )
        );

        // ✅ click first suggestion
        suggestions.get(0).click();

        // click search
        searchBtn.click();

        // wait for result cards
        wait.until(ExpectedConditions.visibilityOf(resultCard));

        // scroll to result
        Actions act = new Actions(driver);
        act.moveToElement(resultCard).perform();
    }
}