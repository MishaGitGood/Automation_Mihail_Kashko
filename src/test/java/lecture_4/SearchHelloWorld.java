package lecture_4;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class  SearchHelloWorld {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeTest
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
        driver.findElement(By.name("btnK")).click();
        driver.findElement(By.cssSelector(".ULSxyf:nth-child(1) .LC20lb:nth-child(2)")).click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}