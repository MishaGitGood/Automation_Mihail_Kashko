package lecture_4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static sun.nio.cs.Surrogate.is;

public class SearchHelloWorld {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @Test
    public void myFirstTest() {
        driver.get("https://www.google.by/");
        driver.findElement(By.id("APjFqb")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("Привет, мир");
        driver.findElement(By.cssSelector("center:nth-child(1) > .gNO89b")).click();
        driver.findElement(By.cssSelector(".ULSxyf:nth-child(1) .LC20lb:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".mw-page-title-main")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".mw-page-title-main"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        driver.findElement(By.cssSelector(".mw-page-title-main")).click();
        assertThat(driver.findElement(By.cssSelector(".mw-page-title-main")).getText(), is("Hello, world!"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
