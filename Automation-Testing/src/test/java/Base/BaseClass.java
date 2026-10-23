package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass
{
   protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCartSite/");
        Thread.sleep(4000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException
    {
        driver.close();

    }
}
