package pages.ct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class AccountCreatePage extends BasePage {
    WebDriver driver;
    WebDriverWait wdWait;

    public AccountCreatePage(WebDriver driver, WebDriverWait wdWait) {
        super(driver,wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#firstname")
    WebElement firstName;
    @FindBy(css = "#lastname")
    WebElement lastName;
    @FindBy(css = "#email_address")
    WebElement emailAddress;
    @FindBy(css = "#pravnolice")
    WebElement pravnoLice;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#confirmation")
    WebElement passConfirmation;
    @FindBy(css = "[title='Submit']")
    WebElement submit;

    public void enterFirstName(String value){
        typeText(firstName, value);
    }

    public void enterLastName(String value){
        typeText(lastName, value);
    }

    public void enterEmail(String value){
        typeText(emailAddress, value);
    }

    public void enterPassword(String value){
        typeText(password, value);
    }

    public void enterConfirmedPass(String value){
        typeText(passConfirmation, value);
    }

    public void submit(){
        click(submit);
    }

    public void selectPravnoLiceByText(String value){
        selectByVisibleText(pravnoLice, value);
    }

    public void registerUser(String firstNameText, String lastNameText, String emailText, String pravnoLiceText,String passwordText){
        enterFirstName(firstNameText);
        enterLastName(lastNameText);
        enterEmail(emailText);
        selectPravnoLiceByText(pravnoLiceText);
        enterPassword(passwordText);
        enterConfirmedPass(passwordText);
        submit();
    }

}
