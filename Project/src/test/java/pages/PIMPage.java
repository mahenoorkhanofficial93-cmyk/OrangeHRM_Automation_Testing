package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.Actions;

public class PIMPage {

    WebDriver driver;
    WebDriverWait wait;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath = "//span[text()='PIM']")
    WebElement pimMenu;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement empName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchBtn;

    @FindBy(xpath = "//div[contains(@class,'oxd-table-body')]")
    WebElement resultTable;

    public void searchEmployee(String name) {

        pimMenu.click();

        // wait for input field
        wait.until(ExpectedConditions.visibilityOf(empName));
        empName.sendKeys(name);

        // ✅ wait for suggestions dropdown
        List<WebElement> suggestions = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@role='listbox']//span")
            )
        );

        // ✅ click first suggestion
        suggestions.get(0).click();

        // now click search
        searchBtn.click();

        // wait for results
        wait.until(ExpectedConditions.visibilityOf(resultTable));

        // scroll to results
        Actions act = new Actions(driver);
        act.moveToElement(resultTable).perform();
    }
}