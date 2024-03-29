package lecture12.practice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.HomePageItems;
import pageObjects.herokuapp.home.HomePage;

public class HomePageTest extends BaseTest {

    @Parameters("item")
    @Test
    public void passedItemNavigationTest(String item){
        HomePage homePage = new HomePage();
        homePage.open("https://the-internet.herokuapp.com");
        homePage.clickOnItem(HomePageItems.SORTABLE_DATA_TABLES);
    }
}
