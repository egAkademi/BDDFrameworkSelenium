package awesomecucumber.stepdef;

import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.pages.PageFactoryManager;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CustomerStepDefinitions {
    //private final WebDriver driver;
    private final TestContext context;
    private final StorePage storePage;

    public CustomerStepDefinitions(TestContext context){
        //driver= context.driver;
        this.context=context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @And("my billing details aree")
    public void myBillingDetailsAree(BillingDetails billingDetails) {
        context.billingDetails=billingDetails;
    }

    @Given("im a quest customer")
    public void imAQuestCustomer() {
        //driver= DriverFactory.getDriver();
        //new StorePage(driver).load(MyConstants.STORE);
        storePage.load(MyConstants.STORE);
    }

}
