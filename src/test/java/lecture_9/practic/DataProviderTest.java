package lecture_9.practic;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.*;

public class DataProviderTest extends BaseTest {

    private LoginPage loginPage;
    private NavigationPage navigationPage;

    @Parameters({"url", "userPassword"})
    @BeforeTest
    public void precondition(@Optional("https://www.saucedemo.com/") String url, @Optional("secret_sauce") String userPassword) {
        loginPage = new LoginPage();
        navigationPage = new NavigationPage();
        loginPage.open(url);
    }

    @Test(priority = 1, dataProvider = "get user name")
    public void loginTest(String userName, Boolean loginStatus) {
        loginPage.verifyPage();
        loginPage.enterUsername(userName);
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        if (loginStatus){
            navigationPage.openMenu();
            navigationPage.clickMenuItem("Logout");
        }
    }

    @DataProvider(name = "get user name")
    public Object[][] getData(){
        return new Object[][]{
                {"standard_user", true},
                {"locked_out_user", false},
                {"problem_user", true},
                {"performance_glitch_user", true},
                {"error_user", true},
                {"visual_user", true}
        };
    }

}
