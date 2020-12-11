package saucedemo.test.scenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestAllScenarios extends BaseTest {

    InventoryPage inventoryPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initialize();
    }

    @DataProvider(name = "LoginDataProvider")
    public Object[][] getData(){
        Object[][] data = {{"standard_user","secret_sauce"}, {"problem_user","secret_sauce"},{"locked_out_user","secret_sauce"}};
        return data;
    }

    @Test(dataProvider = "LoginDataProvider")
    public void successfulPathScenarioTest( String username, String password) throws Exception {

        System.out.println("User Tested Is: "+username);

        LoginPage
                .setWebDriver(BaseTest.driver)
                .login(username, password);

        inventoryPage = InventoryPage
                .setWebDriver(BaseTest.driver)
                .filterItem()
                .byPriceLowToHigh()
                .selectFirstItem();

        InventoryItemPage
                .setWebDriver(BaseTest.driver)
                .addToCart()
                .backToInventoryPage();

        inventoryPage
                .addFirstItemToShoppingCart()
                .ProceedToShoppingCartPage();

        CartPage.setWebDriver(BaseTest.driver)
                .clickCheckout();

        CheckoutStepOnePage.setWebDriver(BaseTest.driver)
                .enterFistName("Mohamed")
                .enterLastName("El Alem")
                .enterPostalCode("219MCS8088")
                .clickContinueButton();

        Boolean checkProducts = CheckoutStepTwoPage.setWebDriver(BaseTest.driver)
                .verifyProductsAreCorrect(InventoryPage.getProductList());

        if (username == "problem_user") {

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(checkProducts.equals(true),
                    "There should be two products");
            softAssert.assertAll();
        }

            CheckoutStepTwoPage.setWebDriver(BaseTest.driver).ClickOnFinish();
            CheckoutCompletePage.setWebDriver(BaseTest.driver)
                    .openMenu()
                    .clickOnLogOut();

    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

}
