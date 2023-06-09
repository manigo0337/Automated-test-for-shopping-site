package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
        super(driver);
    }

    By emailLinkBy = By.xpath("//*[@id='email']");
    By passwordLinkBy = By.xpath("//*[@id='pass']");
    By signinBtnBy = By.xpath("//*[@id='send2']");
    By logoIconBy = By.xpath("//img[@src='https://magento.softwaretestingboard.com/pub/static/version1678540400/frontend/Magento/luma/en_US/images/logo.svg']");
    By errorMessageBy = By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/div/div");
    By emptyFieldError = By.xpath("//*[@id='email-error']");
    By emptyUsernamePasswordFieldBy = By.xpath("/html/body/div[1]/main/div[2]/div[2]/div/div/div");


    public LoginPage login(String email, String password){
        writeText(emailLinkBy, email);
        writeText(passwordLinkBy, password);
        click(signinBtnBy);
        return this;
    }

    public LoginPage navigateBackToHomePage(){
        click(logoIconBy);
        return this;
    }

    public LoginPage checkLoginErrorMessage(String expectedText){
        String foundError = readText(errorMessageBy);
        checkIfTextIsTheSame(expectedText, foundError);
        return this;
    }

    public LoginPage checkEmptyFieldErrorMessage(String expectedText){
        String foundText = readText(emptyUsernamePasswordFieldBy);
        checkIfTextIsTheSame(expectedText, foundText);
        return this;
    }



    
}
