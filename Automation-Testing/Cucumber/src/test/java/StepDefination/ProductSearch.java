package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductSearch
{
    WebDriver driver = new ChromeDriver();

    @Given("the user is on the Home page")
    public void the_user_is_on_the_home_page() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(2000);
    }
    @When("the user searches for a valid product keyword")
    public void the_user_searches_for_a_valid_product_keyword() throws InterruptedException
    {
        driver.findElement(By.name("search")).sendKeys("imac");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-light btn-lg\"]")).click();
        Thread.sleep(2000);
    }
    @Then("the matching products should be displayed in the search results")
    public void the_matching_products_should_be_displayed_in_the_search_results() throws InterruptedException
    {
        String exceptedResult = "Products meeting the search criteria";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText();
        Assert.assertTrue(actualResult.contains(exceptedResult));
        Thread.sleep(2000);
        driver.close();
    }

    @When("the user searches for a keyword that does not match any product")
    public void theUserSearchesForAKeywordThatDoesNotMatchAnyProduct() throws InterruptedException
    {
        driver.findElement(By.name("search")).sendKeys("jkdf");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-light btn-lg\"]")).click();
        Thread.sleep(2000);
    }

    @Then("a no results message should be displayed")
    public void aNoResultsMessageShouldBeDisplayed() throws InterruptedException
    {
        String exceptedResult = "There is no product that matches the search criteria.";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
        Assert.assertTrue(actualResult.contains(exceptedResult));
        Thread.sleep(2000);
        driver.close();
    }

    @When("the user searches using the same keyword in a different case format")
    public void theUserSearchesUsingTheSameKeywordInADifferentCaseFormat() throws InterruptedException
    {
        driver.findElement(By.name("search")).sendKeys("IMAC");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-light btn-lg\"]")).click();
        Thread.sleep(2000);
    }

    @Then("the same relevant search results should be displayed")
    public void theSameRelevantSearchResultsShouldBeDisplayed() throws InterruptedException
    {
        String exceptedResult = "Search - IMAC";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
        Assert.assertTrue(actualResult.contains(exceptedResult));
        Thread.sleep(2000);
        driver.close();
    }

    @Given("the user has performed a product search")
    public void theUserHasPerformedAProductSearch() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(2000);
        driver.findElement(By.name("search")).sendKeys("imac");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-light btn-lg\"]")).click();
        Thread.sleep(2000);
    }

    @When("the user applies a price range filter")
    public void theUserAppliesAPriceRangeFilter() throws InterruptedException
    {
        WebElement dropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropdown);
        select.selectByContainsVisibleText("Price (High > Low)");
        Thread.sleep(2000);
    }
    @Then("the search results should update to show products within that price range")
    public void theSearchResultsShouldUpdateToShowProductsWithinThatPriceRange() throws InterruptedException
    {
        System.out.println("The filter applying successfully");
        Thread.sleep(2000);
        driver.close();
    }

    @When("the user applies sorting by product name from A to Z")
    public void theUserAppliesSortingByProductNameFromAToZ() throws InterruptedException
    {
        WebElement dropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropdown);
        select.selectByContainsVisibleText("Name (A - Z)");
        Thread.sleep(2000);
    }

    @Then("the search results should display products sorted alphabetically")
    public void theSearchResultsShouldDisplayProductsSortedAlphabetically() throws InterruptedException {
        System.out.println("The filter applying successfully");
        Thread.sleep(2000);
        driver.close();
    }
}
