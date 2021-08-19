package StepDefinitions;

import Java.AddProject;
import Java.HomePage;
import Java.LoginPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StepDefsAddProject {
    //private static final String BASE_URL="http://localhost:4200/employees";
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private AddProject addProject;
    private String projectName;

    @Given("User is already logged in for adding a new project")
    public void testUserIsLoggedIn() {
        driver = new ChromeDriver();
        driver.get("http://localhost:4200");
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

    @And("The main page is displayed")
    public void testMainPage() {
        homePage = new HomePage(driver);
        homePage.getAddProject();
    }

    @When("The add project button is clicked")
    public void testAddProjectButton() {
        addProject = new AddProject(driver);
        addProject.getAddProject().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^The fields project are completed with: ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*)$")
    public void testAddProject(String name, String client, String startDate, String endDate, String description) {
        addProject = new AddProject(driver);
        addProject.getAddName().sendKeys(name);
        addProject.getAddClient().sendKeys(client);
        addProject.getAddStartDate().sendKeys(startDate);
        addProject.getAddEndDate().sendKeys(endDate);
        addProject.getAddDescription().sendKeys(description);
        addProject.getSaveProject().click();
        projectName = name;
    }

    @And("I click on save project button")
    public void testSaveProjectButton() {
        addProject.getSaveProject().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I check if the project was added")
    public void testIfProjectWasAdded() {
        //driver.navigate().refresh();
        try {
            Assert.assertTrue(addProject.getExistingProject().isDisplayed());
        } catch (Exception e) {
            Assert.fail();
        }

//        boolean isInserted;
//        try{
//            driver.findElement(By.xpath("//td[contains(.,'" + projectName + "')]")).isDisplayed();
//            isInserted=true;
//        }catch (Exception e){
//            isInserted=false;
//        }
//        Assert.assertEquals(isInserted,true);
    }

}
