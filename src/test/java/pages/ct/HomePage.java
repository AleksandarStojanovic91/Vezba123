package pages.ct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//a[text()='Otvori nalog']")
    WebElement otvoriNalog;

    public void otvoriNalog(){
        click(otvoriNalog);
    }

}
