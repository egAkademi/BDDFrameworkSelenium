package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage{

    @FindBy(css = "a[title='View cart']") private WebElement viewCartLİnk;
    @FindBy(xpath = "//h1[normalize-space()='Store']") private WebElement titleTxt;
////

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName){
        By addToCartbtn = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");

        wait.until(ExpectedConditions.visibilityOf(titleTxt));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartbtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLİnk)).click();
    }
}
