package Java;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HomePage {
    @FindBy(xpath = "//span[contains(.,'Projects')]")
    private WebElement projects;
    @FindBy(xpath = "//span[contains(.,'Employees')]")
    private WebElement employees;
    @FindBy(xpath = "//span[contains(.,'Logout')]")
    private WebElement logout;
    @FindBy(xpath = "//span[@class='material-icons'][contains(.,'add')]")
    private WebElement addProject;
    @FindBy(xpath = "//span[contains(.,'Cancel')]")
    private WebElement cancelProject;
    @FindBy(xpath = "//span[@class='material-icons']")
    private WebElement addEmployees;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Cancel')]")
    private WebElement cancelEmployees;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
