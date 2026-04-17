package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import pages.*;

public class Steps {

    WebDriver driver;
    LoginPage lp;
    PIMPage pim;
    DirectoryPage dir;
    LogoutPage lo;

    @Given("user launches browser")
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("user opens application")
    public void openApp() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("user enters username and password")
    public void login() {
        lp = new LoginPage(driver);
        lp.login("Admin", "admin123");
    }

    @When("user clicks login")
    public void clickLogin() {
        
    }

    @Then("user navigates to PIM and searches employee")
    public void pimSearch() throws InterruptedException {
        pim = new PIMPage(driver);
        pim.searchEmployee("A");
    }

    @Then("user navigates to Directory and searches employee")
    public void directorySearch() throws InterruptedException {
        dir = new DirectoryPage(driver);
        dir.searchDirectory("A");
    }

    @Then("user logs out")
    public void logout() throws InterruptedException {
        lo = new LogoutPage(driver);
        lo.logout();
        driver.quit();
    }
}