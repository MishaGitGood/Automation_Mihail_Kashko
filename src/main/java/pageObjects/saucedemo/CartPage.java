package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;

import static driver.DriverCreation.getDriver;

public class CartPage extends BasePage {

    private final By header = By.className("app_logo");
    private final By cartList = By.className("cart_list");
    private final By remove = By.id("remove-sauce-labs-bike-light");
    private final By buttonCheckout = By.id("checkout");
    private final By burgerMenu = By.id("react-burger-menu-btn");
    private final By logout = By.id("logout_sidebar_link");

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name.");
        Assert.assertFalse(getDriver().findElements(cartList).isEmpty(), "Cart list is empty.");
        Arrays.asList(buttonCheckout, remove).forEach(element -> Assert.assertTrue(getDriver().findElement(element).isDisplayed(), "Element not displayed :: " + element));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/cart.html", "Wrong URL.");
    }

    public void clickCheckout() {
        click(buttonCheckout);
    }
    public void clickBurgerMenu() {
        click(burgerMenu);
    }
    public void clickLogout() {
        click(logout);
    }
    public void remove() {
        click(remove);
    }


}
