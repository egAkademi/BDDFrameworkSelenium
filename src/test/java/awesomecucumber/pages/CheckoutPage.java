package awesomecucumber.pages;

import awesomecucumber.domainobjects.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{

    @FindBy(id = "billing_first_name") private WebElement billingfirstname;
    @FindBy(id = "billing_last_name") private WebElement billinglastname;
    @FindBy(id = "billing_address_1") private WebElement billingadressone;
    @FindBy(id = "billing_city") private WebElement billingcity;
    @FindBy(id = "billing_state") private WebElement billingstatedropdown;
    @FindBy(id = "select2-billing_state-container") private WebElement alternateBillingStateDropDown;
    @FindBy(id = "billing_postcode") private WebElement billingzip;
    @FindBy(id = "billing_email") private WebElement billingemail;
    @FindBy(id = "place_order") private WebElement placeOrderbtn;
    @FindBy(css = ".woocommerce-notice") private WebElement noticeTxt;

    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingfirstName(String firstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingfirstname));
        e.clear();
        e.sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterBillinglastName(String lastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billinglastname));
        e.clear();
        e.sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterBillingAddressLineOne(String addressLineOne){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingadressone));
        e.clear();
        e.sendKeys(addressLineOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String city){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingcity));
        e.clear();
        e.sendKeys(city);
        return this;
    }

    public CheckoutPage enterBillingState(String stateName){
        wait.until(ExpectedConditions.elementToBeClickable(alternateBillingStateDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='" + stateName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();

/*        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown)));
        select.selectByVisibleText(billingStateName);*/
        return this;
    }

    public CheckoutPage enterBillingZip(String zip){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingzip));
        e.clear();
        e.sendKeys(zip);
        return this;
    }

    public CheckoutPage enterBillingEmail(String email){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingemail));
        e.clear();
        e.sendKeys(email);
        return this;
    }

    public CheckoutPage setBillingDetails(BillingDetails billingDetails){
        return enterBillingfirstName(billingDetails.getBillingFirstName()).
               enterBillinglastName(billingDetails.getBillingLastName()).
               enterBillingAddressLineOne(billingDetails.getBillingAddressOne()).
               enterBillingCity(billingDetails.getBillingCity()).
               enterBillingState(billingDetails.getBillingStateName()).
               enterBillingZip(billingDetails.getBillingZip()).
               enterBillingEmail(billingDetails.getBillingEmail());
    }

    public CheckoutPage placeOrder(){
        waitForOverlaysToDisappear(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderbtn)).click();
        return this;
    }

    public String getNotice(){
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }
}
