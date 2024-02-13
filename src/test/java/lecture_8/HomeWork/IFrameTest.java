package lecture_8.HomeWork;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.FramesPage;
import pageObjects.herokuapp.home.HomePage;
import pageObjects.herokuapp.HomePageItems;

public class IFrameTest extends BaseTest {

    HomePage homePage;


    @BeforeTest
    public void precondition() {
        homePage = new HomePage();
        homePage.open("https://the-internet.herokuapp.com/");
    }

    @Test
    public void Test() {
        FramesPage framesPage = new FramesPage();
        homePage.clickOnItem(HomePageItems.FRAMES);
        framesPage.verifyTitleText();
        framesPage.clickOnItem("iFrame");
        framesPage.switchToFrame();
        framesPage.verifyText();
        framesPage.unSwitchToFrame();
    }


}
