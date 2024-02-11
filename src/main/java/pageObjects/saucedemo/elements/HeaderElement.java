package pageObjects.saucedemo.elements;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class HeaderElement extends BasePage {

    private final By menu = By.id("react-burger-menu-btn");
    private final By cart = By.className("shopping_cart_link");

    public void openMenu(){
        click(menu);
    }

    public void openCart(){
        click(cart);
    }



}
