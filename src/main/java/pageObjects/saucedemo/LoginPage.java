package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
import static propertyUtils.PropertyReader.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;

public class LoginPage extends BasePage {

    private final By header = By.className("login_logo");
    private final By username = By.id("user-name");
    private final By password = By.name("password");
    private final By login = By.cssSelector("input[value ='Login']");
    private final By loginCredentials = By.id("login_credentials");
    private final By passwordCredentials = By.className("login_password");


    public void open(String url) {
        getDriver().get(url);
    }
    public void open() {
        getDriver().get(getProperties().getProperty("url"));
    }

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name.");
        Arrays.asList(username, password, login).forEach(el -> Assert.assertTrue(getDriver().findElement(el).isDisplayed(), "Element not displayed :: " + el));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/", "Wrong URL.");
    }

    public void enterUsername(String username) {
        sendKeys(this.username, username);
    }

    public void enterUsername() {
        sendKeys(this.username, getProperties().getProperty("username"));
    }


    public void enterPassword(String password) {
        sendKeys(this.password, password);
    }

    public void enterPassword() {
        sendKeys(this.password, getProperties().getProperty("password"));
    }


    public void clickLogin() {
        click(login);
    }

    public List<String> getUsernames() {
        return Arrays.stream(getDriver().findElement(loginCredentials).getText().split("\n"))
                .filter(value -> !value.contains("Accepted usernames are"))
                .collect(Collectors.toList());
    }

    public String getPasswords() {
        return Arrays.stream(getDriver().findElement(passwordCredentials).getText().split("\n"))
                .filter(value -> !value.contains("Password for all users"))
                .findFirst().orElse("");
    }

    public void successfulLogin(){
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
    }

    public void unSuccessfulLogin(){
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
    }
}

