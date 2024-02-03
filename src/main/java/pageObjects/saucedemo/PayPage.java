package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;

import static driver.DriverCreation.getDriver;

public class PayPage extends BasePage {

    private final By header = By.className("app_logo");
    private final By productOnCheck = By.className("cart_item");
    private final By paymentInformation = By.className("summary_info");
    private final By buttonFinish = By.id("finish");

    private final By backToProducts = By.id("back-to-products");

    public void verifyPage(){
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name.");
        Arrays.asList(productOnCheck, paymentInformation).forEach(el -> Assert.assertTrue(getDriver().findElement(el).isDisplayed(), "Element not displayed :: " + el));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html", "Wrong URL.");
    }
    public void finishPay(){
        click(buttonFinish);
    }

    public void backToProducts(){
        click(backToProducts);
    }
}
