package PagesForTest;

import Base.BaseClass;
import Pages.HomePage;
import Pages.Loginpage;
import Pages.LogoutPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Logoutpage extends BaseClass {

    @Test
    public void logOut() {

        HomePage home = new HomePage(driver);
        Loginpage loginPage = new Loginpage(driver);
        LogoutPage logoutPage = new LogoutPage(driver);

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        home.clickMyAccount();
        home.clickLogin();

        String email = System.getenv("OPENCART_TEST_EMAIL");
        String password = System.getenv("OPENCART_TEST_PASSWORD");

        Assert.assertNotNull(email,
                "OPENCART_TEST_EMAIL environment variable is not set.");
        Assert.assertNotNull(password,
                "OPENCART_TEST_PASSWORD environment variable is not set.");

        loginPage.login(email, password);

        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("route=account/account"),
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".alert-danger")
            )
        ));

        if (driver.getCurrentUrl().contains("route=account/login")) {
            String errorMessage = driver.findElements(
                By.cssSelector(".alert-danger")
            ).stream()
            .filter(org.openqa.selenium.WebElement::isDisplayed)
            .map(org.openqa.selenium.WebElement::getText)
            .findFirst()
            .orElse("No visible login error message found.");

            Assert.fail("Login did not succeed. Details: " + errorMessage);
        }

        logoutPage.clickLogoutBtn();

        // Verify the logout confirmation page.
        wait.until(
            ExpectedConditions.urlContains("route=account/logout")
        );

        Assert.assertTrue(
            driver.getPageSource().contains("You have been logged off"),
            "Logout confirmation message was not displayed."
        );

        logoutPage.clickContinueBtn();

        wait.until(
            ExpectedConditions.urlContains("route=common/home")
        );
    }
}
