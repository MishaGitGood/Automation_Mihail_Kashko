package lecture_7;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.*;


public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private PayPage payPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        payPage = new PayPage();
    }


    @Test(priority = 1)
    public void successfulLoginTestOne() {
        loginPage.open("https://www.saucedemo.com/");
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(0));
        loginPage.enterPassword(loginPage.getPasswords());
        loginPage.clickLogin();
    }

    @Test(priority = 2)
    public void addOneProductToCartTest() {
        productPage.verifyPage();
        productPage.clickAddToCard(1);
        productPage.clickShoppingCart();
    }

    @Test(priority = 3)
    public void deleteOneProductFromCartTest() {
        cartPage.verifyPage();
        cartPage.remove();
        cartPage.clickBurgerMenu();
        cartPage.clickLogout();
    }

    @Test(priority = 4)
    public void successfulLoginTestTwo() {
        loginPage.open("https://www.saucedemo.com/");
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(2));
        loginPage.enterPassword(loginPage.getPasswords());
        loginPage.clickLogin();
    }

    @Test(priority = 5)
    public void addTwoProductToCartTest() {
        productPage.verifyPage();
        productPage.clickAddToCard(1);
        productPage.clickAddToCard(4);
        productPage.clickShoppingCart();
    }

    @Test(priority = 6)
    public void deleteTwoProductFromCartTest() {
        cartPage.verifyPage();
        cartPage.remove();
        cartPage.clickBurgerMenu();
        cartPage.clickLogout();
    }

    @Test(priority = 7)
    public void successfulLoginTestThree() {
        loginPage.open("https://www.saucedemo.com/");
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(3));
        loginPage.enterPassword(loginPage.getPasswords());
        loginPage.clickLogin();
    }

    @Test(priority = 8)
    public void payToCart() {
        productPage.clickShoppingCart();
        cartPage.clickCheckout();
        checkoutPage.verifyPage();
        checkoutPage.enterFirstname();
        checkoutPage.enterLastname();
        checkoutPage.enterPostalCode();
        checkoutPage.clickContinue();
        payPage.verifyPage();
        payPage.finishPay();
        payPage.backToProducts();
    }
}