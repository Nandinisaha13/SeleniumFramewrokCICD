package nandini.pageobjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import nandini.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='cartSection']/h3")
    List<WebElement> cartProducts;

    @FindBy(css=".subtotal li button")
    WebElement checkoutEle;
    
    public Boolean VerifyProductDisplay(String productName)
    {   
        
        Boolean match= cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
        return match;
    }

    public checkoutPage goToCheckout()
    {
        checkoutEle.click();
        return new checkoutPage(driver);
    }


    
    
}
