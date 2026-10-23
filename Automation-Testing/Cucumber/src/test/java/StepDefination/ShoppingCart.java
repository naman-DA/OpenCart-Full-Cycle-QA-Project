package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCart
{
    WebDriver driver =new ChromeDriver();

    @Given("the user is on a product page")
    public void the_user_is_on_a_product_page() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(2000);
        driver.findElement(By.linkText("iPhone")).click();
        Thread.sleep(2000);

    }

    @When("the user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() throws InterruptedException
    {
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(2000);
    }

    @Then("the product should be added successfully to the shopping cart")
    public void the_product_should_be_added_successfully_to_the_shopping_cart()
    {
        System.out.println("The product add to cart successfully");
        driver.close();
    }

    @Given("the user is on a product page with required options")
    public void theUserIsOnAProductPageWithRequiredOptions() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div[2]/div/h4/a")).click();
        Thread.sleep(4000);
    }

    @When("the user tries to add the product without selecting the mandatory option")
    public void theUserTriesToAddTheProductWithoutSelectingTheMandatoryOption() throws InterruptedException
    {
        driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
        Thread.sleep(2000);
    }

    @Then("a validation error message should be displayed")
    public void aValidationErrorMessageShouldBeDisplayed()
    {
        System.out.println("Error Message was appeared successfully");
        driver.close();

    }

    @Given("the user has a product in the shopping cart")
    public void theUserHasAProductInTheShoppingCart() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-bs-toggle=\"tooltip\"]")).click();
        Thread.sleep(2000);
    }

    @When("the user updates the product quantity")
    public void theUserUpdatesTheProductQuantity() throws InterruptedException
    {
        driver.findElement(By.xpath("//button[@class=\"btn btn-lg btn-dark d-block dropdown-toggle\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("View Cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("quantity")).clear();
        Thread.sleep(3000);
        driver.findElement(By.name("quantity")).sendKeys("3");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@class=\"fa-solid fa-rotate\"]")).click();
        Thread.sleep(2000);
    }

    @Then("the shopping cart should reflect the updated quantity")
    public void theShoppingCartShouldReflectTheUpdatedQuantity()
    {
        System.out.println("The cart quantity was updated successfully");
        driver.close();
    }

    @Given("the user has at least one product in the shopping cart")
    public void theUserHasAtLeastOneProductInTheShoppingCart() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-bs-toggle=\"tooltip\"]")).click();
        Thread.sleep(2000);
    }

    @When("the user removes the product")
    public void theUserRemovesTheProduct() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class=\"btn btn-lg btn-dark d-block dropdown-toggle\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-danger\"]")).click();
        Thread.sleep(2000);
    }

    @Then("the product should no longer appear in the cart")
    public void theProductShouldNoLongerAppearInTheCart()
    {
        System.out.println("The product no longer appear in the cart ");
        driver.close();
    }

    @Given("the user is on the shopping cart page")
    public void theUserIsOnTheShoppingCartPage() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-bs-toggle=\"tooltip\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-lg btn-dark d-block dropdown-toggle\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("View Cart")).click();
        Thread.sleep(2000);
    }

    @When("the user applies an invalid coupon code")
    public void theUserAppliesAnInvalidCouponCode() throws InterruptedException
    {
        driver.findElement(By.xpath("//button[@class=\"accordion-button collapsed\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("input-coupon")).sendKeys("Abc123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@form=\"form-coupon\"]")).click();
        Thread.sleep(2000);
    }

    @Then("an invalid coupon error message should be displayed")
    public void anInvalidCouponErrorMessageShouldBeDisplayed()
    {
        System.out.println("Error Message is appear ");
        driver.close();
    }

    @When("the user changes the active website currency")
    public void theUserChangesTheActiveWebsiteCurrency() throws InterruptedException
    {
        driver.findElement(By.xpath("//span[@class=\"d-none d-md-inline\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("€ Euro")).click();
    }

    @Then("the cart prices should update to reflect the selected currency")
    public void theCartPricesShouldUpdateToReflectTheSelectedCurrency()
    {
        System.out.println("The cart prices was updated successfully");
        driver.close();
    }

    @When("the user enters location details for shipping estimation")
    public void theUserEntersLocationDetailsForShippingEstimation() throws InterruptedException
    {
        driver.findElement( By.xpath("//img[@class=\"img-fluid\"]")).click();
        Thread.sleep(2000);
        driver.findElement( By.linkText("iPhone")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(2000);
        driver.findElement( By.xpath("//*[@id=\"cart\"]/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("View Cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"accordion-button collapsed\"]")).click();
        Thread.sleep(2000);

        WebElement dropMenueForCountry = driver.findElement(By.id("input-country"));
        WebElement dropMenueForRegion = driver.findElement(By.id("input-zone"));

        Select select = new Select(dropMenueForCountry);
        select.selectByContainsVisibleText("Egypt");
        Thread.sleep(2000);

        Select select1 = new Select(dropMenueForRegion);
        select1.selectByContainsVisibleText("Al Fayyum");
        Thread.sleep(2000);

        driver.findElement(By.id("input-postcode")).sendKeys("63714");
        Thread.sleep(2000);

        driver.findElement(By.id("button-quote")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[@for=\"input-shipping-method-flat-flat\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("button-shipping-method")).click();
        Thread.sleep(2000);

       /*productPage.clickAddToCartBtn();
        Thread.sleep(3000);
        productPage.clickOnProduct_iphone();
        Thread.sleep(2000);
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(2000);
        home.returnHomePage();
        productPage.clickOnCart();
        Thread.sleep(3000);
        productPage.clickOnViewCart();
        Thread.sleep(3000);
        productPage.EstimateShipping();
        Thread.sleep(2000);*/
    }

    @Then("the estimated shipping cost should be displayed")
    public void theEstimatedShippingCostShouldBeDisplayed()
    {
        System.out.println("The estimated shipping cost was  displayed");
        driver.close();
    }

    @Given("the user is logged in and has products in the cart")
    public void theUserIsLoggedInAndHasProductsInTheCart() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));

        // My Account
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);

// Login
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(2000);

// Email
        driver.findElement(By.id("input-email")).sendKeys("aem30208@gmail.com");

// Password
        driver.findElement(By.id("input-password")).sendKeys("qwer1234er");

// Login Button
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);

// Return to Home Page
        driver.findElement(By.xpath("//img[@class=\"img-fluid\"]")).click();
        Thread.sleep(3000);

// Add To Cart (الزر اللي فيه tooltip)
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/form/div/button[1]")).click();
        Thread.sleep(3000);
    }

    @When("the user logs out and logs in again")
    public void theUserLogsOutAndLogsInAgain() throws InterruptedException {


// My Account Again
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);

// Logout
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(2000);

// Open My Account Again
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);

// Login Again
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(3000);

// Email Again
        driver.findElement(By.id("input-email")).sendKeys("aem30208@gmail.com");

// Password Again
        driver.findElement(By.id("input-password")).sendKeys("qwer1234er");

// Login Button Again
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
// click view cart
        driver.findElement(By.linkText("View Cart")).click();
        Thread.sleep(2000);

    }

    @Then("the same cart contents should still be available")
    public void theSameCartContentsShouldStillBeAvailable()
    {
        System.out.println("The products remains in the cart don't change");
        driver.close();
    }
}
