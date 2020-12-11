package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CheckoutStepTwoPage {

    private By finishBtn = By.linkText("FINISH");
    WebDriver webDriver;

    CheckoutStepTwoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static CheckoutStepTwoPage setWebDriver(WebDriver webDriver) {
        return new CheckoutStepTwoPage(webDriver);
    }

    public Boolean verifyProductsAreCorrect(String products[]) {

        List<WebElement> findProduct = webDriver.findElements(By.className("inventory_item_name"));
        int productCheker = 0;

        for (WebElement product : findProduct) {
            for (String item : products) {
                if (item.equalsIgnoreCase(product.getText()))
                    productCheker++;
            }
            if (productCheker != 2)
                return false;
        }

        return true;
    }

    public void ClickOnFinish() {
        webDriver.findElement(finishBtn).click();
    }
}
