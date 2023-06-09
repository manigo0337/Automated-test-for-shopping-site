package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver){
        super(driver);
    }

    By expectedTitileBy = By.xpath("//span[@data-ui-id='page-title-wrapper']");
    String expectedText = "Shopping Cart";
    By productPriceBy = By.xpath("//span[@data-th='Subtotal']");
    By totalPriceBy = By.xpath("//td[@class='amount' and @data-th='Order Total']");
    By choseTaxRateBy = By.xpath("/html/body/div[1]/main/div[3]/div/div[2]/div[1]/div[2]/div/table/tbody/tr[2]/th");
    By grandTotalTextBy = By.xpath("//*[@id='cart-totals']/div/table/tbody/tr[3]/th");
    By taxBy = By.xpath("/html/body/div[1]/main/div[3]/div/div[2]/div[1]/div[2]/div/table/tbody/tr[2]/td/span");
    

    public CartPage verifyUserIsOnCartPage(){
        String foundText = readText(expectedTitileBy);
        checkIfTextIsTheSame(expectedText, foundText);
        return this;

    }

    public CartPage verifyPriceOfTheProduct(double expectedPrice){
        String foundPrice = readText(productPriceBy);
        double foundPriceDouble = parseStringToDouble(foundPrice.substring(1));
        checkIfTheNumberIstheSame(expectedPrice, foundPriceDouble);
        return this;
    }
    

    public CartPage verifyPriceOfTheTax(double expectedTaxPrice){
        checkIfElementIsVisible(choseTaxRateBy);
        String foundTaxPrice = readText(taxBy);
        double foundPriceDouble = parseStringToDouble(foundTaxPrice.substring(1));
        checkIfTheNumberIstheSame(expectedTaxPrice, foundPriceDouble);
        return this;
    }

    public CartPage verifyGrandTotalPrice(double expectedTotalPrice){
        checkIfElementIsVisible(grandTotalTextBy);
        String foundTotalPrice = readText(totalPriceBy);
        double foundPriceDouble = parseStringToDouble(foundTotalPrice.substring(1));
        checkIfTheNumberIstheSame(expectedTotalPrice, foundPriceDouble);
        return this;
    }
}
