
package PagesForTest;

import Base.BaseClass;
import Pages.HomePage;
import Pages.Loginpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BaseClass {        
    private static final String VALID_EMAIL =
            System.getenv("OPENCART_TEST_EMAIL");

    private static final String VALID_PASSWORD =
            System.getenv("OPENCART_TEST_PASSWORD");


    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void openLoginPage() {
        HomePage home = new HomePage(driver);
        home.clickMyAccount();
        home.clickLogin();
    }

    @Test
    public void LoginWithValidData() {
        openLoginPage();

        Pages.Loginpage loginPage = new Pages.Loginpage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);

        getWait().until(
            ExpectedConditions.urlContains("route=account/account")
        );

        Assert.assertTrue(
            driver.getTitle().contains("My Account"),
            "Successful login should open the My Account page."
        );
    }

    @Test
    public void LoginWithInvalidEmail() {
        openLoginPage();

        Pages.Loginpage loginPage = new Pages.Loginpage(driver);
        loginPage.login(
            "invalid-login-user@example.com",
            VALID_PASSWORD
        );

        WebElement error = getWait().until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".alert-danger")
            )
        );

        Assert.assertTrue(
            error.getText().contains("Warning"),
            "An error warning should appear for an invalid email."
        );
    }

    @Test
    public void LoginWithInvalidPassword() {
        openLoginPage();

        Pages.Loginpage loginPage = new Pages.Loginpage(driver);
        loginPage.login(
            VALID_EMAIL,
            "DefinitelyWrongPassword987!"
        );

        WebElement error = getWait().until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".alert-danger")
            )
        );

        Assert.assertTrue(
            error.getText().contains("Warning"),
            "An error warning should appear for an invalid password."
        );
    }

    @Test
    public void verifyTheFunctionalityOfTheForgottenPasswordLink() {
        openLoginPage();

        Pages.Loginpage loginPage = new Pages.Loginpage(driver);
        loginPage.clickForgottenPassword();

        getWait().until(
            ExpectedConditions.urlContains("route=account/forgotten")
        );

        Assert.assertTrue(
            driver.getCurrentUrl().contains("route=account/forgotten"),
            "Forgotten Password page should open."
        );

        loginPage.setEmail(VALID_EMAIL);
        loginPage.clickContinueInForgettenPassword();

        WebElement message = getWait().until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".alert")
            )
        );

        Assert.assertFalse(
            message.getText().trim().isEmpty(),
            "A response message should appear after submitting the email."
        );
    }
}
