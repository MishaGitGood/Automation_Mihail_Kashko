package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;

import static driver.DriverCreation.getDriver;
import static propertyUtils.PropertyReader.*;

public class CheckoutPage extends BasePage {
    private final By header = By.className("app_logo");
    private final By checkOutInfo = By.className("checkout_info");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By buttonContinue = By.id("continue");

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name.");
        Arrays.asList(checkOutInfo, firstName, lastName, postalCode).forEach(element -> Assert.assertTrue(getDriver().findElement(element).isDisplayed(), "Element not displayed :: " + element));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html", "Wrong URL.");
    }

    public void clickContinue() {
        click(buttonContinue);
    }

    public void enterFirstname() {
        sendKeys(By.id("first-name"), "Ilon");
    }

    public void enterLastname() {
        sendKeys(By.id("last-name"), "Mask");
    }

    public void enterPostalCode() {
        sendKeys(By.id("postal-code"), "220018");
    }
}
