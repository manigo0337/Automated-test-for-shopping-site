package Tests;

import org.junit.Test;

import Pages.CreateAccountPage;
import Pages.HomePage;

public class CreateAccountTests extends BaseTests{
    

    @Test
    public void validateThatUserCanCreateAnAccount(){
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        homePage.goToBaseUrl();
        homePage.goToCreateAccountPage();
        createAccountPage.createANewAccount("Fernando", "Tores", "Tores@gmail.com", "Atletiko2023", "Atletiko2023");
        createAccountPage.confirmAccountIsCreated();
    }
    
    
}
