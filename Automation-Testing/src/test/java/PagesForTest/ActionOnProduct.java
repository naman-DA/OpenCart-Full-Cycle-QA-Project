package PagesForTest;

import Base.BaseClass;
import Pages.HomePage;
import Pages.Loginpage;
import Pages.LogoutPage;
import Pages.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionOnProduct extends BaseClass
{
    @Test
    public void AddToCart_FromHomePage() throws InterruptedException {
        Product product = new Product(driver);
        product.clickAddToCartBtn();
        Thread.sleep(2000);
    }

    @Test
    public void addingProductWithout_SelectingMandatoryOption() throws InterruptedException {
        Product productPage = new Product(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement productLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Apple Cinema 30"))
        );
        productLink.click();

        Thread.sleep(5000);
        productPage.addToCartFromInPageDetails();
        Thread.sleep(5000);
    }

    @Test
    public void verifyIncreasing_DecreasingTheProductQuantityInTheCart() throws InterruptedException
    {
        Product productPage = new Product(driver);

        productPage.clickAddToCartBtn();
        Thread.sleep(3000);
        productPage.clickOnCart();
        Thread.sleep(3000);
        productPage.clickOnViewCart();
        Thread.sleep(3000);
        productPage.setQuantityLocator("2");
        Thread.sleep(3000);
    }

    @Test
    public void verifyRemovingProductFromTheShoppingCart() throws InterruptedException
    {
        Product productPage = new Product(driver);

        productPage.clickAddToCartBtn();
        Thread.sleep(3000);
        productPage.clickOnCart();
        Thread.sleep(3000);
        productPage.clickOnViewCart();
        Thread.sleep(3000);
        productPage.clickRemoveProductFromCart();
        Thread.sleep(3000);
        productPage.clickContinueBtn();
        Thread.sleep(3000);
    }

    @Test
    public void verifyTheErrorMessageWhenApplyingAnInvalidCouponCode() throws InterruptedException
    {
        Product productPage = new Product(driver);

        productPage.clickAddToCartBtn();
        Thread.sleep(3000);
        productPage.clickOnCart();
        Thread.sleep(3000);
        productPage.clickOnViewCart();
        Thread.sleep(3000);
        productPage.CouponCode("ABC123");
        Thread.sleep(3000);
    }

    @Test
    public void verifyCartPricesUpdateCorrectlyAfterChangingTheActiveCurrency() throws InterruptedException
    {
        Product productPage = new Product(driver);

        productPage.clickAddToCartBtn();
        Thread.sleep(3000);
        productPage.clickOnCart();
        Thread.sleep(3000);
        productPage.clickOnViewCart();
        Thread.sleep(3000);
        productPage.clickCurrency();
        Thread.sleep(3000);
    }

    @Test
    public void verifyTheAbilityToEstimateShippingCostsFromTheCartPage() throws InterruptedException
    {
        Product productPage = new Product(driver);
        HomePage home = new HomePage(driver);

        productPage.clickAddToCartBtn();
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

    }

    @Test
    public void verifyCartContentsArePreservedAfterLoggingOutAndLoggingBackIn() throws InterruptedException {
        HomePage home = new HomePage(driver);
        LogoutPage logoutpage = new LogoutPage(driver);
        Loginpage loginpage = new Loginpage(driver);

        home.clickMyAccount();
        Thread.sleep(2000);
        home.clickLogin();
        Product productPage = new Product(driver);
        Thread.sleep(2000);
        loginpage.login("aem30208@gmail.com","qwer1234er");
        Thread.sleep(2000);
        home.returnHomePage();
        Thread.sleep(3000);
        productPage.clickAddToCartBtn();
        Thread.sleep(3000);
        home.clickMyAccount();
        Thread.sleep(2000);
       logoutpage.clickLogoutBtn();
       Thread.sleep(2000);
        home.clickMyAccount();
        Thread.sleep(2000);
        home.clickLogin();
        Thread.sleep(3000);
        loginpage.login("aem30208@gmail.com","qwer1234er");
        Thread.sleep(2000);
    }

    @Test
    public void verifyCategoryPageLoadsAndDisplaysItsAssociatedProducts() throws InterruptedException {
        Product productPage = new Product(driver);
        productPage.clickCamera();
        Thread.sleep(2000);
    }

    @Test
    public void verifyPaginationWorksCorrectlyForCategoriesWithManyProducts() throws InterruptedException {
        Product productPage = new Product(driver);
        productPage.clickDesktops();
        Thread.sleep(2000);
    }

    @Test
    public void verifyTheProductDisplayPageShowsAllMandatoryInfoNamePriceImageDescription() throws InterruptedException {
        Product productPage = new Product(driver);
       productPage.clickOnProduct_iphone();
       Thread.sleep(2000);
    }

    @Test
    public void verifyProductThumbnailsAndTheMainImageZoomLightboxFunctionality() throws InterruptedException {
        Product productPage = new Product(driver);
        productPage.AllStepsOnIphone();
        Thread.sleep(3000);
    }

    @Test
    public void verifyTheProductPriceUpdatesDynamicallyBasedOnTheSelectedOptions() throws InterruptedException {
        Product productPage = new Product(driver);
        HomePage home = new HomePage(driver);

        productPage.clickAddToCartBtn();
        Thread.sleep(3000);
        productPage.clickOnCart();
        Thread.sleep(2000);
        productPage.clickOnViewCart();
        Thread.sleep(2000);
        home.returnHomePage();
        Thread.sleep(2000);
        productPage.clickOnProduct_iphone();
        Thread.sleep(2000);
        productPage.addToCartFromInPageDetails();
        Thread.sleep(2000);
        productPage.clickOnCart();
        Thread.sleep(2000);
        productPage.clickOnViewCart();
        Thread.sleep(2000);
    }

    @Test
    public void verifyTheProductReviewsSection() throws InterruptedException {
        Product productPage = new Product(driver);
        productPage.clickOnProduct_iphone();
        Thread.sleep(2000);
        productPage.clickReviewsSection();
        Thread.sleep(2000);
    }

    @Test
    public void verifyTheProductReviewsSection_SubmitReview() throws InterruptedException {
        Product productPage = new Product(driver);
        productPage.clickOnProduct_iphone();
        Thread.sleep(2000);
        productPage.clickReviewsSection();
        Thread.sleep(2000);
        productPage.submitReviews("abdo","the product is very good , thank you");
        Thread.sleep(2000);
    }

    @Test
    public void verifyAddingProductToTheWishListForLoginUser() throws InterruptedException {
        Product productPage = new Product(driver);
        Loginpage loginpage = new Loginpage(driver);
        HomePage home = new HomePage(driver);

        home.clickMyAccount();
        Thread.sleep(2000);
        home.clickLogin();
        Thread.sleep(2000);
        loginpage.login("aem30208@gmail.com","qwer1234er");
        Thread.sleep(2000);
        home.returnHomePage();
        Thread.sleep(2000);
        productPage.addToWishList();
        Thread.sleep(2000);
    }

    @Test
    public void verifyProductComparisonByAddingAndComparingMultipleItems() throws InterruptedException {
        Product productPage = new Product(driver);
        productPage.clickProductComparison();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/form/div/button[3]")).click();
        Thread.sleep(2000);
    }

    @Test
    public void verifyDisplayOfSpecialPricesAndDiscountPercentages() throws InterruptedException {
        Product productPage = new Product(driver);
        HomePage home = new HomePage(driver);
        productPage.clickAddToCartBtn();
        Thread.sleep(2000);
        productPage.clickOnCart();
        Thread.sleep(2000);
        productPage.clickOnViewCart();
        Thread.sleep(2000);
    }

    @Test
    public void verifyUpdatingNameOrTelephoneInAccountDetails() throws InterruptedException {
        Product productPage = new Product(driver);
        productPage.changePhone("seif","aem30208@gmail.com","moooooooohamed salaaaah");
    }

    @Test
    public void verifyUpdatingEmailAddressInAccountDetails() throws InterruptedException {
        Product productPage = new Product(driver);
        HomePage homePage = new HomePage(driver);
        Loginpage loginpage =new Loginpage(driver);

        homePage.clickMyAccount();
        Thread.sleep(2000);
        homePage.clickLogin();
        Thread.sleep(2000);
        loginpage.login("aem30208@gmail.com", "qwer1234er");
        Thread.sleep(2000);
        homePage.returnHomePage();
        Thread.sleep(2000);
        homePage.clickMyAccount();
        Thread.sleep(2000);
       productPage.clickMyAccountAfterLogin();
        Thread.sleep(2000);
        productPage.clickEditMyAccount();
        Thread.sleep(2000);
        productPage.clearMyEmailField();
        Thread.sleep(2000);
        productPage.clickEditMyEmail("aem3020@gmail.com");
        Thread.sleep(2000);
        productPage.clickContinueBtnByLinkText();
        Thread.sleep(2000);
        homePage.returnHomePage();
        Thread.sleep(2000);
    }

    @Test
    public void verifySuccessfulPasswordChangeFromAccountDashboard() throws InterruptedException {
        Product productPage = new Product(driver);
        HomePage homePage = new HomePage(driver);
        Loginpage loginpage =new Loginpage(driver);

        homePage.clickMyAccount();
        Thread.sleep(2000);
        homePage.clickLogin();
        Thread.sleep(2000);
        loginpage.login("aem3020@gmail.com", "qwer1234er");
        Thread.sleep(2000);
        homePage.returnHomePage();
        Thread.sleep(2000);
        homePage.clickMyAccount();
        Thread.sleep(2000);
        productPage.clickMyAccountAfterLogin();
        Thread.sleep(2000);
        productPage.changePasswordBtn("123456");
        Thread.sleep(2000);
        homePage.returnHomePage();
        Thread.sleep(2000);
    }

    @Test
    public void verifyAddingShippingAddressesInAddressBook() throws InterruptedException {
        Product productPage = new Product(driver);
        HomePage homePage = new HomePage(driver);
        Loginpage loginpage =new Loginpage(driver);

        homePage.clickMyAccount();
        Thread.sleep(2000);
        homePage.clickLogin();
        Thread.sleep(2000);
        loginpage.login("aem3020@gmail.com", "123456");
        Thread.sleep(2000);
        productPage.addNewBookAddress("abdo","emad","fayoum","fayoum","67314");
        Thread.sleep(2000);
    }

    @Test
    public void verifyOrderHistoryPageDisplaysAllPastOrders() throws InterruptedException {
        Product productPage = new Product(driver);
        HomePage homePage = new HomePage(driver);
        Loginpage loginpage =new Loginpage(driver);

        homePage.clickMyAccount();
        Thread.sleep(2000);
        homePage.clickLogin();
        Thread.sleep(2000);
        loginpage.login("aem3020@gmail.com", "123456");
        Thread.sleep(2000);
        productPage.clickOnOrderHistory();
        Thread.sleep(2000);
    }

    @Test
    public void verifySubscribingAndUnsubscribingFromNewsletter() throws InterruptedException {
        Product productPage = new Product(driver);
        HomePage homePage = new HomePage(driver);
        Loginpage loginpage =new Loginpage(driver);

        homePage.clickMyAccount();
        Thread.sleep(2000);
        homePage.clickLogin();
        Thread.sleep(2000);
        loginpage.login("aem3020@gmail.com", "123456");
        Thread.sleep(2000);
        productPage.newsLetter();
        Thread.sleep(2000);
    }

    @Test
    public void verifyRewardPointsBalancePage() throws InterruptedException {
        Product productPage = new Product(driver);
        HomePage homePage = new HomePage(driver);
        Loginpage loginpage =new Loginpage(driver);

        homePage.clickMyAccount();
        Thread.sleep(2000);
        homePage.clickLogin();
        Thread.sleep(2000);
        loginpage.login("aem3020@gmail.com", "123456");
        Thread.sleep(2000);
        productPage.RewardPoints();
        Thread.sleep(2000);
    }

    @Test
    public void verifyTransactionsPage() throws InterruptedException {
        Product productPage = new Product(driver);
        HomePage homePage = new HomePage(driver);
        Loginpage loginpage =new Loginpage(driver);

        homePage.clickMyAccount();
        Thread.sleep(2000);
        homePage.clickLogin();
        Thread.sleep(2000);
        loginpage.login("aem3020@gmail.com", "123456");
        Thread.sleep(2000);
        productPage.Transactions();
        Thread.sleep(2000);
    }

    @Test
    public void verifyAccessAndFunctionalityOfProductDownloadsPage() throws InterruptedException {
        Product productPage = new Product(driver);
        HomePage homePage = new HomePage(driver);
        Loginpage loginpage =new Loginpage(driver);

        homePage.clickMyAccount();
        Thread.sleep(2000);
        homePage.clickLogin();
        Thread.sleep(2000);
        loginpage.login("aem3020@gmail.com", "123456");
        Thread.sleep(2000);
        productPage.Downloads();
        Thread.sleep(2000);
    }


}
