package awesomecucumber.stepdef;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartStepDefinitions {
    //private final WebDriver driver;
    private final CartPage cartPage;

    public CartStepDefinitions(TestContext context){
        //driver= context.driver;
        cartPage= PageFactoryManager.getCartPage(context.driver);
    }

    @Then("I should see {int} {product} inn the cart")
    public void ıShouldSeeInnTheCart(int quantity, Product product) {
        //CartPage cartPage=new CartPage(driver);
        Assert.assertEquals(product.getName(),cartPage.getProductName());
        Assert.assertEquals(quantity,cartPage.getProductQuantity());
    }
}
