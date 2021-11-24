package tests.swaglabs;

import excel_core.ExcelUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.swaglabs.*;
import tests.BaseTest;

import java.io.IOException;
import java.util.Map;

public class SwagLabsTest extends BaseTest {

    String URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setUp(){
        init("Chrome","95",30);
        driver.get(URL);
    }

    @Test
    public void login() throws IOException {
        Map<String,String> data = new ExcelUtils().getRowData("src/test/testData/TestData.xlsx","Data", 1);

        WebDriverWait wdWait = new WebDriverWait(driver, 30);

        LoginPage loginPage = new LoginPage(driver,wdWait);
        loginPage.enterUsername(data.get("Username"));

        loginPage.enterPassword(data.get("Password"));

        loginPage.clickLogin();

        reportScreenshot("Test", "TestAllure");

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(driver.getTitle(),"Swag Labs" );
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "PRODUCTS");
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getAttribute("class"),"title");
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getCssValue("text-transform"),"uppercase");
    }

    @Test
    public void buyProduct(){
        WebDriverWait wdWait = new WebDriverWait(driver, 30);

        LoginPage loginPage = new LoginPage(driver, wdWait);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver, wdWait);
        inventoryPage.clickAddToCart("3");
        inventoryPage.clickAddToCart("4");
        inventoryPage.clickAddToCartByProductName("Sauce Labs Backpack");
        inventoryPage.clickAddToCartByPartialDescText("AAA");
        inventoryPage.clickCart();

        CartPage cartPage = new CartPage(driver, wdWait);
        cartPage.clickCheckoutButton();

        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver, wdWait);
        checkoutStepOnePage.fillCheckoutStepInformation("Marko", "Stojanovic", "11000");
        checkoutStepOnePage.clickContinue();

        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver, wdWait);
        checkoutStepTwoPage.clickFinish();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver, wdWait);

        Assert.assertEquals(checkoutCompletePage.getTitle(), "THANK YOU FOR YOUR ORDER");

    }

    @AfterMethod
    public void tearDown() throws IOException {
        takeScreenshot("EndTestScreenshot");
        quitDriver();
    }

}