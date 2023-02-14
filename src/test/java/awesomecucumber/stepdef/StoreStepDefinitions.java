package awesomecucumber.stepdef;

import awesomecucumber.apis.CartApi;
import awesomecucumber.constants.Endpoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.PageFactoryManager;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class StoreStepDefinitions {
    //private final WebDriver driver;
    private final StorePage storePage;
    private final TestContext context;

    public StoreStepDefinitions(TestContext context){
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I'm on the Store Page")
    @Step
    public void ıMOnTheStorePage() {
        storePage.load(Endpoint.STORE.url);
    }

    @When("I add a {product} too the cart")
    @Step
    public void ıAddATooTheCart(Product product) {
        storePage.addToCart(product.getName());
    }

    @And("i have a porduct in the cart")
    @Step
    public void iHaveAPorductInTheCart() {
        //storePage.addToCart("Blue Shoes");
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215,1);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver );
    }
}
