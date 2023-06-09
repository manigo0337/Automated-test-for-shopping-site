package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

    String baseUrl = "https://magento.softwaretestingboard.com/";
    By createAnAccountLinkBy = By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
    By signinLinkBy = By.xpath("//li[@class='authorization-link'][1] ");
    By signoutLinkBy = By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]");
    By welcomeMsgBy = By.xpath("//span[@class='not-logged-in']");
    By expandMenuBy = By.xpath("//button[ @class='action switch'][1]");
    By itemBy= By.xpath("//a[@title='Argus All-Weather Tank']");
    By productsBy =By.xpath("//a[@class='product-item-link']");
    int expectedNumberOfProducts= 6;
    By whatsNewLink = By.xpath("//a[@class='level-top ui-corner-all' and @href='https://magento.softwaretestingboard.com/what-is-new.html' ]");
    By cartIconBy = By.xpath("//a[@class='action showcart']");
    By garbageIconBy = By.xpath("//a[@class='action delete']");
    By okIconBy = By.xpath("/html/body/div[3]/aside[2]/div[2]/footer/button[2]");
    By itemLinkBy = By.xpath("//a[@title='Gobi HeatTec&reg; Tee']");



    public HomePage goToBaseUrl(){
        driver.get(baseUrl);
        return this;
    }

    public HomePage goToCreateAccountPage(){
        click(createAnAccountLinkBy);
        return this;
    }

      
    public HomePage navigateToSignin(){
        click(signinLinkBy);
        return this;
    }

    public HomePage confirmUserIsOnHomePage(){
        checkIfElementIsVisible(welcomeMsgBy);
        return this;
     }

     public HomePage expandMenu(){
        click(expandMenuBy);
        return this;
    }

    public HomePage navigateToSignOut(){
        click(signoutLinkBy);
        return this;
    }

    public HomePage validateThatUserIsLoggedOut(){
        checkIfElementIsVisible(welcomeMsgBy);
        return this;
    }

    public HomePage scrollToItem(){
        scrollToTheElement(itemBy);
        return this;
    }

    public HomePage verifyNumberOfProducts(){
        int foundItems = countItems(productsBy);
        checkIfTheNumbersAreTheSame(expectedNumberOfProducts, foundItems);
        return this;
    }
    public HomePage navigateToWhatsNewPage(){
        click(whatsNewLink);
        return this;

    }

    public HomePage clickOnCartIcon(){
        click(cartIconBy);
        return this;
    }

    public HomePage clickOnGarbageIcon(){
        waitVisibile(itemLinkBy);
        click(garbageIconBy);
        return this;
    }

    public HomePage confirmDeletingTheItemFromCart(){
        click(okIconBy);
        return this;
    }

    
    
}
