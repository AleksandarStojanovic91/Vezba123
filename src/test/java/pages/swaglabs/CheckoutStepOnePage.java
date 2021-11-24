package pages.swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class CheckoutStepOnePage extends BasePage {

    WebDriver driver;
    WebDriverWait wdWait;

    public CheckoutStepOnePage(WebDriver driver, WebDriverWait wdWait) {
        super(driver,wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#first-name")
    WebElement firstNameField;
    @FindBy(css = "#last-name")
    WebElement lastNameField;
    @FindBy(css = "#postal-code")
    WebElement zipCodeField;
    @FindBy(css = "#continue")
    WebElement continueButton;

    public void enterFirstName(String firstNameText){
        typeText(firstNameField, firstNameText);
    }

    public void enterLastName(String lastNameText){
        typeText(lastNameField, lastNameText);
    }

    public void enterZipCode(String zipCodeText){
        typeText(zipCodeField, zipCodeText);
    }

    public void clickContinue(){
        click(continueButton);
    }

    public void fillCheckoutStepInformation(String firstNameText, String lastNameText, String zipCodeText){
        enterFirstName(firstNameText);
        enterLastName(lastNameText);
        enterZipCode(zipCodeText);
    }


}