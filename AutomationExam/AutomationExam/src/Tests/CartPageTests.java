package Tests;

import org.junit.Test;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailPage;
import Pages.WhatsNewPage;

public class CartPageTests extends BaseTests{

    double expectedTaxPrice = 0.00;
    double expectedProductPrice = 29.00;
    double expectedTotal = 29.00;
    //Pokusao sam da dodam drzavu i flat rate i sve je to super medjutim kada se pokrene test konstantno ucitava da je flat rate 0 umesto 5 malo sam istrazio online i ispada da bih morao da trazim access i proverim u admin sekciji sajta da li mogu da promenim vrednost flat rate
    

    @Test
    public void validateTheTotalPriceOfTheProduct(){
    HomePage homePage = new HomePage(driver);
    LoginPage logInPage = new LoginPage(driver);
    WhatsNewPage whatsNewPage = new WhatsNewPage(driver);
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);
    CartPage cartPage = new CartPage(driver);

    
    homePage.goToBaseUrl();
    homePage.navigateToSignin();
    logInPage.login(email, password);
    homePage.confirmUserIsOnHomePage();
    //homePage.clickOnCartIcon();
    //homePage.clickOnGarbageIcon();
    //homePage.confirmDeletingTheItemFromCart();//ideja jeste da se product obrise pri ponovnom ulasku na sajt zato sto dodavanje produkta ostaje upamceno na sajtu problem je sto se ponekad element pojavi u kartu ponekad ne nisam hteo da komplikujem sa wait time vec cisto sam napravio da radi i ovako uz povremeno rucno brisanje
    homePage.navigateToWhatsNewPage();
    whatsNewPage.navigateToTheItem();
    whatsNewPage.clickOnTheItem();
    productDetailPage.selectingTheSizeOfTheProduct();
    productDetailPage.selectingTheColorOfTheProduct();
    productDetailPage.addProductToTheCart();
    productDetailPage.clickOnCartIcon();
    productDetailPage.navigateToCart();   
    cartPage.verifyPriceOfTheProduct(expectedProductPrice);
    cartPage.verifyPriceOfTheTax(expectedTaxPrice);
    cartPage.verifyGrandTotalPrice(expectedTotal);



    }
    
}
