package pages.swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class CheckoutCompletePage extends BasePage {

    WebDriver driver;
    WebDriverWait wdWait;

    public CheckoutCompletePage(WebDriver driver, WebDriverWait wdWait) {
        super(driver,wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement title;

    public String getTitle(){
       return title.getText();
    }

}