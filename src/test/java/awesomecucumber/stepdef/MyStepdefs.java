package awesomecucumber.stepdef;

import awesomecucumber.constants.Endpoint;
import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.factory.DriverFactory;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyStepdefs {
    private WebDriver driver;
    private BillingDetails billingDetails;

    public MyStepdefs(TestContext context){
        //System.out.println("step def : di : scenario name: " + context.scenarioName);
        driver= context.driver;
    }
}