package Pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver= driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitVisibile(By elementBy){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitClickable(By elementBy){
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public void writeText(By elementBy, String text){
        waitClickable(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public void click(By elementBy){
        waitClickable(elementBy);
        driver.findElement(elementBy).click();
    }
    
    public String readText(By elementBy){
        waitVisibile(elementBy);
        return driver.findElement(elementBy).getText();
        
    }
    public void checkIfTextIsTheSame(String expectedText, String foundText){
        Assert.assertEquals(expectedText, foundText);
    }

    public void checkIfElementIsVisible(By elementBy){
        waitVisibile(elementBy);
        boolean isVisibile = driver.findElement(elementBy).isDisplayed();
        Assert.assertTrue(isVisibile);
    }

    public void scrollToTheElement(By elementBy) {
        WebElement element = driver.findElement(elementBy);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public int countItems(By elementBy){
        waitVisibile(elementBy);
        return driver.findElements(elementBy).size();
    }

    public void checkIfTheNumbersAreTheSame(int expectedNum, int foundNum){
        Assert.assertEquals(expectedNum, foundNum);
    }

    public void checkIfTheNumberIstheSame(double expectedNum, double foundNum){
        Assert.assertEquals(expectedNum, foundNum, 0.1);
    }

    public double parseStringToDouble(String stringToParse){
        return Double.parseDouble(stringToParse);
    }
   
    
}
