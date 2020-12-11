package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage {
    private By inputFirstname = By.id("first-name");
    private By inputLastname = By.id("last-name");
    private By inputPostalcode = By.id("postal-code");
    private By buttonContinue = By.xpath("//input[@value='CONTINUE']");

    WebDriver webDriver;

    CheckoutStepOnePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static CheckoutStepOnePage setWebDriver(WebDriver webDriver) {
        return new CheckoutStepOnePage(webDriver);
    }

    public CheckoutStepOnePage enterFistName(String firstname) {
        webDriver.findElement(inputFirstname).sendKeys(firstname);
        return this;
    }

    public CheckoutStepOnePage enterLastName(String lastname) {
        webDriver.findElement(inputLastname).sendKeys(lastname);
        return this;
    }

    public CheckoutStepOnePage enterPostalCode(String postalcode) {
        webDriver.findElement(inputPostalcode).sendKeys(postalcode);
        return this;
    }

    public CheckoutStepOnePage clickContinueButton() {
        webDriver.findElement(buttonContinue).click();
        return this;
    }
}
