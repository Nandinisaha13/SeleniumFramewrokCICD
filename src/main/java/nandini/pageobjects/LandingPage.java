package nandini.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nandini.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }



   // WebElement userEmail=driver.findElement(By.id("userEmail"));
    //pagefactory
    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement password;

    @FindBy(id="login")
    WebElement submit;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;
    
    public ProductCatalogue loginApplication( String email, String passwordUser)
    {
        userEmail.sendKeys(email);
        password.sendKeys(passwordUser);
        submit.click();
        ProductCatalogue productCatalogue= new ProductCatalogue(driver);
        return productCatalogue;
    }
    public String errorMessage()
    {
        waitforthevisibility(errorMessage);
        return errorMessage.getText();
        
    }
    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }
    
    
}
