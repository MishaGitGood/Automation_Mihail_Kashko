package pageObjects.baseObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;

public abstract class BasePage {

    protected WebDriver driver;
    public WebDriverWait wait;
    protected Actions actions;

    {
        driver = getDriver();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    protected void navigateTo(String url) {
        System.out.println("Navigate to :: " + url);
        driver.get(url);
    }

    protected void click(By by) {
        click(driver.findElement(by));
    }

    protected void click(WebElement element) {
        System.out.println("Click on element :: " + element);
        waitUntilElementToBeClickable(element);
        element.click();
    }

    protected void sendKeys(By by, CharSequence... charSequences) {
        sendKeys(driver.findElement(by), charSequences);
    }

    protected void sendKeys(WebElement element, CharSequence... charSequences) {
        System.out.println("Enter in :: " + element + ", next values :: " + Arrays.toString(charSequences));
        element.clear();
        element.sendKeys(charSequences);
    }

    protected void waitUntil(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected Integer getElementsCount(By by) {
        return driver.findElements(by).size();
    }


    protected String getElementText(By by) {
        return getElementText(driver.findElement(by));
    }

    protected String getElementText(WebElement webElement) {
        return webElement.getText();
    }

    protected List<String> getElementTexts(By by) {
        return getElementTexts(driver.findElements(by));
    }

    protected List<String> getElementTexts(List<WebElement> webElements) {
        return webElements.stream().map(data -> data.getText()).collect(Collectors.toList());
    }

    protected void waitUntilTextToBe(By by, String expectedText) {
        wait.until(ExpectedConditions.textToBe(by, expectedText));
        System.out.println("Wait until text to be present :: " + expectedText);
    }

    protected void waitUntilTextNotToBe(By by, String expectedText) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(by, expectedText)));
        System.out.println("Wait until text not to be present :: " + expectedText);
    }

    protected void waitUntilElementToBeClickable(By by) {
        waitUntilElementToBeClickable(driver.findElement(by));
    }

    protected void waitUntilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("Wait until element to be clickable :: " + element);
    }

    protected void waitUntilElementToBeNotClickable(By by) {
        waitUntilElementToBeNotClickable(driver.findElement(by));
    }

    protected void waitUntilElementToBeNotClickable(WebElement element) {
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));
        System.out.println("Wait until element not to be clickable :: " + element);
    }
}
