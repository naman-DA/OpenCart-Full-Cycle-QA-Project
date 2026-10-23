package Pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By myAccountLocator = By.linkText("My Account");
    By loginBtnLocator = By.linkText("Login");
    By registerBtnLocator = By.linkText("Register");
    By searchLocator = By.name("search");
    By searchButtonLocator = By.xpath("//button[@class=\"btn btn-light btn-lg\"]");
    By returnHomePageLocator = By.xpath("//img[@class=\"img-fluid\"]");


    // Methods
    public void clickMyAccount() {
        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement myAccount = wait.until(
            ExpectedConditions.visibilityOfElementLocated(myAccountLocator)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center', inline:'center'});",
            myAccount
        );

        try {
            wait.until(
                ExpectedConditions.elementToBeClickable(myAccountLocator)
            ).click();
        } catch (ElementClickInterceptedException e) {
            WebElement currentElement = driver.findElement(myAccountLocator);

            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", currentElement
            );
        }
    }

    public void clickLogin() {
        driver.findElement(loginBtnLocator).click();
    }

    public void clcikRegister() {
        driver.findElement(registerBtnLocator).click();
    }

    public void clickSearch(String search)
    {
        driver.findElement(searchLocator).sendKeys(search);
        driver.findElement(searchLocator).click();
    }

    public void clickSearckButton()
    {
        driver.findElement(searchButtonLocator).click();
    }

    public void returnHomePage()
    {
        driver.findElement(returnHomePageLocator).click();
    }

}
