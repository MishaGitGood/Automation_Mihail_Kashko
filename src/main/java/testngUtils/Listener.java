package testngUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import propertyUtils.PropertyReader;
import static propertyUtils.PropertyReader.*;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        if(System.getProperties().containsKey("config")){
            setUpProperty(System.getProperty("config"));
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Hello i'm finished with :: " + context.getSuite().getName());
    }


}
