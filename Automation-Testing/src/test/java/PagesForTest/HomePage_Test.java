package PagesForTest;

import Base.BaseClass;
import Pages.HomePage;
import Pages.Loginpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HomePage_Test  extends BaseClass
{
    @Test
    public void SearchOnProduct() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickSearch("imac");
        Thread.sleep(2000);
        home.clickSearckButton();
        Thread.sleep(2000);
    }

    @Test
    public void SearchOnProductNotHasResults() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickSearch("jkdhm");
        Thread.sleep(2000);
        home.clickSearckButton();
        Thread.sleep(2000);
    }

    @Test
    public void verifyTheAccuracyOfSearchResultsForCaseSensitivityupperOrlowerCase() throws InterruptedException
    {
        HomePage home = new HomePage(driver);

        home.clickSearch("imac");
        Thread.sleep(2000);
        home.clickSearckButton();
        Thread.sleep(2000);
        home.returnHomePage();
        Thread.sleep(2000);
        home.clickSearch("IMAC");
        Thread.sleep(2000);
        home.clickSearckButton();
        Thread.sleep(2000);
    }

    @Test
    public void verifyTheFilteringOfSearchResultsByNameRange() throws InterruptedException
    {
        HomePage home = new HomePage(driver);
        home.clickSearch("imac");
        Thread.sleep(2000);
        home.clickSearckButton();
        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropdown);
        select.selectByContainsVisibleText("Name (A - Z)");
        Thread.sleep(2000);

    }

    @Test
    public void verifyTheFilteringOfSearchResultsByPriceRange() throws InterruptedException
    {
        HomePage home = new HomePage(driver);
        home.clickSearch("imac");
        Thread.sleep(2000);
        home.clickSearckButton();
        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropdown);
        select.selectByContainsVisibleText("Price (High > Low)");
        Thread.sleep(2000);
    }

}
