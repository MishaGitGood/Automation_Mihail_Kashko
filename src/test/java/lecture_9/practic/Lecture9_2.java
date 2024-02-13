package lecture_9.practic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Lecture9_2 {

    @BeforeClass
    public void beforeClass(){
        System.out.println("i'm before class from lecture9_2");
    }

    @Test
    public void test(){
        System.out.println("i'm test from lecture9_2!");
    }


}
