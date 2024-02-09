package lecture_9.homeWork;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.CartPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class SaucedemoCartTest extends BaseTest {

    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    Integer counter = 0;

    @BeforeMethod
    public void preconditions() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        loginPage.open("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Test(priority = 1, invocationCount = 3)
    public void addProductsTest2() {
        productPage.verifyPage();
        productPage.clickItem("Sauce Labs Onesie");
        productPage.clickAddToCartButton();
        productPage.clickShoppingCart();
        cartPage.clickRemoveByIndex(1);
        cartPage.clickBurgerMenu();
        cartPage.clickLogout();
    }

    @Test(priority = 2, dataProvider = "addProductToCart")
    public void addProductToCartTest(String product) {
        productPage.verifyPage();
        productPage.clickItem(product);
        productPage.clickAddToCartButton();
        productPage.clickShoppingCart();
        cartPage.clickRemoveByIndex(1);
        cartPage.clickBurgerMenu();
        cartPage.clickLogout();
    }

    @DataProvider(name = "addProductToCart")
    public Object[][] getProduct() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"}
        };

    }
}
