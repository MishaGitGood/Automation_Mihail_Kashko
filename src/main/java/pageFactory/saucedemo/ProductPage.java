package pageFactory.saucedemo;

import entities.saucedemo.Product;
import entities.saucedemo.ProductBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

import java.util.List;

import static driver.DriverCreation.getDriver;

public class ProductPage extends BasePage implements Page<ProductPage>{

    @FindBys({@FindBy(className = "inventory_item")})
    List<WebElement> productList;

    @FindBy(id = "inventory_container")
    WebElement inventoryContainer;
    private final By addToCard = By.xpath("//button[contains(@class,'btn btn_primary btn_small btn_inventory')]");

    @FindBy(className = "inventory_item_name")
    List<WebElement> list;

    public ProductPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void clickAddToCard(Integer index) {
        click(productList.get(index).findElement(addToCard));
    }
    public ProductPage clickAddToCart(Product productName) {
        List<WebElement> allProducts = list;
        for (WebElement product: allProducts) {
            if (product.getText().equals(productName.getProductName())) {
                click(product.findElement(addToCard));
            }
        }
        return this;
    }

    public ProductPage clickAddToCart(ProductBuilder productBuilder) {
        List<WebElement> allProducts = list;
        for (WebElement product: allProducts) {
            if (product.getText().equals(productBuilder.getProduct())) {
                click(product.findElement(addToCard));
            }
        }
        return this;
    }

    @Override
    public ProductPage waitUntilPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(inventoryContainer));
        return this;
    }
}
