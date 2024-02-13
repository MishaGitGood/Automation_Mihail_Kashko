package lecture_10.practice;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.NavigationPage;
import pageObjects.saucedemo.ProductPage;

public class ProductPageTest extends BaseTest {

    private LoginPage loginPage;
    private NavigationPage navigationPage;
    private ProductPage productPage;


    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        navigationPage = new NavigationPage();
        productPage = new ProductPage();
        loginPage.open();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }

    @Test
    public void addProductToCartTest() {
        navigationPage.openMenu();
        navigationPage.clickMenuItem("All Items");
        productPage.clickAddToCard(1);
        productPage.headerElement.openCart();
    }
}
