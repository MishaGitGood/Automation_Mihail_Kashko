package pageObjects.baseObjects;

import driver.DriverTypes;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testngUtils.ExtentReportsListener;
import testngUtils.InvokedListener;
import testngUtils.Listener;

import static driver.DriverCreation.createDriver;
import static driver.DriverCreation.quitDriver;
import static propertyUtils.PropertyReader.getProperties;
import static driver.DriverTypes.*;
@Listeners({Listener.class, InvokedListener.class})
public abstract class BaseTest {

    @BeforeTest
    protected void setUp() {
        createDriver(System.getProperties().containsKey("config")
                        ? valueOf(getProperties().getProperty("browser").toUpperCase())
                        : CHROME
                );
    }

    @AfterTest(alwaysRun = true)
    protected void tearDown() {
        quitDriver();
    }
}
