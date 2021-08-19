package StepDefinitions;


import Java.EditEmployee;
import Java.HomePage;
import Java.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StepDefsEditEmployee {
    private static final String BASE_URL = "http://localhost:4200/employees";
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private EditEmployee editEmployee;
    private String username;

    @Given("User is already logged in and he is ready to test edit functionality")
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

    @And("The employee page is displayed for editing")
    public void testEmployeePage() {
        homePage = new HomePage(driver);
        homePage.getEmployees().click();

    }

    @When("The edit button is clicked")
    public void testAddButton() {
        editEmployee = new EditEmployee(driver);

        editEmployee.getEditButton().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^The fields are edited with: ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*) and ([^\"]*)$")
    public void testAddEmployee(String name, String email, String internalPosition, String unit, String businessUnit, String supervisor, Integer workingHours, String startDay, String endDay) {
        editEmployee = new EditEmployee(driver);
        editEmployee.clearFields();
        editEmployee.getEditName().sendKeys(name);
        editEmployee.getEditEmail().sendKeys(email);
        editEmployee.getEditUnit().click();
        if (unit.equals("U1")) editEmployee.getEditUnit1().click();
        else editEmployee.getEditUnit2().click();
        editEmployee.getEditBusinessUnit().click();
        if (businessUnit.equals("BU1")) editEmployee.getEditBusinessUnit1().click();
        else editEmployee.getEditBusinessUnit2().click();
        editEmployee.getEditSupervisor().sendKeys(supervisor);
        editEmployee.getEditWorkingHours().sendKeys(String.valueOf(workingHours));
        editEmployee.getEditStartDay().sendKeys(startDay);
        editEmployee.getEditEndDay().sendKeys(endDay);
        username = name;
    }

    @And("I click on save changes button")
    public void testSubmitButton() {
        editEmployee.getEditSaveButton().click();
    }

    @Then("I check if employee was edited")
    public void testIfUserWasAdded() {
        try {
            WebElement element = driver.findElement(By.xpath("//td[contains(.,'" + username + "')]"));
            Assert.assertNotNull(element);
        } catch (Exception e) {
            Assert.fail();
        }
    }

}
