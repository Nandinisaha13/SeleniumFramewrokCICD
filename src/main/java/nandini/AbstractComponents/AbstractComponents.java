package nandini.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nandini.pageobjects.CartPage;
import nandini.pageobjects.OrderPage;

public class AbstractComponents {
    WebDriver driver;

    



    public AbstractComponents(WebDriver driver) {
        
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//app-sidebar/nav/ul/li[4]/button")
    WebElement cartHeader;

    @FindBy(css="[routerlink*='myorders']")
    WebElement orderHeader;

    public OrderPage goToOrdersPage()
    {   
        orderHeader.click();
        OrderPage orderPage= new OrderPage(driver);
        return orderPage;

    }

    public void waitforelementtoAppear(By FindBy)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));

    }
    public void waitforthevisibility(WebElement ele)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    public void waitElementtoDisappear(WebElement ele) throws InterruptedException
    {

        //4 seconds taken by application to control traffic
        Thread.sleep(2000);
        // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.invisibilityOf(ele));	

    }
    public CartPage goToCartPage()
    {
        cartHeader.click();
        CartPage cartPage= new CartPage(driver);
        return cartPage;
    }
   
}
