package lecture_10.practice;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;

public class Lecture10 extends BaseTest {

    @Test
    public void test(){
        System.out.println("Hello i'm test1");
    }

    @Test
    public void test2(){
        System.out.println("Hello i'm test2 ::" + System.getProperty("help"));
    }

    @Test
    public void test3(){
        System.out.println("Hello i'm test3 ::" + System.getProperty("lecture"));
    }



}
