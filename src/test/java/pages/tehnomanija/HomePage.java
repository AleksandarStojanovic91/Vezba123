package pages.tehnomanija;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class HomePage extends BasePage {

    WebDriver driver;
    WebDriverWait wdWait;

    public HomePage(WebDriver driver, WebDriverWait wdWait) {
        super(driver,wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    String menu = "//a[@class='first-level-link' and contains(@href,'$')]";
    String subMenu = "[title='$']";
    String filter = "//div[contains(text(),'#')]/..//*[contains(text(),'$')]/../input";

    /**
     *
     * @param menuText Href text matching
     * @param subMenuText Title text matching
     */
    public void clickSubMenuItem(String menuText, String subMenuText){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(".category-menu"))).moveToElement(driver.findElement(By.xpath(menu.replace("$", menuText)))).build().perform();
        driver.findElement(By.cssSelector(subMenu.replace("$", subMenuText))).click();
    }

    public void clickFilter(String filterName, String filterValue) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath(filter.replace("#", filterName).replace("$", filterValue))).click();
    }

}