package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryItemPage {

    private By addToCartBtn = By.xpath("//div[@id='inventory_item_container']/div/div/div/button");
    private By inventoryPageBackBtn = By.xpath("//div[@id='inventory_item_container']/div/button");
    WebDriver webDriver;

    InventoryItemPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static InventoryItemPage setWebDriver(WebDriver webDriver) {
        return new InventoryItemPage(webDriver);
    }

    public InventoryItemPage addToCart() {
        webDriver.findElement(addToCartBtn).click();
        return this;
    }

    public InventoryItemPage backToInventoryPage() {
        webDriver.findElement(inventoryPageBackBtn).click();
        return this;
    }
}
