package Java;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class AddProject {
    @FindBy(xpath = "//span[contains(.,'Projects')]")
    private WebElement projectButton;
    @FindBy(xpath = "//span[@class='material-icons'][contains(.,'add')]")
    private WebElement addProject;
    @FindBy(xpath = "//td[@role='cell'][contains(.,'Project1')]")
    private WebElement existingProject;
    @FindBy(xpath = "//input[contains(@formcontrolname,'name')]")
    private WebElement addName;
    @FindBy(xpath = "//input[contains(@formcontrolname,'client')]")
    private WebElement addClient;
    @FindBy(xpath = "//input[contains(@formcontrolname,'startDate')]")
    private WebElement addStartDate;
    @FindBy(xpath = "//input[contains(@formcontrolname,'endDate')]")
    private WebElement addEndDate;
    @FindBy(xpath = "//textarea[contains(@formcontrolname,'description')]")
    private WebElement addDescription;
    @FindBy(xpath = "//span[contains(.,'Cancel')]")
    private WebElement cancelButton;
    @FindBy(xpath = "//span[contains(.,'Add Project')]")
    private WebElement saveProject;
    private WebDriver driver;

    public AddProject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
