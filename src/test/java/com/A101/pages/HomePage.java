package com.A101.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    public WebElement cookies;

    @FindBy(xpath = "//div[@class='hype-link hype-dropdown hype-categories-link']")
    public WebElement categories;

    @FindBy(name = "search_text")
    public WebElement searchBox;

    @FindBy(xpath = "(//em[@class='input-icon icon-search'])[2]")
    public WebElement searchButton;

    @FindBy(xpath = "(//figure[@class='product-image '])[1]")
    public WebElement ilkÜrün;

    @FindBy(xpath = "//div[@class='selected-variant-text']/span")
    public WebElement secilenRenk;

    @FindBy(xpath = "//i[@class='icon-sepetekle']")
    public WebElement sepeteEkle;

}
