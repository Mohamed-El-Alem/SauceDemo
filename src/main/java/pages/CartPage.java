package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private By buttonCheckout = By.linkText("CHECKOUT");

    WebDriver webDriver;

    CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static CartPage setWebDriver(WebDriver webDriver) {
        return new CartPage(webDriver);
    }

    public CartPage clickCheckout() {
        webDriver.findElement(buttonCheckout).click();
        return this;
    }

}
