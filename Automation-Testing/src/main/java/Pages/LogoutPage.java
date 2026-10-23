package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By myAccountLocator = By.xpath(
        "//a[contains(., 'My Account')]"
    );

    By logOutLocator = By.linkText("Logout");
    By continueLocator = By.linkText("Continue");

    
    public void clickLogoutBtn() {
        WebElement logoutLink = wait.until(
            ExpectedConditions.presenceOfElementLocated(logOutLocator)
        );

        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                logoutLink
            );

        wait.until(ExpectedConditions.visibilityOf(logoutLink));

        try {
            wait.until(
                ExpectedConditions.elementToBeClickable(logOutLocator)
            ).click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", logoutLink);
        }
    }

    public void clickContinueBtn() {
        wait.until(
            ExpectedConditions.elementToBeClickable(continueLocator)
        ).click();
    }
}
