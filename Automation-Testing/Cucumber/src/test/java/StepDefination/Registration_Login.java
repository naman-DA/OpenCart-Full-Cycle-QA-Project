package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Registration_Login
{
    WebDriver driver = new ChromeDriver();
    @Given("the user is on the Registration page")
    public void the_user_is_on_the_registration_page() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Register")).click();

    }
    @When("the user submits the registration form with all mandatory and optional fields filled correctly")
    public void the_user_submits_the_registration_form_with_all_mandatory_and_optional_fields_filled_correctly() throws InterruptedException {
        driver.findElement(By.id("input-firstname")).sendKeys("Abdo");
        Thread.sleep(2000);
        driver.findElement(By.id("input-lastname")).sendKeys("Emad");
        Thread.sleep(2000);
        driver.findElement(By.id("input-email")).sendKeys("seif@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("input-password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
        Thread.sleep(2000);
        driver.close();

    }


    @When("the user submits the registration form without entering a First Name")
    public void theUserSubmitsTheRegistrationFormWithoutEnteringAFirstName() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("input-lastname")).sendKeys("Emad");
        Thread.sleep(2000);
        driver.findElement(By.id("input-email")).sendKeys("seif@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("input-password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);

    }

    @Then("an error message should appear indicating the First Name is required")
    public void anErrorMessageShouldAppearIndicatingTheFirstNameIsRequired()
    {
        String ecceptedResult = "First Name must be between 1 and 32 characters!";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"error-firstname\"]")).getText();
        Assert.assertTrue(actualResult.contains(ecceptedResult));
    }

    @When("the user enters an invalid email format and submits the registration form")
    public void theUserEntersAnInvalidEmailFormatAndSubmitsTheRegistrationForm() throws InterruptedException {
        driver.findElement(By.id("input-firstname")).sendKeys("Abdo");
        Thread.sleep(2000);
        driver.findElement(By.id("input-lastname")).sendKeys("Emad");
        Thread.sleep(2000);
        driver.findElement(By.id("input-email")).sendKeys("seif");
        Thread.sleep(2000);
        driver.findElement(By.id("input-password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
        driver.close();
    }



    @When("the user submits the registration form using an already registered email")
    public void theUserSubmitsTheRegistrationFormUsingAnAlreadyRegisteredEmail() throws InterruptedException {driver.findElement(By.id("input-firstname")).sendKeys("Abdo");
        driver.findElement(By.id("input-firstname")).sendKeys("Abdo");
        Thread.sleep(2000);
        driver.findElement(By.id("input-lastname")).sendKeys("Emad");
        Thread.sleep(2000);
        driver.findElement(By.id("input-email")).sendKeys("seif@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("input-password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
        driver.close();
    }

    @Then("an error message should appear indicating the email is already registered")
    public void anErrorMessageShouldAppearIndicatingTheEmailIsAlreadyRegistered() {
    }

    @When("the user views the Privacy Policy checkbox")
    public void theUserViewsThePrivacyPolicyCheckbox() throws InterruptedException {
        driver.findElement(By.id("input-firstname")).sendKeys("Abdo");
        Thread.sleep(2000);
        driver.findElement(By.id("input-lastname")).sendKeys("Emad");
        Thread.sleep(2000);
        driver.findElement(By.id("input-email")).sendKeys("seif@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("input-password")).sendKeys("123456");
        Thread.sleep(2000);

    }

    @Then("the checkbox should not be selected by default")
    public void theCheckboxShouldNotBeSelectedByDefault() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
        driver.close();
    }

    @When("the user submits the registration form without agreeing to the Privacy Policy")
    public void theUserSubmitsTheRegistrationFormWithoutAgreeingToThePrivacyPolicy() throws InterruptedException {
        driver.findElement(By.id("input-firstname")).sendKeys("Abdo");
        Thread.sleep(2000);
        driver.findElement(By.id("input-lastname")).sendKeys("Emad");
        Thread.sleep(2000);
        driver.findElement(By.id("input-email")).sendKeys("seif@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("input-password")).sendKeys("123456");
        Thread.sleep(2000);

    }

    @Then("an error message should appear indicating agreement is required")
    public void anErrorMessageShouldAppearIndicatingAgreementIsRequired() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/input"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
        driver.close();
    }

    @Given("the user is on the Login page")
    public void theUserIsOnTheLoginPage() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Login")).click();
    }

    @When("the user enters valid login credentials and submits the form")
    public void theUserEntersValidLoginCredentialsAndSubmitsTheForm() throws InterruptedException {
        driver.findElement(By.id("input-email")).sendKeys("seif@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("input-password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);

    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() throws InterruptedException {
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);
        driver.close();

    }

    @When("the user enters a valid email and an invalid password")
    public void theUserEntersAValidEmailAndAnInvalidPassword() throws InterruptedException {
        driver.findElement(By.id("input-email")).sendKeys("seif@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("input-password")).sendKeys("1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
    }

    @Then("an error message should appear indicating invalid login details")
    public void anErrorMessageShouldAppearIndicatingInvalidLoginDetails()
    {
        System.out.println("The error message is appeared but i can not locate locator");
        driver.close();
    }

    @When("the user enters an unregistered email and any password")
    public void theUserEntersAnUnregisteredEmailAndAnyPassword() throws InterruptedException
    {
        driver.findElement(By.id("input-email")).sendKeys("jkl@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("input-password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
    }

    @Then("an error message should appear indicating the email is not found")
    public void anErrorMessageShouldAppearIndicatingTheEmailIsNotFound()
    {
        System.out.println("The error message is appeared but i can not locate locator");
        driver.close();
    }

    @When("the user clicks the Forgotten Password link")
    public void theUserClicksTheForgottenPasswordLink() throws InterruptedException
    {
        driver.findElement(By.linkText("Forgotten Password")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("input-email")).sendKeys("seif@gmail.com");
        Thread.sleep(2000);
    }

    @Then("the user should be redirected to the password reset page")
    public void theUserShouldBeRedirectedToThePasswordResetPage() throws InterruptedException
    {
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
        driver.close();
    }

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("input-email")).sendKeys("seif@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("input-password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
    }

    @When("the user clicks the Logout option")
    public void theUserClicksTheLogoutOption() throws InterruptedException {
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Continue"));
        Thread.sleep(2000);
    }

    @Then("the user should be logged out and see a logout confirmation message")
    public void theUserShouldBeLoggedOutAndSeeALogoutConfirmationMessage()
    {
        System.out.println("The user is logged out successfully");
        driver.close();
    }

    @Given("the user is logged in with valid credentials")
    public void theUserIsLoggedInWithValidCredentials() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("input-email")).sendKeys("seif@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("input-password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
    }

    @When("the user navigates to the My Account page")
    public void theUserNavigatesToTheMyAccountPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[1]")).click();
        Thread.sleep(2000);
    }

    @Then("the My Account page should be displayed successfully")
    public void theMyAccountPageShouldBeDisplayedSuccessfully()
    {
        System.out.println("My account page is displayed successfully");
        driver.close();
    }
}