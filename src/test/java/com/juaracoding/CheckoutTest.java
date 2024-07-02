package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.HomePage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constant;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutTest {

    private ExtentTest extentTest;
    private WebDriver driver;
    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();

    public CheckoutTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("I logged in to the application")
    public void i_logged_in_to_the_application(){
        loginPage.login("standard_user", "secret_sauce");
        extentTest.log(LogStatus.PASS,"I logged in to the application");
    }

    @When("I add new product to the cart")
    public void i_add_new_product_to_the_cart(){
        homePage.clickAddButton();
        homePage.clickCartButton();
        extentTest.log(LogStatus.PASS,"I add new product to the cart");
    }

    @And("I proceed to checkout")
    public void i_proceed_to_checkout(){
        cartPage.clickCheckoutButton();
        extentTest.log(LogStatus.PASS,"I proceed to checkout");
    }


    @And("I provide valid checkout information")
    public void i_provide_valid_checkout_information(){
        checkoutPage.isiDataCheckout("farhan", "hilman", "30163");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");
        checkoutPage.clickContinueButton();
        extentTest.log(LogStatus.PASS,"I provide valid checkout information");
    }

    @And("I finish the checkout process")
    public void i_finish_the_checkout_process(){
        checkoutPage.clickFinishButton();
        extentTest.log(LogStatus.PASS,"I finish the checkout process");
    }

    @Then("I should see the order confirmation page")
    public void i_should_see_the_order_confirmation_page(){
        Assert.assertEquals(checkoutPage.getTxtCheckoutComplete(),"Checkout: Complete!");
        extentTest.log(LogStatus.PASS,"I should see the order confirmation page");
    }

}
