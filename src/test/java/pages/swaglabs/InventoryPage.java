package pages.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class InventoryPage extends BasePage {

    WebDriver driver;
    WebDriverWait wdWait;

    public InventoryPage(WebDriver driver, WebDriverWait wdWait) {
        super(driver,wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    String addToCartButton = "//*[@class='inventory_list']/div[$]//button";
    String addToCartButtonByProductName = "//div[text()='$']/../../..//button";
    String addToCartButtonByPartialDescText = "//div[contains(text(),'$')]/../..//button";

    @FindBy(css = ".shopping_cart_link")
    WebElement cartIconLink;

    public void clickAddToCart(String i){
        click(driver.findElement(By.xpath(addToCartButton.replace("$", i))));
    }

    public void clickAddToCartByProductName(String name){
        click(driver.findElement(By.xpath(addToCartButtonByProductName.replace("$", name))));
    }

    public void clickAddToCartByPartialDescText(String desc){
        click(driver.findElement(By.xpath(addToCartButtonByPartialDescText.replace("$", desc))));
    }

    public void clickCart(){
        click(cartIconLink);
    }





}