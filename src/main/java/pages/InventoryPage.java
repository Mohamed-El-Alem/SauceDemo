package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    private By selectProductSort = By.className("product_sort_container");
    private By linkFirstProduct = By.xpath("//a[@id='item_2_title_link']/div");
    private By imageFirstProduct = By.xpath("//div[@id='inventory_container']/div/div/div[3]/button");
    private By cartProduct = By.cssSelector("path");


    private static String[] ProductList = {"Sauce Labs Backpack", "Sauce Labs Onesie"};

    public static String[] getProductList() {
        return ProductList;
    }

    public static WebDriver webDriver;

    public InventoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static InventoryPage setWebDriver(WebDriver webDriver) {
        return new InventoryPage(webDriver);
    }

    public InventoryPage filterItem() {
        webDriver.findElement(selectProductSort).click();
        return this;
    }

    public InventoryPage byPriceLowToHigh() {
        new Select(webDriver.findElement(selectProductSort)).selectByValue("lohi");
        return this;
    }

    public InventoryPage selectFirstItem() {
        webDriver.findElement(linkFirstProduct).click();
        return this;
    }

    public InventoryPage addFirstItemToShoppingCart() {
        webDriver.findElement(imageFirstProduct).click();

        return this;
    }

    public InventoryPage ProceedToShoppingCartPage() {
        webDriver.findElement(cartProduct).click();
        return this;
    }
}
