package tests.ct;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ct.AccountCreatePage;
import pages.ct.HomePage;
import tests.BaseTest;

import java.io.IOException;

public class CTShopTest extends BaseTest {

    String URL = "https://www.ctshop.rs/";

    @BeforeMethod
    public void setUp(){
        init("Chrome","95",30);
        driver.get(URL);
    }

    @Test
    public void regsiterUser() throws IOException {
        wdWait = new WebDriverWait(driver, 30);

        HomePage homePage = new HomePage(driver,wdWait);
        homePage.otvoriNalog();

        takeScreenshot("PosleKlikaNaOtvoriNalog");

        AccountCreatePage accountCreatePage = new AccountCreatePage(driver, wdWait);
        accountCreatePage.registerUser("Marko", "Markovic", "email@email.com", "Ne","TestPass123");
    }

    @AfterMethod
    public void tearDown() throws IOException {
        takeScreenshot("ScreenshotOnTestEnd");
        quitDriver();
    }

}
