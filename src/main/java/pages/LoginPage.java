package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    By username = By.name("user-name");
    By password = By.name("password");
    By loginBtn = By.xpath("//input[@type='submit']");
    private static By logginErrorMessge = By.xpath("//*[contains(text(),'Epic sadface')]");
    private static WebDriver webDriver;

    LoginPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public LoginPage login(String un, String pwd) {
        webDriver.findElement(username).sendKeys(un);
        webDriver.findElement(password).sendKeys(pwd);
        webDriver.findElement(loginBtn).click();
        return this;
    }

    public static Boolean hasLoginFailed() {
        WebElement loginError = webDriver.findElement(logginErrorMessge);
        return loginError.isDisplayed();
    }


    public static LoginPage setWebDriver(WebDriver driver) {
        return new LoginPage(driver);
    }
}
