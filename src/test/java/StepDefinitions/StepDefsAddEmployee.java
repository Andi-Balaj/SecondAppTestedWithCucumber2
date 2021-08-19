package StepDefinitions;

import Java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class StepDefsAddEmployee {
    private static final String BASE_URL = "http://localhost:4200/employees";
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private AddEmployee addEmployee;
    public String username;

    @Given("User is already logged in")
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

    @And("The employee page is displayed")
    public void testEmployeePage() {
        homePage = new HomePage(driver);
        homePage.getEmployees().click();

    }

    @When("The add button is clicked")
    public void testAddButton() {
        addEmployee = new AddEmployee(driver);


        addEmployee.getAddEmployees().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^The fields are completed with: ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*) and ([^\"]*)$")
    public void testAddEmployee(String name, String email, String internalPosition, String unit, String businessUnit, String supervisor, Integer workingHours, String startDay, String endDay) {
        addEmployee = new AddEmployee(driver);
        addEmployee.getAddName().sendKeys(name);
        addEmployee.getAddEmail().sendKeys(email);
        addEmployee.getAddInternalPosition().click();
        if (internalPosition.equals("Junior")) addEmployee.getAddJuniorPosition().click();
        addEmployee.getAddUnit().click();
        if (unit.equals("U1")) addEmployee.getAddU1().click();
        else addEmployee.getAddU2().click();
        addEmployee.getAddBusinessUnit().click();
        if (businessUnit.equals("BU1")) addEmployee.getAddBU1().click();
        else addEmployee.getAddBU2().click();
        addEmployee.getAddSupervisor().sendKeys(supervisor);
        addEmployee.getAddActiveButton().click();
        addEmployee.getAddNumberOfHours().sendKeys(String.valueOf(workingHours));
        addEmployee.getAddStartDay().sendKeys(startDay);
        addEmployee.getAddEndDay().sendKeys(endDay);
        username = name;

    }

    @And("I click on save button")
    public void testSubmitButton() {
        addEmployee.getAddSaveButton().click();
    }

    @Then("I check if employee was added")
    public void testIfUserWasAdded() {
        try {
            WebElement element = driver.findElement(By.xpath("//td[contains(.,'" + username + "')]"));
            Assert.assertNotNull(element);
            // System.out.println(numberOfEmployees);
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
