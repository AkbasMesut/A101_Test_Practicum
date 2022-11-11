package com.A101.pages;

import com.A101.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    // return check box which is selected from gender
    public WebElement selectGenderCheckBox(String gender) {
        int num = 0;
        if (gender.equalsIgnoreCase("kadın")) {
            num = 1;
        } else if (gender.equalsIgnoreCase("unisex")) {
            num = 2;
        } else if (gender.equalsIgnoreCase("çocuk")) {
            num = 3;
        } else if (gender.equalsIgnoreCase("erkek")) {
            num = 4;
        }
        WebElement genderBox = Driver.getDriver().findElement(By.xpath("((//ul[@class='brands'])[2]/li[" + num + "])"));
        return genderBox;
    }

    // return webelement according to index number
    public WebElement selectProduct(int num) {
        WebElement product = Driver.getDriver().findElement(By.xpath("(//div[@class='product-actions'])[" + num + "]"));

        return product;
    }


}
