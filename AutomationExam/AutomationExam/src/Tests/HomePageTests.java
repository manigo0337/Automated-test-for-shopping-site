package Tests;

import org.junit.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTests extends BaseTests{
    @Test
    public void verifyThatUserCanSignOut(){
        HomePage homePage = new HomePage(driver);
        LoginPage logInPage = new LoginPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToSignin();
        logInPage.login(email, password);
        logInPage.navigateBackToHomePage();
        homePage.confirmUserIsOnHomePage();
        homePage.expandMenu();
        homePage.navigateToSignOut();
        homePage.validateThatUserIsLoggedOut();
    }

    @Test
    public void verifyTheNumberOFProductsInHotSellersSection(){
        HomePage homePage = new HomePage(driver);
        LoginPage logInPage = new LoginPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToSignin();
        logInPage.login(email, password);
        logInPage.navigateBackToHomePage();
        homePage.scrollToItem();
        homePage.verifyNumberOfProducts();
    }
    
}
