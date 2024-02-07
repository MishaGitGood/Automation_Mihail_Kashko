package testngUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int counter = 1;
    public static final int MAX_RETRY = 5;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()){
            if (counter < MAX_RETRY){
                counter++;
                iTestResult.setStatus(iTestResult.FAILURE);
                System.out.println("I'm try again :: " + counter);
                return true;
            }else {
                iTestResult.setStatus(iTestResult.FAILURE);
            }
        }else {
            iTestResult.setStatus(iTestResult.SUCCESS);
        }
        return false;
    }
}
