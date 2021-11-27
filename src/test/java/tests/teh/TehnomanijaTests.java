package tests.teh;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ct.AccountCreatePage;
import pages.tehnomanija.HomePage;
import tests.BaseTest;

import java.io.IOException;

public class TehnomanijaTests extends BaseTest {

    @BeforeMethod
    public void setUp(){
        init("Chrome","95",30);
    }

    @Test
    public void navigateMenu() throws InterruptedException {
        driver.get("https://www.tehnomanija.rs/");
        wdWait = new WebDriverWait(driver, 30);

        HomePage homePage = new HomePage(driver, wdWait);
        homePage.clickSubMenuItem("tv-i-video", "do 32 inča");

        homePage.clickFilter("Aktuelna ponuda", "Ponuda za crni petak");

        homePage.scrollToWebElement(driver.findElements(By.cssSelector(".fa.fa-facebook")).get(1));
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager");
        wdWait = new WebDriverWait(driver, 30);

        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame.lazyloaded")));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(
                driver.findElement(By.xpath("//ul[@id='gallery']/li[3]")),
                driver.findElement(By.cssSelector("#trash"))).build().perform();

        actions.clickAndHold(driver.findElement(By.xpath("//ul[@id='gallery']/li[3]")))
                .moveToElement(driver.findElement(By.cssSelector("#trash")))
                .release(driver.findElement(By.cssSelector("#trash")))
                .build()
                .perform();

        Thread.sleep(5000);

    }

    @AfterMethod
    public void tearDown() throws IOException {
        //takeScreenshot("ScreenshotOnTestEnd");
        //quitDriver();
    }

}
