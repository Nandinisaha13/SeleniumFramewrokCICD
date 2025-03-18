package nandini.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nandini.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver)
    {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(css=".ng-animating")
    WebElement spinner;


    

    By productsBy= By.cssSelector(".mb-3");
    By addCart= By.cssSelector(".card-body button:last-of-type");
    By toast= By.id("toast-container");

    public List<WebElement> getProductList()
    {   
        waitforelementtoAppear(productsBy);
        return products;
    }
    public WebElement getProductByName(String productName)
    {
        WebElement prod=getProductList().stream()
        .filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName))
        .findFirst().orElse(null);
        return prod;

    }
    public void addProductToCart(String prodName) throws InterruptedException
    {
       WebElement prod= getProductByName(prodName);
       prod.findElement(addCart).click(); 
       waitforelementtoAppear(toast);
       waitforthevisibility(spinner);
       waitElementtoDisappear(spinner);

    }


    
    
    
}
