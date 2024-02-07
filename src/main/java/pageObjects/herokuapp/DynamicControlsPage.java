package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

import java.awt.*;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class DynamicControlsPage extends BasePage {

    private final By header = By.tagName("h4");
    private final By checkBox = By.id("checkbox");
    private final By removeButton = By.xpath("//*[text()='Remove']");
    private final By itIsGoneText = By.id("message");
    private final By input = By.xpath("//*[@id='input-example']/descendant::input");
    private final By enableButton = By.xpath("//*[@id='input-example']/descendant::button");
    private final By itIsEnabledText = By.xpath("//*[@id='input-example']/descendant::p");


    public void verifyTitleText() {
        wait.until(textToBe(header, "Dynamic Controls"));
    }

    public void clickButtonRemove(){
        click(removeButton);
    }

    public void waitItIsGoneText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(itIsGoneText));
    }

    public void verifyCheckboxStatus(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkBox));
    }

    public void verifyInputOnDisable(){
        wait.until(attributeToBeNotEmpty(driver.findElement(input), "disabled"));
    }

    public void clickButtonEnable(){
        click(enableButton);
    }

    public void waitItIsEnableText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(itIsEnabledText));
    }

    public void verifyIfEnabled() {
        wait.until(not(attributeToBeNotEmpty(driver.findElement(input), "disabled")));
    }






}
