package testngUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Hello i'm started with :: " + context.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Hello i'm finished with :: " + context.getSuite().getName());
    }


}
