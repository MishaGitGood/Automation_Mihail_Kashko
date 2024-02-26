package lecture12.homeWork;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.HomePageItems;
import pageObjects.herokuapp.SortableDataTablesPage;
import pageObjects.herokuapp.home.HomePage;

import java.util.stream.Collectors;

public class EmailTest extends BaseTest {

    @Test(priority = 1)
    public void emailTest(){
        HomePage homePage = new HomePage();
        homePage.open("https://the-internet.herokuapp.com");
        homePage.clickOnItem(HomePageItems.SORTABLE_DATA_TABLES);
        SortableDataTablesPage sortableDataTablesPage = new SortableDataTablesPage();
        System.out.println(sortableDataTablesPage.getTableCellsData(1).stream().filter(email -> email.contains("@")).map(email -> email.replaceAll("@[a-z.]+", "@gmail.com")).sorted().collect(Collectors.toList()));
    }
}
