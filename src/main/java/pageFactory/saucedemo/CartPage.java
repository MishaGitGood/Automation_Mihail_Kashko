package pageFactory.saucedemo;

import entities.saucedemo.Product;
import entities.saucedemo.ProductBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.List;

import static driver.DriverCreation.getDriver;

public class CartPage extends BasePage implements Page<CartPage> {

    @FindBy(className = "app_logo")
    WebElement header;
    @FindBy(xpath = "//*[@id='header_container']/descendant::span[2]")
    WebElement title;
    @FindBy(css = "div[id='shopping_cart_container']")
    WebElement cartButton;
    @FindBy(id = "checkout")
    WebElement checkout;
    private final By removeButton = By.xpath("//button[contains(@class,'btn btn_secondary btn_small cart_button')]");
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> list;

    @FindBy(id = "continue-shopping")
    WebElement continueBtn;

    public CartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public CartPage verifyPage() {
        Assert.assertEquals(header.getText(), "Swag Labs", "Wrong header name.");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/cart.html", "Wrong URL.");
        return this;
    }

    public CartPage openCart() {
        click(cartButton);
        return this;
    }

    public CartPage clickCheckout() {
        click(checkout);
        return this;
    }

    public CartPage clickContinue(){
        click(continueBtn);
        return this;
    }


    public CartPage removeItem(Product productName) {
        List<WebElement> allProducts = list;
        for (WebElement product : allProducts) {
            if (product.getText().equals(productName.getProductName())) {
                click(product.findElement(removeButton));
            }
        }
        return this;
    }

    public CartPage removeItem(ProductBuilder productBuilder) {
        List<WebElement> allProducts = list;
        for (WebElement product : allProducts) {
            if (product.getText().equals(productBuilder.getProduct())) {
                click(product.findElement(removeButton));
            }
        }
        return this;
    }

    @Override
    public CartPage waitUntilPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(checkout));
        return this;
    }


}
