package nandini.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nandini.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css="tr td:nth-child(3)")
    List<WebElement> productNames;

    @FindBy(css=".subtotal li button")
    WebElement checkoutEle;

    public Boolean VerifyProductDisplay(String productName)
    {   
        
        Boolean match= productNames.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
        return match;
    }

}
