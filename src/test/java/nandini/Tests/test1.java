package nandini.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import nandini.TestComponents.BaseTest;
import nandini.pageobjects.CartPage;
import nandini.pageobjects.ConfirmationPage;
import nandini.pageobjects.LandingPage;
import nandini.pageobjects.ProductCatalogue;
import nandini.pageobjects.checkoutPage;

public class test1 extends BaseTest {

   
    public static void main(String args[]) throws InterruptedException
    {
        
        
        String productName= "ZARA COAT 3";
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        LandingPage landingPage= new LandingPage(driver);
        landingPage.goTo();

        ProductCatalogue productCatalogue=landingPage.loginApplication("nandini@example.com","Passw@ord1");

        
        List<WebElement> products= productCatalogue.getProductList();
        
        productCatalogue.addProductToCart(productName);
       
        CartPage cartPage=productCatalogue.goToCartPage();


        
        Boolean match= cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
       
        checkoutPage checkoutPage=cartPage.goToCheckout();
        

        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage= checkoutPage.submitOrder();
        String message= confirmationPage.SuccessMessage();
        
    
        Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();

    }

}
