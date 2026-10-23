package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginpage {

    WebDriver driver;
    WebDriverWait wait;

    public Loginpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    By emailLocator = By.id("input-email");
    By passwordLocator = By.id("input-password");
    By loginBtnLocator = By.cssSelector("button.btn.btn-primary");

    By forgottenPasswordLocator = By.linkText("Forgotten Password");
    By continueLocator = By.cssSelector("button.btn.btn-primary");

    // Methods
    public void setEmail(String email) {
        WebElement emailField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(emailLocator)
        );
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setPassword(String pass) {
        WebElement passwordField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(passwordLocator)
        );
        passwordField.clear();
        passwordField.sendKeys(pass);
    }

    public void clickLogin() {
        wait.until(
            ExpectedConditions.elementToBeClickable(loginBtnLocator)
        ).click();
    }

    public void clickForgottenPassword() {
        wait.until(
            ExpectedConditions.elementToBeClickable(forgottenPasswordLocator)
        ).click();
    }

    public void clickContinueInForgettenPassword() {
        wait.until(
            ExpectedConditions.elementToBeClickable(continueLocator)
        ).click();
    }

    public void login(String email, String pass) {
        setEmail(email);
        setPassword(pass);
        clickLogin();
    }
}
