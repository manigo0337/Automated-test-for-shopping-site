package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{
    public ProductDetailPage(WebDriver driver){
        super(driver);
    }

    By productSizeBy = By.id("option-label-size-143-item-170");
    By productColorBy = By.xpath("//div[ @id='option-label-color-93-item-49']");
    By addToCartBy = By.id("product-addtocart-button");
    By cartIconBy = By.xpath("//div[@class='minicart-wrapper']");
    By itemLinkBy = By.xpath("//a[@title='Gobi HeatTec&reg; Tee']");
    By expectedMessageBy = By.xpath("//*[@id='maincontent']/div[1]/div[2]/div/div/div");
    By viewAndEditBy = By.xpath("//a[@class='action viewcart']");


    public ProductDetailPage selectingTheSizeOfTheProduct(){
        click(productSizeBy);
        return this;
    }

    public ProductDetailPage selectingTheColorOfTheProduct(){
        click(productColorBy);
        return this;
    }

    public ProductDetailPage addProductToTheCart(){
        click(addToCartBy);
        return this;
    }

    public ProductDetailPage verifyProductIsAddedToCart(){
        checkIfElementIsVisible(itemLinkBy);
        return this;
    }

    public ProductDetailPage clickOnCartIcon(){
        checkIfElementIsVisible(expectedMessageBy);
        click(cartIconBy);
        return this;
    }

    public ProductDetailPage navigateToCart(){
        click(viewAndEditBy);
        return this;
    }
    
}
