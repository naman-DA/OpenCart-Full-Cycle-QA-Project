package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By firstNameLocator = By.id("input-firstname");
    By lastNameLocator = By.id("input-lastname");
    By emailLocator = By.id("input-email");
    By passwordLocator = By.id("input-password");
    By privacyLocator = By.name("agree");
    By continueLocator = By.cssSelector("button.btn.btn-primary");
    By getContinueLocator2 = By.linkText("Continue");

    public void setFirstNameLocator(String firstName) {
        WebElement field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(firstNameLocator)
        );
        field.clear();
        field.sendKeys(firstName);
    }

    public void setLastNameLocator(String lastName) {
        WebElement field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(lastNameLocator)
        );
        field.clear();
        field.sendKeys(lastName);
    }

    public void setEmailLocator(String email) {
        WebElement field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(emailLocator)
        );
        field.clear();
        field.sendKeys(email);
    }

    public void setPasswordLocator(String password) {
        WebElement field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(passwordLocator)
        );
        field.clear();
        field.sendKeys(password);
    }

    public boolean isPrivacySelected() {
        return wait.until(
            ExpectedConditions.presenceOfElementLocated(privacyLocator)
        ).isSelected();
    }
    
    public void setPrivacyLocator() {
        WebElement checkbox = wait.until(
            ExpectedConditions.presenceOfElementLocated(privacyLocator)
        );

        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                checkbox
            );

        if (!checkbox.isSelected()) {
            try {
                wait.until(
                    ExpectedConditions.elementToBeClickable(privacyLocator)
                ).click();
            } catch (org.openqa.selenium.ElementClickInterceptedException e) {
                ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", checkbox);
            }
        }
    }
    
    public void setContinueLocator() {
        WebElement button = wait.until(
            ExpectedConditions.presenceOfElementLocated(continueLocator)
        );

        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                button
            );

        try {
            wait.until(
                ExpectedConditions.elementToBeClickable(continueLocator)
            ).click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", button);
        }
    }


    // Submit the form exactly as currently filled.
    // This does not automatically accept the privacy policy.
    public void submitRegistrationForm() {
        setContinueLocator();
    }

    // Preserve the original method for compatibility with existing tests.
    public void Register(
        String firstName,
        String lastName,
        String email,
        String password
    ) throws InterruptedException {
        setFirstNameLocator(firstName);
        setLastNameLocator(lastName);
        setEmailLocator(email);
        setPasswordLocator(password);
        setPrivacyLocator();
        setContinueLocator();
    }
}
