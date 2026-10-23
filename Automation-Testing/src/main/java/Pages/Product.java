package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Product
{
    WebDriver driver;
    public Product(WebDriver driver) {
        this.driver=driver;
    }

    By addToCartLocator = By.xpath("//button[@data-bs-toggle=\"tooltip\"]");
    By clickOnProduct = By.linkText("Apple Cinema 30");
    By clickOnProduct_Iphone = By.linkText("iPhone");
    By addToCartFromInPageDetails = By.id("button-cart");
    By cartBtnLocator = By.xpath("//button[@class=\"btn btn-lg btn-dark d-block dropdown-toggle\"]");
    By viewCartLocator = By.linkText("View Cart");
    By quantityLocator = By.name("quantity");
    By quantityUpdateLocator = By.xpath("//i[@class=\"fa-solid fa-rotate\"]");
    By removeProductFromCartLocator = By.xpath("//a[@title=\"Remove\"]");
    By continueBtnLocator = By.xpath("//a[@class=\"btn btn-primary\"]");
    By couponCodeBtnLocator = By.xpath("//button[@class=\"accordion-button collapsed\"]");
    By couponCodeLocator = By.id("input-coupon");
    By applyCouponLocator = By.xpath("//button[@form=\"form-coupon\"]");
    By currenceyLocator = By.xpath("//span[@class=\"d-none d-md-inline\"]");
    By euroLocator = By.linkText("€ Euro");
    By estimateShippingLocator = By.xpath("//button[@class=\"accordion-button collapsed\"]");
    By camerasLocator = By.linkText("Cameras");
    By desktopsLocator = By.linkText("Desktops");
    By macLocators = By.linkText("Mac (1)");
    By iphoneZoomLocator = By.xpath("//img[@class=\"img-thumbnail\"]");
    By nextToRightInZoomIphoneLocator = By.xpath("//button[@title=\"Next (Right arrow key)\"]");
    By reviewsLocator_iphone = By.xpath("//a[@class=\"nav-link\"]");
    By wishListLocator = By.xpath("//button[@title=\"Add to Wish List\"]");
    By ProductComparisonLocator_MacBook = By.xpath("//button[@title=\"Compare this Product\"]");
    By phoneLocator = By.xpath("//i[@class=\"fa-solid fa-phone\"]");
    By myAccountAfterLoginLocator =By.xpath("//*[@id=\"top\"]/div/div/div[2]/ul/li[2]/div/ul/li[1]/a");
    By editMyAccountLocator = By.linkText("Edit Account");
    By editMyEmailLocator = By.xpath("//input[@name=\"email\"]");
    By continueLocatorByXPath = By.xpath("//*[@id=\"form-customer\"]/div/div[2]/button");
    By passwordBtnLocator = By.linkText("Password");
    By enterPasswordLocator = By.xpath("//input[@name=\"password\"]");
    By confirmPasswordLocator=By.xpath("//input[@name=\"confirm\"]");
    By continueBtnPasswordLocator=By.xpath("//*[@id=\"form-password\"]/div/div[2]/button");
    By bookAddressBtnLocator=By.xpath("//*[@id=\"column-right\"]/div/a[5]");
    By newAddressBtnLocator=By.xpath("//*[@id=\"content\"]/div[2]/div[2]/a");
    By orderHistoryLocator=By.xpath("//*[@id=\"column-right\"]/div/a[7]");
    By newsLetterLocator=By.linkText("Newsletter");
    By rewardPointsLocator=By.linkText("Reward Points");
    By transactionsLocator=By.linkText("Transactions");
    By downloadsLocator=By.linkText("Downloads");




    public void clickAddToCartBtn()
    {
        driver.findElement(addToCartLocator).click();
    }

    public void clickOnProduct_AppleCinema()
    {
        driver.findElement(clickOnProduct).click();
    }

    public void clickOnProduct_iphone()
    {
        driver.findElement(clickOnProduct_Iphone).click();
    }

    public void AllStepsOnIphone() throws InterruptedException
    {
        driver.findElement(clickOnProduct_Iphone).click();
        Thread.sleep(2000);
        driver.findElement(iphoneZoomLocator).click();
        Thread.sleep(2000);
        driver.findElement(nextToRightInZoomIphoneLocator).click();
        Thread.sleep(2000);
        driver.findElement(nextToRightInZoomIphoneLocator).click();
    }

    public void addToCartFromInPageDetails()
    {
        driver.findElement(addToCartFromInPageDetails).click();
    }

    public void clickOnCart()
    {
        driver.findElement(cartBtnLocator).click();
    }

    public void clickOnViewCart()
    {
        driver.findElement(viewCartLocator).click();
    }

    public void setQuantityLocator(String quantity) throws InterruptedException
    {
        driver.findElement(quantityLocator).clear();
        Thread.sleep(3000);
        driver.findElement(quantityLocator).sendKeys(quantity);
        Thread.sleep(3000);
        driver.findElement(quantityUpdateLocator).click();
    }

    public void clickRemoveProductFromCart()
    {
        driver.findElement(removeProductFromCartLocator).click();
    }

    public void clickContinueBtn()
    {
        driver.findElement(continueBtnLocator).click();
    }

    public void CouponCode(String couponCode) throws InterruptedException
    {
        driver.findElement(couponCodeBtnLocator).click();
        Thread.sleep(2000);
        driver.findElement(couponCodeLocator).sendKeys(couponCode);
        Thread.sleep(2000);
        driver.findElement(applyCouponLocator).click();
    }

    public void clickCurrency() throws InterruptedException {
        driver.findElement(currenceyLocator).click();
        Thread.sleep(2000);
        driver.findElement(euroLocator).click();
    }

    public void EstimateShipping()
    {
        driver.findElement(estimateShippingLocator).click();
    }

    public void clickCamera()
    {
        driver.findElement(camerasLocator).click();
    }

    public void clickDesktops() throws InterruptedException
    {
        driver.findElement(desktopsLocator).click();
        Thread.sleep(2000);
        driver.findElement(macLocators).click();
    }

    public void clickReviewsSection()
    {
        driver.findElement(reviewsLocator_iphone).click();
    }

    public void submitReviews(String name , String yourReview) throws InterruptedException {
        driver.findElement(By.xpath("//input[@name=\"author\"]")).sendKeys(name);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@name=\"text\"]")).sendKeys(yourReview);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='radio' and @name='rating' and @value='3']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("button-review")).click();
        Thread.sleep(2000);
    }

    public void addToWishList()
    {
        driver.findElement(wishListLocator).click();
    }

    public void clickProductComparison()
    {
        driver.findElement(ProductComparisonLocator_MacBook).click();
    }

    public void changePhone(String name ,String email, String enquiry) throws InterruptedException
    {
        driver.findElement(phoneLocator).click();
        driver.findElement(By.xpath("//input[@name=\"name\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys(name);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name=\"email\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@name=\"enquiry\"]")).sendKeys(enquiry);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);

    }

    public void clickMyAccountAfterLogin()
    {
        driver.findElement(myAccountAfterLoginLocator).click();
    }

    public void clickEditMyAccount()
    {
        driver.findElement(editMyAccountLocator).click();
    }

    public void clickEditMyEmail(String email)
    {
        driver.findElement(editMyEmailLocator).sendKeys(email);
    }

    public void clearMyEmailField()
    {
        driver.findElement(editMyEmailLocator).clear();
    }

    public void clickContinueBtnByLinkText()
    {
        driver.findElement(continueLocatorByXPath).click();
    }

    public void changePasswordBtn(String newPassword) throws InterruptedException {
        driver.findElement(passwordBtnLocator).click();
        Thread.sleep(2000);
        driver.findElement(enterPasswordLocator).sendKeys(newPassword);
        Thread.sleep(2000);
        driver.findElement(confirmPasswordLocator).sendKeys(newPassword);
        Thread.sleep(2000);
        driver.findElement(continueBtnPasswordLocator).click();
    }

    public void addNewBookAddress(String firstName , String lastName, String address,String city, String ZIP   ) throws InterruptedException
    {
        driver.findElement(bookAddressBtnLocator).click();
        Thread.sleep(2000);
        driver.findElement(newAddressBtnLocator).click();
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        Thread.sleep(2000);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        Thread.sleep(2000);
        driver.findElement(By.name("address_1")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);
        Thread.sleep(2000);
        driver.findElement(By.name("postcode")).sendKeys(ZIP);
        Thread.sleep(2000);

        WebElement dropDownMenuForCountry = driver.findElement(By.id("input-country"));
        Select select = new Select(dropDownMenuForCountry);
        select.selectByContainsVisibleText("Egypt");
        Thread.sleep(2000);

        WebElement dropDownMenuForRegion = driver.findElement(By.id("input-zone"));
        Select select1 = new Select(dropDownMenuForRegion);
        select1.selectByContainsVisibleText("Al Fayyum");
        Thread.sleep(2000);

        driver.findElement(By.name("default")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"form-address\"]/div/div[2]/button")).click();





    }

    public void clickOnOrderHistory()
    {
        driver.findElement(orderHistoryLocator).click();
    }

    public void newsLetter() throws InterruptedException {
        driver.findElement(newsLetterLocator).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"form-newsletter\"]/div/div[2]/button")).click();

    }

    public void RewardPoints() throws InterruptedException
    {
        driver.findElement(rewardPointsLocator).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a")).click();

    }

    public void Transactions() throws InterruptedException {
        driver.findElement(transactionsLocator).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/a")).click();
    }

    public void Downloads() throws InterruptedException {
        driver.findElement(downloadsLocator).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
    }
}
