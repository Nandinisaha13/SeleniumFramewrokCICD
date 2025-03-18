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
import nandini.TestComponents.Retry;
import nandini.pageobjects.CartPage;
import nandini.pageobjects.ConfirmationPage;
import nandini.pageobjects.LandingPage;
import nandini.pageobjects.ProductCatalogue;
import nandini.pageobjects.checkoutPage;



public class ErrorValidation extends BaseTest {

    @Test(groups={"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void LoginErrorValidation() throws IOException, InterruptedException
    {
        
        
        String productName= "ZARA COAT 3";
        
        landingPage.loginApplication("nandini@example.com","Pa1eessw@ord1");
        Assert.assertEquals("Incorrect email o password.", landingPage.errorMessage());

    }

     @Test
     public void ProductErrorValidation() throws InterruptedException
     {

        String productName= "ZARA COAT 3";
     
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
    }
     

}
