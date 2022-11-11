package com.A101.step_definitions;

import com.A101.pages.AddressPage;
import com.A101.pages.CartPage;
import com.A101.pages.HomePage;
import com.A101.pages.ProductPage;
import com.A101.utilities.BrowserUtils;
import com.A101.utilities.ConfigurationReader;
import com.A101.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.Utilities;
import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class A101TestStepDefinition {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    AddressPage addressPage = new AddressPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    String selectedProductText;


    @Given("user is on the a101 webpage and accept cookies")
    public void user_is_on_the_a101_webpage_and_accept_cookies() {
        Driver.getDriver().get(ConfigurationReader.getProperty("A101.url"));
        homePage.cookies.click();
    }

    @When("user search {string} product at the search box")
    public void user_search_sock_product_at_the_search_box(String string) {
        homePage.searchBox.sendKeys("çorap",ENTER);
        homePage.searchButton.click();
    }

    @When("user select {string} from catagories filters")
    public void user_select_Man_from_catagories_filters(String string) {
        productPage.selectGenderCheckBox("erkek").click();
    }


    @When("user select first product and assert it is for man")
    public void user_select_first_product_and_assert_it_is_for_man() {
        BrowserUtils.waitFor(5);
        productPage.selectProduct(1).click();
        selectedProductText = cartPage.selectedProduct.getText();
        Assert.assertTrue(selectedProductText.contains("Erkek"));
    }

    @When("user select size and add the product to cart")
    public void user_select_size_and_add_the_product_to_cart() {
        cartPage.productSizeFourtyFour.click();
        try {
            cartPage.addToCart.click();
        }catch (NoSuchElementException e){
            System.out.println("failed for adding to cart");
        }
    }

    @When("user view and confirm the cart")
    public void user_view_and_confirm_the_cart() {
        cartPage.viewCart.click();
        cartPage.confirmCart.click();

    }

    @When("user click continue without sign in button")
    public void user_click_continue_without_sign_in_button() {
        cartPage.continueBottun.click();
    }

    @When("user send mail address and click proceed button")
    public void user_send_mail_address_and_click_proceed_button() {
        cartPage.emailPlaceHolder.sendKeys("Akbas_Mesut@outlook.com", ENTER);
    }

    @When("user click make a new address button")
    public void user_click_make_a_new_address_button() {
        addressPage.makeNewAddressButton.click();
    }

    @When("user fill out address update page")
    public void user_fill_out_address_update_page() {

        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(addressPage.addressTitle)
                .sendKeys(faker.name().title())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .pause(3)
                .sendKeys(Keys.TAB)
                .sendKeys("ANKARA")
                .perform();
        Select township = new Select(addressPage.township);
        township.selectByIndex(2);
        BrowserUtils.waitFor(2);
        Select district = new Select(addressPage.district);
        district.selectByIndex(2);
        actions.click(addressPage.addressBox)
                .sendKeys(faker.address().fullAddress()).perform();
        addressPage.saveButton.click();
    }

    @When("user click {string} button")
    public void user_click_button(String string) {

        String actualProductDescription = addressPage.productDescription.getText();
        Assert.assertEquals(actualProductDescription,selectedProductText);

        addressPage.submitButton.click();
    }

    @Then("user should see payment screen opened")
    public void user_should_see_payment_screen_opened() {

    }

}
