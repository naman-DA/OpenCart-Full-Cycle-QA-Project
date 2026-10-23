package StepDefination;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.time.Duration;

public class checkout {

    WebDriver driver;
    WebDriverWait wait;

    @Given("user is on homepage")
    public void user_is_on_homepage()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/en-gb/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Given("user is logged in with {string} and {string}")
    public void user_is_logged_in(String email, String password) {
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Login']")).click();
    }

    @Given("product {string} is added to cart")
    public void add_product_to_cart(String productName) {
        driver.get("https://demo.opencart.com/index.php?route=product/search&search=" + productName);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button-group button[aria-label='Add to Cart']"))).click();
    }

    @When("user clicks on Checkout icon")
    public void click_checkout_icon() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#top-links a[title='Shopping Cart']"))).click();
    }

    @When("user proceeds to checkout with new address")
    public void proceed_checkout_new_address() {
        // الانتقال لصفحة Checkout
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-primary"))).click();

        // اختيار New Address
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='new']"))).click();
    }

    @When("fills first name {string}")
    public void fill_first_name(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-firstname"))).clear();
        driver.findElement(By.id("input-payment-firstname")).sendKeys(firstName);
    }

    @When("fills last name {string}")
    public void fill_last_name(String lastName) {
        driver.findElement(By.id("input-payment-lastname")).clear();
        driver.findElement(By.id("input-payment-lastname")).sendKeys(lastName);
    }

    @When("fills address1 {string}")
    public void fill_address1(String address1) {
        driver.findElement(By.id("input-payment-address-1")).clear();
        driver.findElement(By.id("input-payment-address-1")).sendKeys(address1);
    }

    @When("fills city {string}")
    public void fill_city(String city) {
        driver.findElement(By.id("input-payment-city")).clear();
        driver.findElement(By.id("input-payment-city")).sendKeys(city);
    }

    @When("selects country {string}")
    public void select_country(String countryName) {
        Select country = new Select(driver.findElement(By.id("input-payment-country")));
        country.selectByVisibleText(countryName);
    }

    @When("selects region {string}")
    public void select_region(String regionName) {
        Select region = new Select(driver.findElement(By.id("input-payment-zone")));
        region.selectByVisibleText(regionName);
    }

    @When("clicks continue")
    public void click_continue() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address"))).click();
    }

    @Then("user should proceed to payment page")
    public void verify_payment_page() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-method")));
        Assert.assertTrue(driver.findElement(By.id("button-payment-method")).isDisplayed());
        driver.quit();
    }

    @Then("error message {string} is displayed")
    public void verify_error_message(String message) {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".text-danger"))).getText();
        Assert.assertTrue(text.contains(message));
        driver.quit();
    }

    @When("user selects Guest Checkout")
    public void guest_checkout() {

        // فتح checkout
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-primary"))).click();

        // اختيار guest checkout
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='guest']"))).click();

        // زر متابعة Guest
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-account"))).click();
    }

    @When("fills all required data correctly")
    public void fill_guest_data() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-firstname"))).sendKeys("Malak");
        driver.findElement(By.id("input-payment-lastname")).sendKeys("Essam");
        driver.findElement(By.id("input-payment-address-1")).sendKeys("Street 123");
        driver.findElement(By.id("input-payment-city")).sendKeys("Cairo");

        Select country = new Select(driver.findElement(By.id("input-payment-country")));
        country.selectByVisibleText("Egypt");

        Select region = new Select(driver.findElement(By.id("input-payment-zone")));
        region.selectByVisibleText("Cairo");

        driver.findElement(By.id("button-guest")).click(); // زر Continue للـ Guest
    }
}
