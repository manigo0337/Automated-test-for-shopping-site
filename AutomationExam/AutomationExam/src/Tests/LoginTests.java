package Tests;

import org.junit.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class LoginTests extends BaseTests {

    String invalidEmail = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
    String invalidPassword = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
    String emptyField = "This is a required field.";
    String noUsernameOrPassword = "A login and a password are required.";


    @Test
    public void validateThatUserCanLoginWithValidCredentials(){
        HomePage homePage = new HomePage(driver);
        LoginPage logInPage = new LoginPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToSignin();
        logInPage.login(email, password);
        homePage.confirmUserIsOnHomePage();
    }

    @Test
    public void validateThatUserCanNotLoginWithInvalidEmail(){
        HomePage homePage = new HomePage(driver);
        LoginPage logInPage = new LoginPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToSignin();
        logInPage.login("Mamagayo@gmail.com", password);
        logInPage.checkLoginErrorMessage(invalidEmail);
    }

    @Test
    public void validateThatUserCanNotLoginWithInvalidPassword(){
        HomePage homePage = new HomePage(driver);
        LoginPage logInPage = new LoginPage(driver);

        
        homePage.goToBaseUrl();
        homePage.navigateToSignin();
        logInPage.login(email, "papa");
        logInPage.checkLoginErrorMessage(invalidPassword);
    }

    @Test
    public void validateThatUserCanNotLoginWithoutEmail(){
        HomePage homePage = new HomePage(driver);
        LoginPage logInPage = new LoginPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToSignin();
        logInPage.login("", password);
        logInPage.checkEmptyFieldErrorMessage(noUsernameOrPassword);

    }

    @Test
    public void validateThatUserCanNotLoginWithoutPassword(){
        HomePage homePage = new HomePage(driver);
        LoginPage logInPage = new LoginPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToSignin();
        logInPage.login(email, "");
        logInPage.checkEmptyFieldErrorMessage(noUsernameOrPassword);
    }

    @Test
    public void verifyThatUserCanNotLoginWithoutCredentials(){
        LoginPage logInPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToSignin();
        logInPage.login("", "");
        logInPage.checkEmptyFieldErrorMessage(noUsernameOrPassword);

    }


}
