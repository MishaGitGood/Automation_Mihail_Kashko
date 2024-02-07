package lecture_9.practic;

import org.testng.annotations.*;

public class Lecture9_1 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("i'm before suite!");
    }

    @BeforeTest(groups = {"smoke"})
    public void beforeTest(){
        System.out.println("i'm before test!");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("i'm before class from lecture9_1");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("i'm before method!");
    }

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void test1(){
        System.out.println("i'm test1 frome lecture9_1!");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("i'm test2!");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("i'm after method!");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("i'm after class!");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("i'm after test!");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("i'm after suite!");
    }

}
