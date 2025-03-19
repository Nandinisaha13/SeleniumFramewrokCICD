package nandini.Tests;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.WebElement;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import nandini.TestComponents.BaseTest;
import nandini.pageobjects.CartPage;
import nandini.pageobjects.ConfirmationPage;
import nandini.pageobjects.OrderPage;
import nandini.pageobjects.ProductCatalogue;
import nandini.pageobjects.checkoutPage;

public class StandaloneTest extends BaseTest {
    //String productName= "ZARA COAT 3";
//hello
    @Test(dataProvider = "getData", groups={"Purchase"})
    public void SubmitOrder(HashMap<String, String> input ) throws IOException, InterruptedException
    {
        ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password"));

        
        List<WebElement> products= productCatalogue.getProductList();
        
        productCatalogue.addProductToCart(input.get("productName"));
       
        CartPage cartPage=productCatalogue.goToCartPage();
 
        Boolean match= cartPage.VerifyProductDisplay(input.get("productName"));
        Assert.assertTrue(match);
       
        checkoutPage checkoutPage=cartPage.goToCheckout();
        
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage= checkoutPage.submitOrder();
        String message= confirmationPage.SuccessMessage();
        
        Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    
    }
    @Test(dependsOnMethods = {"SubmitOrder"},dataProvider = "getData")
    public void OrderHistoryTest(HashMap<String, String> input)
    {
        //zaras coat 3 is in order history or not
        ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"),input.get("password"));
        OrderPage orderPage= productCatalogue.goToOrdersPage();
        Assert.assertTrue(orderPage.VerifyProductDisplay(input.get("productName")));
    }


    @DataProvider
    public Object[][] getData() throws IOException
    {
       List<HashMap<String, String>> data= getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//nandini//data/PurchaseOrder.json");

        
        // HashMap <String,String> map= new HashMap<String, String>();
        // map.put("email", "nandini@example.com");
        // map.put("password", "Passw@ord1");
        // map.put("productName", "ZARA COAT 3");
        // HashMap <String,String> map1= new HashMap<String, String>();
        // map1.put("email", "anshika@gmail.com");
        // map1.put("password", "Iamking@000");
        // map1.put("productName", "ADIDAS ORIGINAL");
         return new Object[][] {{data.get(0)},{data.get(1)}};
    }

}
