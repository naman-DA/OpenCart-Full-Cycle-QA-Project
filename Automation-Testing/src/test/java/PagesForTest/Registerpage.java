package PagesForTest;

import Base.BaseClass;
import Pages.HomePage;
import Pages.RegisterPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Registerpage extends BaseClass {

    private static final String PASSWORD = "TestPass123!";

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private RegisterPage openRegistrationPage() {
        HomePage home = new HomePage(driver);
        home.clickMyAccount();
        home.clcikRegister();

        getWait().until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("input-firstname")
            )
        );

        return new RegisterPage(driver);
    }

    private WebElement waitForError() {
        return getWait().until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".alert-danger")
            )
        );
    }

    // 1. Register with valid data
    @Test
    public void Register() {
        RegisterPage page = openRegistrationPage();

        String uniqueEmail =
            "qa" + System.currentTimeMillis() + "@example.com";

        page.setFirstNameLocator("QA");
        page.setLastNameLocator("Tester");
        page.setEmailLocator(uniqueEmail);
        page.setPasswordLocator(PASSWORD);
        page.setPrivacyLocator();

        page.submitRegistrationForm();

        boolean registrationSucceeded = getWait().until(driver ->
            driver.getCurrentUrl().contains("route=account/success")
            || driver.getTitle().contains(
                "Your Account Has Been Created"
            )
            || driver.getPageSource().contains(
                "Your Account Has Been Created"
            )
        );

        Assert.assertTrue(
            registrationSucceeded,
            "Expected registration success confirmation."
        );
    }

    // 2. Register with an email that already exists
    
    @Test
    public void RegisterWithSameEmail() {
        RegisterPage page = openRegistrationPage();

        String existingEmail = System.getenv("OPENCART_TEST_EMAIL");

        Assert.assertNotNull(
            existingEmail,
            "OPENCART_TEST_EMAIL environment variable is not set."
        );

        page.setFirstNameLocator("QA");
        page.setLastNameLocator("Tester");
        page.setEmailLocator(existingEmail);
        page.setPasswordLocator(PASSWORD);
        page.setPrivacyLocator();

        page.submitRegistrationForm();

        WebElement error = waitForError();

        Assert.assertTrue(
            error.isDisplayed(),
            "Expected a validation warning for a duplicate email."
        );

        Assert.assertTrue(
            error.getText().toLowerCase().contains("already registered"),
            "Expected a duplicate-email warning. Actual warning: "
                + error.getText()
        );
    }

    // 3. Submit the form with the first name empty
    @Test
    public void RegisterWithFirstNameFieldEmpty() {
        RegisterPage page = openRegistrationPage();

        page.setFirstNameLocator("");
        page.setLastNameLocator("Tester");
        page.setEmailLocator(
            "emptyname" + System.currentTimeMillis() + "@example.com"
        );
        page.setPasswordLocator(PASSWORD);
        page.setPrivacyLocator();

        page.submitRegistrationForm();

        WebElement firstNameField = driver.findElement(By.name("firstname"));

        String firstNameValue = firstNameField.getAttribute("value");
        String validationMessage = firstNameField.getAttribute("validationMessage");

        Assert.assertTrue(
            firstNameValue == null || firstNameValue.isEmpty(),
            "First name should remain empty"
        );

        Assert.assertFalse(
            validationMessage == null,
            "Validation message should be available"
        );
    }

    // 4. Submit an invalid email address
    @Test
    public void invalidEmailAddressFormat() {
        RegisterPage page = openRegistrationPage();

        page.setFirstNameLocator("QA");
        page.setLastNameLocator("Tester");
        page.setEmailLocator("invalid-email");
        page.setPasswordLocator(PASSWORD);
        page.setPrivacyLocator();

        page.submitRegistrationForm();

        WebElement email = driver.findElement(
            By.id("input-email")
        );

        String validationMessage =
            email.getDomProperty("validationMessage");

        boolean hasValidation =
            validationMessage != null
            && !validationMessage.isEmpty();

        hasValidation = hasValidation
            || !driver.findElements(
                By.cssSelector(".text-danger, .alert-danger")
            ).isEmpty();

        Assert.assertTrue(
            hasValidation,
            "Expected validation for an invalid email address."
        );
    }

    // 5. Verify that the privacy policy checkbox is initially unchecked
    @Test
    public void PrivacyPolicyCheckboxIsNotSelectedByDefault() {
        RegisterPage page = openRegistrationPage();

        Assert.assertFalse(
            page.isPrivacySelected(),
            "Privacy policy checkbox should be unchecked by default."
        );
    }

    // 6. Submit the form without accepting the privacy policy
    @Test
    public void ErrorMessageAppearWhenNotAgreeingToThePrivacyPolicy() {
        RegisterPage page = openRegistrationPage();

        page.setFirstNameLocator("QA");
        page.setLastNameLocator("Tester");
        page.setEmailLocator(
            "noagree" + System.currentTimeMillis() + "@example.com"
        );
        page.setPasswordLocator(PASSWORD);

        // Intentionally do not select the privacy checkbox.
        page.submitRegistrationForm();

        Assert.assertTrue(
            waitForError().isDisplayed(),
            "Expected a warning when the privacy policy is not accepted."
        );
    }
}
