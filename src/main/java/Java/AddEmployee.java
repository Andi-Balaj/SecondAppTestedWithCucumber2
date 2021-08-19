package Java;

import lombok.Getter;
import lombok.experimental.FieldNameConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class AddEmployee {
    @FindBy(xpath = "//span[contains(.,'Employees')]")
    private WebElement employeesButton;
    @FindBy(xpath = "//span[@class='material-icons'][contains(.,'add')]")
    private WebElement addEmployees;
    @FindBy(xpath = "//input[contains(@formcontrolname,'name')]")
    private WebElement addName;
    @FindBy(xpath = "//input[contains(@id,'mat-input-3')]")
    private WebElement addEmail;
    @FindBy(xpath = "//form/div[3]")
    private WebElement addInternalPosition;
    @FindBy(xpath = "//span[contains(.,'Junior')]")
    private WebElement addJuniorPosition;
    @FindBy(xpath = "//form/div[4]")
    private WebElement addUnit;
    @FindBy(xpath = "//span[contains(.,'U1')]")
    private WebElement addU1;
    @FindBy(xpath = "//span[contains(.,'U2')]")
    private WebElement addU2;
    @FindBy(xpath = "//form/div[5]")
    private WebElement addBusinessUnit;
    @FindBy(xpath = "//span[contains(.,'BU1')]")
    private WebElement addBU1;
    @FindBy(xpath = "//span[contains(.,'BU2')]")
    private WebElement addBU2;
    @FindBy(xpath = "//input[contains(@formcontrolname,'supervisor')]")
    private WebElement addSupervisor;
    @FindBy(xpath = "//span[@class='mat-checkbox-inner-container']")
    private WebElement addActiveButton;
    @FindBy(xpath = "//input[contains(@formcontrolname,'workingHours')]")
    private WebElement addNumberOfHours;
    @FindBy(xpath = "//input[contains(@formcontrolname,'startDate')]")
    private WebElement addStartDay;
    @FindBy(xpath = "//input[contains(@formcontrolname,'endDate')]")
    private WebElement addEndDay;
    @FindBy(xpath = "//button[contains(.,'Save')]")
    private WebElement addSaveButton;
    private WebDriver driver;

    public AddEmployee(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
