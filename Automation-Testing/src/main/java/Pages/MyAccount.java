package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MyAccount {
    WebDriver driver;

    public MyAccount(WebDriver driver) {
        this.driver = driver;
    }

    By editMyAccountLocator = By.xpath(
        "//a[contains(normalize-space(.), 'Edit your account information')]"
    );

    public void clickEditMyAccount() {
        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement editLink = wait.until(
            ExpectedConditions.visibilityOfElementLocated(editMyAccountLocator)
        );

        editLink.click();
    }
}
