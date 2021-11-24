package pages.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class LoginPage extends BasePage {

    WebDriver driver;
    WebDriverWait wdWait;

    public LoginPage(WebDriver driver, WebDriverWait wdWait) {
        super(driver,wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#user-name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(xpath = "//*[@name='login-button']")
    WebElement loginButton;

    public void enterUsername(String usernameText){
        typeText(username,usernameText);
    }
    public void enterPassword(String passwordText){
        typeText(password,passwordText);
    }
    public void clickLogin(){
        click(loginButton);
    }
    public void login(String usernameText, String passwordText){
        enterUsername(usernameText);
        enterPassword(passwordText);
        clickLogin();
    }

}