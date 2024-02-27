package pageFactory.saucedemo;

import entities.saucedemo.User;
import entities.saucedemo.UserBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;
import static propertyUtils.PropertyReader.getProperties;

public class LoginPage extends BasePage implements Page<LoginPage>{

    @FindBy(how = How.CLASS_NAME, using = "login_logo")
    WebElement header;
    @FindBy(how = How.ID, using = "user-name")
    WebElement username;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(css = "input[value ='Login']")
    WebElement login;
    @FindBy(id = "login_credentials")
    WebElement loginCredentials;
    @FindBy(className = "login_password")
    WebElement passwordCredentials;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage open(String url) {
        getDriver().get(url);
        return this;
    }

    public LoginPage open() {
        getDriver().get(getProperties().getProperty("url"));
        return this;
    }

    public LoginPage verifyPage() {
        Assert.assertEquals(header.getText(), "Swag Labs", "Wrong header name.");
        Arrays.asList(username, password, login).forEach(el -> Assert.assertTrue(el.isDisplayed(), "Element not displayed :: " + el));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/", "Wrong URL.");
        return this;
    }

    public LoginPage enterUsername(String username) {
        sendKeys(this.username, username);
        return this;
    }

    public LoginPage enterUsername() {
        sendKeys(this.username, getProperties().getProperty("username"));
        return this;
    }


    public LoginPage enterPassword(String password) {
        sendKeys(this.password, password);
        return this;
    }

    public LoginPage enterPassword() {
        sendKeys(this.password, getProperties().getProperty("password"));
        return this;
    }

    public LoginPage login(String username, String password){
       return enterUsername(username).enterPassword(password);
    }

    public LoginPage login(User user){
        return enterUsername(user.getUsername()).enterPassword(user.getPassword());
    }

    public LoginPage login(UserBuilder user){
        return enterUsername(user.getUsername()).enterPassword(user.getPassword());
    }


    public LoginPage clickLogin() {
        click(login);
        return this;
    }

    public List<String> getUsernames() {
        return Arrays.stream(loginCredentials.getText().split("\n"))
                .filter(value -> !value.contains("Accepted usernames are"))
                .collect(Collectors.toList());
    }

    public String getPasswords() {
        return Arrays.stream(passwordCredentials.getText().split("\n"))
                .filter(value -> !value.contains("Password for all users"))
                .findFirst().orElse("");
    }

    public void successfulLogin() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
    }

    public void unSuccessfulLogin() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
    }

    @Override
    public LoginPage waitUntilPageLoaded() {
        Arrays.asList(username, password, login).forEach(el -> wait.until(ExpectedConditions.visibilityOf(el)));
        return this;
    }
}

