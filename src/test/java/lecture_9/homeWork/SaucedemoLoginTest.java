package lecture_9.homeWork;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class SaucedemoLoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void preconditions(@Optional("https://www.saucedemo.com/") String url) {
        loginPage = new LoginPage();
        loginPage.open(url);
    }

    @Step("Login with dataProvider")
    @Test(dataProvider = "userName_and_userPassword", description = "Successful and unsuccessful login")
    public void loginTest(String name, String password, String status) {
        loginPage.verifyPage();
        loginPage.enterUsername(name);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        if (status.equals("success")) {
            loginPage.successfulLogin();
        } else {
            loginPage.unSuccessfulLogin();
        }
    }

    @DataProvider(name = "userName_and_userPassword")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "success"},
                {"", "secret_sauce", "success"},
                {"standard_user", "", "success"},
                {"standard_user", "secret_sauce", "unSuccess"}
        };
    }
}
