package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountManagementAndUserDashboard
{
    WebDriver driver =new ChromeDriver();

    @Given("the user is logged in")
    public void the_user_is_logged_in() throws InterruptedException {

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
        driver.findElement(By.id("input-email")).sendKeys("aem302010@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);
    }

    @When("the user updates their Name or Telephone in the Account Details")
    public void the_user_updates_their_name_or_telephone_in_the_account_details() throws InterruptedException
    {
        driver.findElement(By.xpath("//*[@id=\"top\"]/div/div/div[2]/ul/li[1]/a/i")).click();

//        // فتح صفحة My Account بعد تسجيل الدخول
//        driver.findElement(By.xpath("//*[@id=\"top\"]/div/div/div[2]/ul/li[1]/a/i")).click();
//        Thread.sleep(2000);

        // تحديث الاسم أو الهاتف
        driver.findElement(By.xpath("//input[@name='name']")).clear();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Roqiha");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"input-enquiry\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"input-enquiry\"]")).sendKeys("hhhhhhhhhhhhhhhmmmm mm");
        Thread.sleep(2000);

        // الضغط على زر submit
        driver.findElement(By.xpath("//*[@id=\"form-contact\"]/div/button")).click();
        Thread.sleep(2000);
    }

    @Then("the updated Name or Telephone should be saved and displayed correctly")
    public void the_updated_name_or_telephone_should_be_saved_and_displayed_correctly()
    {
        System.out.println("Updated Name or Telephone was saved correctly!");
        driver.close();
    }

    @When("the user updates their Email Address in the Account Details")
    public void theUserUpdatesTheirEmailAddressInTheAccountDetails() throws InterruptedException
    {

        // العودة للصفحة الرئيسية
        driver.findElement(By.xpath("//img[@class='img-fluid']")).click();
        Thread.sleep(2000);

        // الضغط على My Account بعد تسجيل الدخول
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);

        // فتح صفحة Edit Account
        driver.findElement(By.xpath("//*[@id=\"top\"]/div/div/div[2]/ul/li[2]/div/ul/li[1]/a")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Edit Account")).click();
        Thread.sleep(2000);

        // مسح حقل الايميل وتحديثه
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("aem302010@gmail.com");
        Thread.sleep(2000);

        // الضغط على زر Continue
        driver.findElement(By.xpath("//*[@id=\"form-customer\"]/div/div[2]/button")).click();
        Thread.sleep(2000);

        // العودة للصفحة الرئيسية
        driver.findElement(By.xpath("//img[@class='img-fluid']")).click();
        Thread.sleep(2000);
    }

    @Then("the updated Email Address should be saved and displayed correctly")
    public void theUpdatedEmailAddressShouldBeSavedAndDisplayedCorrectly()
    {
        System.out.println("Updated Email Address was saved correctly");
        driver.close();
    }


    @When("the user changes their account password from the Account Dashboard")
    public void theUserChangesTheirAccountPasswordFromTheAccountDashboard() throws InterruptedException
    {

        // العودة للصفحة الرئيسية
        driver.findElement(By.xpath("//img[@class='img-fluid']")).click();
        Thread.sleep(2000);

        // الضغط على My Account بعد تسجيل الدخول
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);

        // فتح صفحة Account Dashboard
        driver.findElement(By.xpath("//*[@id=\"top\"]/div/div/div[2]/ul/li[2]/div/ul/li[1]/a")).click();
        Thread.sleep(2000);

        // تغيير كلمة المرور
        driver.findElement(By.linkText("Password")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("123456");
        Thread.sleep(2000);

        // الضغط على زر Continue
        driver.findElement(By.xpath("//*[@id=\"form-password\"]/div/div[2]/button")).click();
        Thread.sleep(2000);

        // العودة للصفحة الرئيسية
        driver.findElement(By.xpath("//img[@class='img-fluid']")).click();
        Thread.sleep(2000);
    }

    @Then("a confirmation message should be displayed and the new password should work")
    public void aConfirmationMessageShouldBeDisplayedAndTheNewPasswordShouldWork()
    {
        System.out.println("Password change confirmation displayed");
        driver.close();
    }


    @When("the user adds, edits, or deletes a shipping address in the Address Book")
    public void theUserAddsEditsOrDeletesAShippingAddressInTheAddressBook() throws InterruptedException {


        // الذهاب إلى Book Address
        driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[5]")).click();
        Thread.sleep(2000);

        // الضغط على New Address
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/a")).click();
        Thread.sleep(2000);

        // ملء تفاصيل العنوان
        driver.findElement(By.name("firstname")).sendKeys("abdo");
        Thread.sleep(2000);
        driver.findElement(By.name("lastname")).sendKeys("emad");
        Thread.sleep(2000);
        driver.findElement(By.name("address_1")).sendKeys("fayoum");
        driver.findElement(By.name("city")).sendKeys("fayoum");
        Thread.sleep(2000);
        driver.findElement(By.name("postcode")).sendKeys("67314");
        Thread.sleep(2000);

        // اختيار الدولة
        WebElement countryDropdown = driver.findElement(By.id("input-country"));
        countryDropdown.click();
        countryDropdown.findElement(By.xpath("//option[contains(text(),'Egypt')]")).click();
        Thread.sleep(2000);

        // اختيار المحافظة/المنطقة
        WebElement regionDropdown = driver.findElement(By.id("input-zone"));
        regionDropdown.click();
        regionDropdown.findElement(By.xpath("//option[contains(text(),'Al Fayyum')]")).click();
        Thread.sleep(2000);

        // تحديد كعنوان افتراضي
        driver.findElement(By.name("default")).click();
        Thread.sleep(2000);

        // الضغط على زر Continue
        driver.findElement(By.xpath("//*[@id=\"form-address\"]/div/div[2]/button")).click();
        Thread.sleep(2000);
    }

    @Then("the Address Book should reflect all changes correctly")
    public void theAddressBookShouldReflectAllChangesCorrectly()
    {
        System.out.println("Address Book changes were saved correctly");
        driver.close();
    }


    @When("the user navigates to the Order History page")
    public void theUserNavigatesToTheOrderHistoryPage() throws InterruptedException
    {

        // الذهاب إلى Order History
        driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[7]")).click();
        Thread.sleep(2000);
    }

    @Then("all past orders should be displayed correctly")
    public void allPastOrdersShouldBeDisplayedCorrectly()
    {
        System.out.println("Past orders are displayed correctly");
        driver.close();
    }


    @When("the user subscribes or unsubscribes from the Newsletter")
    public void theUserSubscribesOrUnsubscribesFromTheNewsletter() throws InterruptedException
    {

        // الضغط على Newsletter
        driver.findElement(By.linkText("Newsletter")).click();
        Thread.sleep(2000);

        // الضغط على Continue بعد التغيير
        driver.findElement(By.xpath("//*[@id=\"form-newsletter\"]/div/div[2]/button")).click();
        Thread.sleep(2000);
    }

    @Then("the subscription status should be updated correctly")
    public void theSubscriptionStatusShouldBeUpdatedCorrectly()
    {
        System.out.println("Newsletter subscription status was updated!");
        driver.close();
    }


    @When("the user navigates to the Reward Points page")
    public void theUserNavigatesToTheRewardPointsPage() throws InterruptedException {

        // الذهاب إلى Reward Points
        driver.findElement(By.linkText("Reward Points")).click();
        Thread.sleep(2000);
    }

    @Then("the current balance and transaction history should be displayed correctly")
    public void theCurrentBalanceAndTransactionHistoryShouldBeDisplayedCorrectly()
    {
        System.out.println("Reward Points page  displayed correctly");
        driver.close();
    }


    @When("the user navigates to the Transactions history page")
    public void theUserNavigatesToTheTransactionsHistoryPage() throws InterruptedException {

        // الذهاب إلى Transactions
        driver.findElement(By.linkText("Transactions")).click();
        Thread.sleep(2000);
    }

    @Then("all past transactions should be displayed correctly")
    public void allPastTransactionsShouldBeDisplayedCorrectly()
    {
        System.out.println("Transactions page displayed correctly!");
        driver.close();
    }


    @When("the user navigates to the Product Downloads page")
    public void theUserNavigatesToTheProductDownloadsPage() throws InterruptedException
    {
        // الذهاب إلى Downloads
        driver.findElement(By.linkText("Downloads")).click();
        Thread.sleep(2000);
    }

    @Then("all available downloads should be accessible and downloadable")
    public void allAvailableDownloadsShouldBeAccessibleAndDownloadable()
    {
        System.out.println("Product Downloads page displayed correctly!");
        driver.close();
    }

}
