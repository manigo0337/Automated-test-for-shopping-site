package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhatsNewPage extends BasePage{
    public WhatsNewPage(WebDriver driver){
        super(driver);
    }

    By itemLinkBy = By.xpath("//a[@title='Gobi HeatTec&reg; Tee']");


    public WhatsNewPage navigateToTheItem(){
        scrollToTheElement(itemLinkBy);
        return this;
    }

    public WhatsNewPage clickOnTheItem(){
        click(itemLinkBy);
        return this;
    }


    
}
