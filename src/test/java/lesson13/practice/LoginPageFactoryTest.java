package lesson13.practice;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageFactory.saucedemo.LoginPage;

public class LoginPageFactoryTest extends BaseTest {


    @BeforeMethod
    public void setUpTest(){
        get(LoginPage.class).open();
    }

    @Test(priority = 1, dataProvider = "get user name")
    public void loginTest(String userName) {
        get(LoginPage.class)
                .waitUntilPageLoaded()
                .verifyPage()
                .enterUsername(userName)
                .enterPassword(get(LoginPage.class).getPasswords())
                .clickLogin();
    }

    @DataProvider(name = "get user name")
    public Object[][] getData(){
        return new Object[][]{
                {"standard_user"},
                {"locked_out_user"},
                {"problem_user"},
                {"performance_glitch_user"},
                {"error_user"},
                {"visual_user"}
        };
    }
}
