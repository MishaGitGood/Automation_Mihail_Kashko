package lecture_5;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleWebDriver.*;


public class LamCalcTest {

    @BeforeTest
    public void setUp() {
        setUpWebDriver("https://masterskayapola.ru/kalkulyator/laminata.html");
    }


    @Test
    public void test_one() {
        calc("calc_roomwidth", "10");
        calc("calc_roomheight", "5");
        calc("calc_lamwidth", "1500");
        calc("calc_lamheight", "184");
        calc("calc_inpack", "20");
        calc("calc_price", "750");
        calc("calc_bias", "250");
        calc("calc_walldist", "15");

        WebElement Button = getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
        Button.click();

        WebElement result = getWebDriver().findElement(By.id("l_count"));
        Assert.assertTrue(result.isDisplayed(), "188");
    }


    @Test
    public void test_two() {
        calc("calc_roomwidth", "7");
        calc("calc_roomheight", "4");
        calc("calc_lamwidth", "1350");
        calc("calc_lamheight", "177");
        calc("calc_inpack", "18");
        calc("calc_price", "900");
        calc("calc_bias", "235");
        calc("calc_walldist", "11");

        WebElement Button = getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
        Button.click();

        WebElement result = getWebDriver().findElement(By.id("l_count"));
        Assert.assertTrue(result.isDisplayed(), "122");
    }

    @Test
    public void test_three() {
        calc("calc_roomwidth", "0");
        calc("calc_roomheight", "0");
        calc("calc_lamwidth", "0");
        calc("calc_lamheight", "0");
        calc("calc_inpack", "0");
        calc("calc_price", "0");
        calc("calc_bias", "0");
        calc("calc_walldist", "0");

        WebElement Button = getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
        Button.click();

        WebElement result = getWebDriver().findElement(By.id("l_count"));
        Assert.assertTrue(result.isDisplayed(), "200");
    }

    private static void calc(String locator, String value) {
        getWebDriver().findElement(By.name(locator)).click();
        getWebDriver().findElement(By.name(locator)).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name(locator)).sendKeys(value);
        getWebDriver().findElement(By.name(locator)).sendKeys(Keys.ENTER);
    }


    @AfterTest
    public void tearDown() {
        quit();
    }
}
