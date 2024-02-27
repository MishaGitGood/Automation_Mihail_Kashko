package lecture12.homeWork;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPITest extends BaseTest {

    @Test
    public void streamApiTest(){
        List<Integer> item = Arrays.asList(-79, 99, -83, -75, -78, -22, -57, 84, 11, 15);
        List<Integer> result = item.stream().map(el ->Math.abs(el)).sorted().collect(Collectors.toList());
        System.out.println(result);
    }

}
