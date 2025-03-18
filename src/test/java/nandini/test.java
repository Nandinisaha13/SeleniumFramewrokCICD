package nandini;

import java.util.Arrays;

import org.testng.TestNG;

public class test 
{

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        //testng.setTestSuites(Arrays.asList("testsSuite/nandini.xml")); 
       // testng.setTestSuites(Arrays.asList("testsSuite/ErrorHandling.xml"));
       // testng.setTestSuites(Arrays.asList("testsSuite/Purchase.xml"));
       testng.setTestSuites(Arrays.asList("testsSuite/hello.xml"));
        testng.run();
        
    }
  


  
       
    
}


    




