package steps;

import excel_core.ExcelUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.swaglabs.LoginPage;
import tests.BaseTest;

import java.io.IOException;
import java.util.Map;

public class CucumberSteps extends BaseTest {

    Map<String,String> data;

    @Before
    public void initCucumber(){
        init("Chrome","95",30);
    }

    @After
    public void tearDown() throws IOException {
        reportScreenshot("Test", "TestAllure");
        quitDriver();
    }

    @Given("I am on SwagLabs page")
    public void iAmOnSwagLabsPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @And("I click login button")
    public void iClickLoginButton() {
        LoginPage loginPage = new LoginPage(driver,wdWait);
        loginPage.clickLogin();
    }

    @Then("I should see products")
    public void iShouldSeeProducts() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(driver.getTitle(),"Swag Labs" );
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "PRODUCTS");
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getAttribute("class"),"title");
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getCssValue("text-transform"),"uppercase");
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        LoginPage loginPage = new LoginPage(driver,wdWait);
        loginPage.enterUsername(username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver,wdWait);
        loginPage.enterPassword(password);
    }

    @Given("I have entered excel data in file {string} and sheet {string} and row {string}")
    public void iHaveEnteredExcelDataInFileAndSheetAndRow(String file, String sheet, String row) throws IOException {
        data = new ExcelUtils().getRowData("src/test/testData/"+file+".xlsx",sheet,Integer.parseInt(row));
    }

    @When("I enter username")
    public void iEnterUsername() {
        LoginPage loginPage = new LoginPage(driver,wdWait);
        loginPage.enterUsername(data.get("Username"));
    }

    @And("I enter password")
    public void iEnterPassword() {
        LoginPage loginPage = new LoginPage(driver,wdWait);
        loginPage.enterPassword(data.get("Password"));
    }

    @And("I take allure screenshot")
    public void iTakeAllureScreenshot() throws IOException {
        reportScreenshot("Test", "TestAllure");
    }
}
