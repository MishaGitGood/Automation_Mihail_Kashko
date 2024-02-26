package lesson13.practice;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageFactory.saucedemo.LoginPage;
import pageFactory.saucedemo.ProductPage;

public class ProductPageFactoryTest extends BaseTest {


        @BeforeTest
        public void precondition(){
            get(LoginPage.class)
                    .open()
                    .enterUsername()
                    .enterPassword()
                    .clickLogin();
        }

        @Test(dataProvider = "index", priority = 1)
        public void addProductCartTest(Integer index){
            get(ProductPage.class).waitUntilPageLoaded().clickAddToCard(index);
        }

        @DataProvider(name = "index")
        public Object[][] getData(){
            return new Object[][]{
                    {1},
                    {2},
                    {3},
                    {4}
            };
        }

}
