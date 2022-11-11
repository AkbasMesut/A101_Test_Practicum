package com.A101.pages;

import com.A101.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//h1[@class='product-name js-name']")
    public WebElement selectedProduct;

    @FindBy(xpath = "//a[@title='36-40']")
    public WebElement productSizeFourty;

    @FindBy(xpath = "//a[@title='40-44']")
    public WebElement productSizeFourtyFour;

    @FindBy(xpath = "//button[@data-pk='22252']")
    public WebElement addToCart;

    @FindBy(xpath = "//a[@class='go-to-shop']")
    public WebElement viewCart;

    @FindBy(xpath = "(//a[@title='Sepeti Onayla'])[2]")
    public WebElement confirmCart;

    @FindBy(xpath = "//a[@title='ÜYE OLMADAN DEVAM ET']")
    public WebElement continueBottun;

    @FindBy(xpath = "//input[@name='user_email']")
    public WebElement emailPlaceHolder;


/*
    public boolean productAssertion(String name){
        boolean product = false;
        String productName = Driver.getDriver().findElement(By.xpath("//h1[@class='product-name js-name']")).getText();

        if (productName.equalsIgnoreCase(name) ) {
            product = true;
        }
        return true;
    }

*/

}
