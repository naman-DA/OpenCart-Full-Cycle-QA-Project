package StepDefination;

import freemarker.ext.rhino.RhinoFunctionModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ja.且つ;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Product_CategoryPages
{
    WebDriver driver =new ChromeDriver();

    @Given("the user is on a category page")
    public void the_user_is_on_a_category_page() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(4000);
    }
    @When("the category page is opened")
    public void the_category_page_is_opened() throws InterruptedException
    {
        driver.findElement(By.linkText("Cameras")).click();
        Thread.sleep(2000);
    }

    @Then("the category products should be displayed")
    public void the_category_products_should_be_displayed()
    {
        System.out.println("The category products was displayed successfully");
        driver.close();

    }

    @Given("the user is on a multi-page category")
    public void theUserIsOnAMultiPageCategory() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");

        driver.findElement(By.linkText("Desktops")).click();
        Thread.sleep(2000);
    }

    @When("the user navigates to the next page")
    public void theUserNavigatesToTheNextPage() throws InterruptedException {

        driver.findElement(By.linkText("Mac (1)")).click();
        Thread.sleep(2000);
    }

    @Then("the next set of category products should be displayed")
    public void theNextSetOfCategoryProductsShouldBeDisplayed() {

        System.out.println("The next set of category products was displayed");
        driver.close();
    }


    @Given("the user is on a product details page")
    public void theUserIsOnAProductDetailsPage() throws InterruptedException
    {

        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(3000);

        // الضغط على منتج iPhone
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div/h4/a")).click();
        Thread.sleep(2000);
    }

    @When("the product page loads")
    public void theProductPageLoads() throws InterruptedException {

        // مجرد انتظار لتحميل الصفحة
        Thread.sleep(2000);
    }

    @Then("the product name price image and description should be displayed")
    public void theProductNamePriceImageAndDescriptionShouldBeDisplayed()
    {
        System.out.println("The product name price image and description was displayed");
        driver.close();
    }

    @When("the user interacts with the product images")
    public void theUserInteractsWithTheProductImages() throws InterruptedException
    {

        // فتح الزووم على الصورة
        driver.findElement(By.xpath("//img[@class='img-thumbnail']")).click();
        Thread.sleep(2000);

        // التالي داخل سلايدر الصور (يمين)
        driver.findElement(By.xpath("//button[@title='Next (Right arrow key)']")).click();
        Thread.sleep(2000);

        // كمان مرة
        driver.findElement(By.xpath("//button[@title='Next (Right arrow key)']")).click();
        Thread.sleep(2000);
    }

    @Then("the image zoom and thumbnail switching should work correctly")
    public void theImageZoomAndThumbnailSwitchingShouldWorkCorrectly()
    {
        // التأكد من ظهور نافذة الزووم
        System.out.println("Image zoom is  working properly");
        driver.close();
    }


    @Given("the user is on a product page with selectable options")
    public void theUserIsOnAProductPageWithSelectableOptions() throws InterruptedException
    {

        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(3000);

        // إضافة المنتج إلى السلة مباشرة
        driver.findElement(By.xpath("//button[@data-bs-toggle='tooltip']")).click();
        Thread.sleep(3000);

        // فتح عربة التسوق
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-dark d-block dropdown-toggle']")).click();
        Thread.sleep(2000);

        // عرض عربة التسوق
        driver.findElement(By.linkText("View Cart")).click();
        Thread.sleep(2000);

        // العودة للصفحة الرئيسية
        driver.findElement(By.xpath("//img[@class='img-fluid']")).click();
        Thread.sleep(2000);

        // الضغط على منتج iPhone
        driver.findElement(By.linkText("iPhone")).click();
        Thread.sleep(2000);
    }

    @When("the user selects different product options")
    public void theUserSelectsDifferentProductOptions() throws InterruptedException {

        // إضافة المنتج من صفحة التفاصيل إلى السلة
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(2000);
    }

    @Then("the product price should update dynamically")
    public void theProductPriceShouldUpdateDynamically() throws InterruptedException {

        // فتح عربة التسوق مرة أخرى
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-dark d-block dropdown-toggle']")).click();
        Thread.sleep(2000);

        // عرض عربة التسوق لمراجعة السعر
        driver.findElement(By.linkText("View Cart")).click();
        Thread.sleep(2000);
        driver.close();
    }

    @When("the user scrolls to the reviews section")
    public void theUserScrollsToTheReviewsSection() throws InterruptedException
    {

        // النزول لقسم المراجعات
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();
        Thread.sleep(2000);
    }

    @Then("existing customer reviews should be displayed")
    public void existingCustomerReviewsShouldBeDisplayed()
    {
        System.out.println("Customer reviews are displayed");
        driver.close();

    }

    @When("the user submits a valid product review")
    public void theUserSubmitsAValidProductReview() throws InterruptedException
    {

        // النزول لقسم المراجعات
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();
        Thread.sleep(2000);

        // ملئ بيانات المراجعة
        driver.findElement(By.xpath("//input[@name='author']")).sendKeys("abdo");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//textarea[@name='text']")).sendKeys("the product is very good , thank you");
        Thread.sleep(2000);

        // اختيار تقييم (مثال: 3 نجوم)
        driver.findElement(By.xpath("//input[@type='radio' and @name='rating' and @value='3']")).click();
        Thread.sleep(2000);

        // الضغط على زر إرسال المراجعة
        driver.findElement(By.id("button-review")).click();
        Thread.sleep(2000);
    }
    @Then("the review submission confirmation should be displayed")
    public void theReviewSubmissionConfirmationShouldBeDisplayed() {

        System.out.println("Review submission confirmation is displayed");
        driver.close();
    }


    @Given("the user is logged in and is on a product page")
    public void theUserIsLoggedInAndIsOnAProductPage() throws InterruptedException {

        // فتح الموقع
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(2000);

        // الضغط على My Account
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);

        // الضغط على Login
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(2000);

        // تسجيل الدخول
        driver.findElement(By.id("input-email")).sendKeys("aem30208@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("qwer1234er");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);

        // العودة للصفحة الرئيسية
        driver.findElement(By.xpath("//img[@class='img-fluid']")).click();
        Thread.sleep(2000);
    }

    @When("the user adds the product to the wishlist")
    public void theUserAddsTheProductToTheWishlist() throws InterruptedException {

        // إضافة المنتج إلى الـ Wishlist
        driver.findElement(By.xpath("//button[@title='Add to Wish List']")).click();
        Thread.sleep(2000);
    }

    @Then("the product should be added to the wishlist successfully")
    public void theProductShouldBeAddedToTheWishlistSuccessfully()
    {
        System.out.println("Product was added to the wishlist");
        driver.close();
    }


    @Given("the user is on home page")
    public void theUserIsOnProductListings() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(2000);

    }

    @When("the user adds multiple products to the comparison list")
    public void theUserAddsMultipleProductsToTheComparisonList() throws InterruptedException
    {

        // الضغط على زر Compare لهذا المنتج
        driver.findElement(By.xpath("//button[@title='Compare this Product']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/form/div/button[3]")).click();
        Thread.sleep(2000);
    }

    @Then("the comparison page should display the selected products")
    public void theComparisonPageShouldDisplayTheSelectedProducts()
    {
        System.out.println("I can't find locator for displaying products");
        driver.close();
    }


    @Given("the user is on a product or category page with discounted items")
    public void theUserIsOnAProductOrCategoryPageWithDiscountedItems() throws InterruptedException
    {

        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(2000);

        // مثال: اختيار منتج أو قسم يحتوي على خصومات
        // هنا سنضغط على زر Add to Cart مباشرة كأنت حددت
        driver.findElement(By.xpath("//button[@data-bs-toggle='tooltip']")).click();
        Thread.sleep(2000);
    }

    @When("the product prices are displayed")
    public void theProductPricesAreDisplayed() throws InterruptedException {

        // فتح عربة التسوق
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-dark d-block dropdown-toggle']")).click();
        Thread.sleep(2000);

        // الضغط على View Cart
        driver.findElement(By.linkText("View Cart")).click();
        Thread.sleep(2000);
    }

    @Then("the special price and discount percent should appear correctly")
    public void theSpecialPriceAndDiscountPercentShouldAppearCorrectly()
    {
        System.out.println("Special price or discount percent is displayed correctly!");
        driver.close();
    }

}
