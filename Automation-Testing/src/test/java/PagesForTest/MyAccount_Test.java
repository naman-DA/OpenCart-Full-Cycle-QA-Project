
package PagesForTest;

import Base.BaseClass;
import Pages.HomePage;
import Pages.Loginpage;
import Pages.MyAccount;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccount_Test extends BaseClass {

    @Test
    public void EditMyAccount() {
        String email = System.getenv("OPENCART_TEST_EMAIL");
        String password = System.getenv("OPENCART_TEST_PASSWORD");

        Assert.assertNotNull(email,
                "OPENCART_TEST_EMAIL environment variable is not set.");
        Assert.assertNotNull(password,
                "OPENCART_TEST_PASSWORD environment variable is not set.");

        HomePage home = new HomePage(driver);
        Loginpage loginPage = new Loginpage(driver);
        MyAccount myAccount = new MyAccount(driver);

        home.clickMyAccount();
        home.clickLogin();

        loginPage.login(email, password);

        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.urlContains("route=account/account"));

        Assert.assertEquals(
                driver.getTitle(),
                "My Account",
                "Login did not navigate to the My Account page.");

        myAccount.clickEditMyAccount();

        wait.until(
                ExpectedConditions.urlContains("route=account/edit"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("route=account/edit"),
                "Edit Account page did not open.");
    }
}
