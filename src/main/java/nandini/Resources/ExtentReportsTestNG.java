package nandini.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTestNG {
    
    
    public static ExtentReports getReportObject()
    {
        String path= System.getProperty("user.dir")+"//report//index.html";
        ExtentSparkReporter reporter= new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        
        ExtentReports extent= new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Nandini Saha");
       // extent.createTest(path);
       return extent;
    }
}
