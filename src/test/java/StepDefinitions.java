import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    WebDriver driver;
    @Given("User visits e-commerce website")
    public void user_visits_e_commerce_website() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops=new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");

    }
    @When("User enters valid {string} and {string}")
    public void user_enters_valid_and(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(email, password);
    }
    @Then("User can logged in successfully")
    public void user_can_logged_in_successfully()  {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.linkLogout.isDisplayed());
        loginPage.linkLogout.click();
        driver.close();
    }
}
