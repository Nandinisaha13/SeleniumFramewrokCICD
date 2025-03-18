package nandini.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import nandini.Resources.ExtentReportsTestNG;

public class Listeners extends BaseTest implements ITestListener {

    ExtentTest test;
    ExtentReports extent= ExtentReportsTestNG.getReportObject();
    //test, test
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    @Override
    public void onTestStart(ITestResult result)
    {
        
        test=extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test); //unique thread id(Error Validation)-> test
        
    }
    @Override
    public void onTestSuccess(ITestResult result)
    {
        extentTest.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure (ITestResult result)
    {
        
        extentTest.get().fail(result.getThrowable());

        try {
            driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            
            e1.printStackTrace();
        } 

        //take screenshot
    String filePath =null;
    try {
        filePath = getScreenshot(result.getMethod().getMethodName(),driver);
    } catch (IOException e) {
        
        e.printStackTrace();
    }

        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext result)
    {
        extent.flush();
    }
    
}
