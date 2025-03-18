package nandini.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nandini.AbstractComponents.AbstractComponents;

public class checkoutPage extends AbstractComponents {
    WebDriver driver;

    public checkoutPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/section/button[2]")
    WebElement selectCountry;

    @FindBy(css=".action__submit")
    WebElement Submit;

    @FindBy(xpath ="//input[@placeholder='Select Country']")
    WebElement country;

    public void selectCountry(String countryName)
    {
        Actions ab= new Actions(driver);
        ab.sendKeys(country,countryName).build().perform();
      
        selectCountry.click();
    
    }
    public ConfirmationPage submitOrder()
    {
        Submit.click();
        return new ConfirmationPage(driver);
    }



}
