package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTests {
    public WebDriver driver;

    String email = "Tores@gmail.com";
    String password = "Atletiko2023";


    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.manage().getCookies().clear();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
    

   @After
   public void tearDown(){
    driver.quit();
   }
    
}
