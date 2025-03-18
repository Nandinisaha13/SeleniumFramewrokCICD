package nandini.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nandini.TestComponents.BaseTest;
import nandini.pageobjects.CartPage;
import nandini.pageobjects.ConfirmationPage;
import nandini.pageobjects.LandingPage;
import nandini.pageobjects.ProductCatalogue;
import nandini.pageobjects.checkoutPage;

public class stepDefinitionImpl extends BaseTest{

    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce website")
    public void I_landed_on_Ecommerce_website() throws IOException
    {
        landingPage= launchApp();
        //code

    }
    @Given ("^Logged in with username (.+) and password (.+)$") // ^ & $ is used so that it expresses regex
    public void logged_in_username_and_password(String username, String password)
    {
        productCatalogue= landingPage.loginApplication(username, password);
    }
    @When("^I add the product (.+) to cart$")
    public void i_add_the_product_to_cart(String productName) throws InterruptedException
    {
        List<WebElement> products= productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
    }
    @When("^Checkout (.+) and submit the order$")
    public void checkout_and_submit_the_order(String productName)
    {
        CartPage cartPage= productCatalogue.goToCartPage();
        Boolean match= cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
       checkoutPage checkoutPage= cartPage.goToCheckout();
       checkoutPage.selectCountry("india");
        confirmationPage= checkoutPage.submitOrder();
    }
    @Then("{string} is displayed on ConfirmationPage")
    public void message_is_displayed_on_confirmationpage(String string)
    {
        String confirmMessage= confirmationPage.SuccessMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
        driver.close();

    }
    @Then("{string} message is displayed")
    public void message_is_displayed(String string)
    {
        Assert.assertEquals(string, landingPage.errorMessage());
        driver.close();
    }
}
