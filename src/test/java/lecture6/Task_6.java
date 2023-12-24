package lecture6;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleWebDriver.*;

public class Task_6 {

    @BeforeTest
    public void setUp(){
        setUpWebDriver("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void login(){
        getWebDriver().findElement(By.id("user-name")).click();
        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.name("password")).click();
        getWebDriver().findElement(By.name("password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.className("submit-button")).click();
    }

    @Test(priority = 2)
    public void addingAnItemToTheCart(){
        getWebDriver().findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
        getWebDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        getWebDriver().findElement(By.className("shopping_cart_link")).click();

        Assert.assertEquals(getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name']")).getText(),"Sauce Labs Backpack", "The name of the product does not match");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//div[@class='inventory_item_price']")).getText(),"$29.99","Wrong price");

    }

    @Test(priority = 3)
    public static void addingMultipleItemsToCart(){
        getWebDriver().findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        getWebDriver().findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        getWebDriver().findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        getWebDriver().findElement(By.className("shopping_cart_link")).click();

        Assert.assertEquals(getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name']")).getText(),"Sauce Labs Backpack", "The name of the product does not match");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//div[@class='inventory_item_price']")).getText(),"$29.99","Wrong price");

    }

    @AfterTest
    public void endSession(){
        quit();
    }
}
