package lesson13.hw;

import entities.saucedemo.Product;
import entities.saucedemo.ProductBuilder;
import entities.saucedemo.User;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.saucedemo.CartPage;
import pageFactory.saucedemo.LoginPage;
import pageFactory.saucedemo.ProductPage;
import pageObjects.baseObjects.BaseTest;

public class CartPageTest extends BaseTest {

    @BeforeTest
    public void setUpTest(){
        get(LoginPage.class).open();
        get(LoginPage.class)
                .waitUntilPageLoaded()
                .login(new User() {{
                    setUsername("standard_user");
                    setPassword("secret_sauce");
                }})
                .clickLogin();
    }

    @Test(priority = 1, dataProvider = "get product")
    public void cartTest(Product product) {
        get(ProductPage.class)
                .waitUntilPageLoaded()
                .clickAddToCart(product);
    }

    @Test(priority = 2, dataProvider = "get product")
    public void removeCartTest(Product product){
       get(CartPage.class)
               .openCart()
               .waitUntilPageLoaded()
               .removeItem(product)
               .clickContinue();
    }

    @Test(priority = 3, dataProvider = "get product builder")
    public void cartBuilderTest(ProductBuilder product) {
        get(ProductPage.class)
                .waitUntilPageLoaded()
                .clickAddToCart(product);
    }

    @Test(priority = 4, dataProvider = "get product builder")
    public void removeCartBuilderTest(ProductBuilder product){
        get(CartPage.class)
                .openCart()
                .waitUntilPageLoaded()
                .removeItem(product);
    }

    @DataProvider(name = "get product")
    public Object[][] getProductData() {
        return new Object[][]{
                {new Product() {{
                    setProductName("Sauce Labs Bolt T-Shirt");
                }}},
                {new Product() {{
                    setProductName("Sauce Labs Bike Light");
                }}},
                {new Product() {{
                    setProductName("Sauce Labs Bolt T-Shirt");
                }}},
                {new Product() {{
                    setProductName("Sauce Labs Fleece Jacket");
                }}}
        };
    }

    @DataProvider(name = "get product builder")
    public Object[][] getProductBuilderData(){
        return new Object[][]{
                {new ProductBuilder.Builder()
                        .withProduct("Sauce Labs Bolt T-Shirt")
                        .build()},
                {new ProductBuilder.Builder()
                        .withProduct("Sauce Labs Bike Light")
                        .build()},
                {new ProductBuilder.Builder()
                        .withProduct("Sauce Labs Bolt T-Shirt")
                        .build()},
                {new ProductBuilder.Builder()
                        .withProduct("Sauce Labs Fleece Jacket")
                        .build()},
        };
    }
}
