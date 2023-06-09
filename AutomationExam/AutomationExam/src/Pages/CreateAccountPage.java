package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage{
    public CreateAccountPage(WebDriver driver){
        super(driver);
    }

    By firstNameBy = By.xpath("//*[@id='firstname']");
    By lastNameBy = By.xpath("//*[@id='lastname']");
    By emailBy = By.xpath("//*[@id='email_address']");
    By passwordBy = By.xpath("//*[@id='password']");
    By passwordConfirmationBy = By.xpath("//*[@id='password-confirmation']");
    By createAccountLink = By.xpath("//button[@class ='action submit primary']");
    By expectedTextBy = By.xpath("//span[@class = 'base']");


    public CreateAccountPage createANewAccount(String firstName, String lastName, String email, String password, String confirmPassword){
        writeText(firstNameBy, firstName);
        writeText(lastNameBy, lastName);
        writeText(emailBy, email);
        writeText(passwordBy, password);
        writeText(passwordConfirmationBy, confirmPassword);
        click(createAccountLink);
        return this;

    }

    public CreateAccountPage confirmAccountIsCreated(){
        String foundText = readText(expectedTextBy);
        checkIfTextIsTheSame(null, null);
        return this;
    }
    
}
