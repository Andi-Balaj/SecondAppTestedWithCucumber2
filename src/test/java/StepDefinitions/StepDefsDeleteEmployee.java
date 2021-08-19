package StepDefinitions;

import Java.DeleteEmployee;
import Java.HomePage;
import Java.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class StepDefsDeleteEmployee {
    private final static String BASE_URL = "http://localhost:4200/employees";
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private DeleteEmployee deleteEmployee;

    @Given("User is already logged in on the application")
    public void testUserIsLoggedIn() {
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/");
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        loginPage.getUsername().sendKeys("AdminOne");
        loginPage.getPassword().sendKeys("PasswordOne");
        loginPage.getLoginButton().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
    }

    @When("The employee page is displayed for deleting employees")
    public void testEmployeePage() {
        homePage = new HomePage(driver);
        homePage.getEmployees().click();
    }

    @And("The delete button is clicked")
    public void testDeleteEmployees() {
        deleteEmployee = new DeleteEmployee(driver);
        driver.findElement(By.xpath("(//span[@class='material-icons'][contains(.,'delete')])")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button[contains(.,'Yes')]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Then("I check if employees were deleted")
    public void testDeletedEmployees() {
        boolean deletedElement;
        try {
            driver.findElement(By.xpath("//td[@role='cell'][contains(.,'Valentin Radu')]")).isDisplayed();
            deletedElement = true;
        } catch (NoSuchElementException e) {
            deletedElement = false;
        }

        // checking presence == false
        Assert.assertEquals(deletedElement, false);
    }
}
