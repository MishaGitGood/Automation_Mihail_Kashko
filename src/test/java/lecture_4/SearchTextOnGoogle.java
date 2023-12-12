package lecture_4;


import net.bytebuddy.matcher.ElementMatcher;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static net.bytebuddy.matcher.ElementMatchers.is;


public class SearchTextOnGoogle {

    private WebDriver driver;
    private Map<String, Object> vars;

    private void assertThat(String text, ElementMatcher.Junction<Object> objectJunction){}
    JavascriptExecutor js;
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void searchTextInGoogle() {
        driver.get("https://www.google.by/");
        driver.manage().window().setSize(new Dimension(945, 1020));
        driver.findElement(By.id("APjFqb")).click();
        {
            WebElement element = driver.findElement(By.cssSelector("center:nth-child(1) > .gNO89b"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.id("APjFqb")).sendKeys("-DskipTests=tru");
        driver.findElement(By.cssSelector("center:nth-child(1) > .gNO89b")).click();
        driver.findElement(By.cssSelector("p:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector("p:nth-child(1)")).getText(), is("По запросу -DskipTests=tru ничего не найдено. "));
    }


}
