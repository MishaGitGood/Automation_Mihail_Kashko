package lecture_8.HomeWork;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DynamicControlsPage;
import pageObjects.herokuapp.HomePage;
import pageObjects.herokuapp.HomePageItems;

public class DynamicControlsTest extends BaseTest {
    HomePage homePage;


    @BeforeTest
    public void precondition() {
        homePage = new HomePage();
        homePage.open("https://the-internet.herokuapp.com/");
    }

    @Test
    public void Test(){
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        homePage.clickOnItem(HomePageItems.DYNAMIC_CONTROLS);
        dynamicControlsPage.verifyTitleText();
        dynamicControlsPage.clickButtonRemove();
        dynamicControlsPage.waitItIsGoneText();
        dynamicControlsPage.verifyCheckboxStatus();
        dynamicControlsPage.verifyInputOnDisable();
        dynamicControlsPage.clickButtonEnable();
        dynamicControlsPage.waitItIsEnableText();
        dynamicControlsPage.verifyIfEnabled();

    }
}
