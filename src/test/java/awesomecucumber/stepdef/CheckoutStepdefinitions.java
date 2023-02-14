package awesomecucumber.stepdef;

import awesomecucumber.constants.Endpoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutStepdefinitions {
    //private final WebDriver driver;
    private final TestContext context;
    private final CheckoutPage checkoutPage;

    public CheckoutStepdefinitions(TestContext context){
        this.context=context;
        //driver= context.driver;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @When("i provide biling details")
    public void iProvideBilingDetails() {
        //CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("i place an order")
    public void iPlaceAnOrder() {
        //new CheckoutPage(driver).placeOrder();
        checkoutPage.placeOrder();
    }////

    @Then("the order should be placed successfuly")
    public void theOrderShouldBePlacedSuccessfuly() {
        Assert.assertEquals("Thank you. Your order has been received.",checkoutPage.getNotice());
    }

    @And("im on the checkout page")
    public void imOnTheCheckoutPage() {
        checkoutPage.load(Endpoint.CHECKOUT.url) ;
    }//
}
