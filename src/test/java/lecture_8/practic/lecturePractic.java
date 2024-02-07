package lecture_8.practic;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.*;


import static pageObjects.herokuapp.HomePageItems.*;

class lecturePractic extends BaseTest {

    HomePage homePage;

    @BeforeMethod
    public void precondition(){
        homePage = new HomePage();
        homePage.open("https://the-internet.herokuapp.com/");
    }
    @Test(priority = 1)
    public void abTestingTest(){
        ABTestControlPage controlPage = new ABTestControlPage();
        homePage.clickOnItem(AB_TESTING);
        controlPage.verifyTitleText();
    }

    @Test(priority = 2)
    public void checkBoxTest(){
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        homePage.clickOnItem(CHECKBOX);
        checkboxesPage.verifyElementsCount();
        checkboxesPage.clickCheckbox(1);
        checkboxesPage.verifyCheckboxStatus(1,true);
        /*checkboxesPage.clickCheckbox(1);
        checkboxesPage.verifyCheckboxStatus(1,false);*/
    }

    @Test(priority = 3)
    public void scrollTest(){
        InfiniteScrollPage scrollPage = new InfiniteScrollPage();
        homePage.clickOnItem(INFINITE_SCROLL);
        scrollPage.verifyTitleText();
        scrollPage.scroll(4);
    }

    @Test(priority = 4)
    public void iFrameTest(){
        FramesPage framesPage = new FramesPage();
        homePage.clickOnItem(FRAMES);
        framesPage.clickOnItem("iFrame");
        framesPage.switchToFrame();
        framesPage.enterText("Hello world!");
        framesPage.unSwitchToFrame();
    }



}
