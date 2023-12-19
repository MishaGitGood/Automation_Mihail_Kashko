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
    public void setUp(){
       setUpWebDriver("https://masterskayapola.ru/kalkulyator/laminata.html");
    }


    @Test
    public void test_one(){
        getWebDriver().findElement(By.name("calc_roomwidth")).click();
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys("10");
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_roomheight")).click();
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys("5");
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_lamwidth")).click();
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys("1500");
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_lamheight")).click();
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys("184");
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_inpack")).click();
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys("20");
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_price")).click();
        getWebDriver().findElement(By.name("calc_price")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_price")).sendKeys("750");
        getWebDriver().findElement(By.name("calc_price")).sendKeys(Keys.ENTER);

        //Select calc_direct = new Select(getWebDriver().findElement(By.className("form-control bigheight")));
        //calc_direct.selectByValue("toh");

        getWebDriver().findElement(By.name("calc_bias")).click();
        getWebDriver().findElement(By.name("calc_bias")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_bias")).sendKeys("250");
        getWebDriver().findElement(By.name("calc_bias")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_walldist")).click();
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys("15");
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys(Keys.ENTER);

        WebElement Button = getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
        Button.click();

        WebElement result = getWebDriver().findElement(By.id("l_count"));
        Assert.assertTrue(result.isDisplayed(),"188");


    }

    @Test
    public void test_two(){
        getWebDriver().findElement(By.name("calc_roomwidth")).click();
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys("7");
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_roomheight")).click();
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys("4");
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_lamwidth")).click();
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys("1350");
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_lamheight")).click();
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys("177");
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_inpack")).click();
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys("18");
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_price")).click();
        getWebDriver().findElement(By.name("calc_price")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_price")).sendKeys("900");
        getWebDriver().findElement(By.name("calc_price")).sendKeys(Keys.ENTER);

        //Select calc_direct = new Select(getWebDriver().findElement(By.className("form-control bigheight")));
        //calc_direct.selectByValue("toh");

        getWebDriver().findElement(By.name("calc_bias")).click();
        getWebDriver().findElement(By.name("calc_bias")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_bias")).sendKeys("235");
        getWebDriver().findElement(By.name("calc_bias")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_walldist")).click();
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys("11");
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys(Keys.ENTER);

        WebElement Button = getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
        Button.click();

        WebElement result = getWebDriver().findElement(By.id("l_count"));
        Assert.assertTrue(result.isDisplayed(),"122");


    }

    @Test
    public void test_three(){
        getWebDriver().findElement(By.name("calc_roomwidth")).click();
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys("0");
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_roomheight")).click();
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys("0");
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_lamwidth")).click();
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys("0");
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_lamheight")).click();
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys("0");
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_inpack")).click();
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys("0");
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_price")).click();
        getWebDriver().findElement(By.name("calc_price")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_price")).sendKeys("0");
        getWebDriver().findElement(By.name("calc_price")).sendKeys(Keys.ENTER);

        //Select calc_direct = new Select(getWebDriver().findElement(By.className("form-control bigheight")));
        //calc_direct.selectByValue("toh");

        getWebDriver().findElement(By.name("calc_bias")).click();
        getWebDriver().findElement(By.name("calc_bias")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_bias")).sendKeys("0");
        getWebDriver().findElement(By.name("calc_bias")).sendKeys(Keys.ENTER);

        getWebDriver().findElement(By.name("calc_walldist")).click();
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys("0");
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys(Keys.ENTER);

        WebElement Button = getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
        Button.click();

        WebElement result = getWebDriver().findElement(By.id("l_count"));
        Assert.assertTrue(result.isDisplayed(),"200");


    }

    @AfterTest
    public void tearDown(){quit();}




}
