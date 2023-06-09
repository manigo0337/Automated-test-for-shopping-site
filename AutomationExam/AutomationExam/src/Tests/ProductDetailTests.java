package Tests;

import org.junit.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailPage;
import Pages.WhatsNewPage;

public class ProductDetailTests extends BaseTests{

    @Test
    public void checkIfUserCanAddProductToTheCartFromWhatsNewPage(){
        HomePage homePage = new HomePage(driver);
        LoginPage logInPage = new LoginPage(driver);
        WhatsNewPage whatsNewPage = new WhatsNewPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        

        homePage.goToBaseUrl();
        homePage.navigateToSignin();
        logInPage.login(email, password);
        homePage.confirmUserIsOnHomePage();
        homePage.navigateToWhatsNewPage();
        whatsNewPage.navigateToTheItem();
        whatsNewPage.clickOnTheItem();
        productDetailPage.selectingTheSizeOfTheProduct();
        productDetailPage.selectingTheColorOfTheProduct();
        productDetailPage.addProductToTheCart();
        productDetailPage.clickOnCartIcon();
        productDetailPage.verifyProductIsAddedToCart();
    
    }

        
}
