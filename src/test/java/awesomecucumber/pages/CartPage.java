package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    @FindBy(css = "td[class='product-name'] a") private WebElement productName;
    @FindBy(css = "input[type='number']") private WebElement productQuantitiy;
    @FindBy(css = ".checkout-button.button.alt.wc-forward") private WebElement proceedtochckoutbtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
    }

    public int getProductQuantity(){
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQuantitiy)).getAttribute("value"));
    }

    public void checkout(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedtochckoutbtn)).click();
    }
}
