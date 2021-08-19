package Java;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class EditEmployee {
    @FindBy(xpath = "(//span[@class='material-icons'][contains(.,'edit')])[1]")
    private WebElement editButton;
    @FindBy(xpath = "//input[contains(@formcontrolname,'name')]")
    private WebElement editName;
    @FindBy(xpath = "//input[contains(@formcontrolname,'email')]")
    private WebElement editEmail;
    @FindBy(xpath = "//form/div[3]")
    private WebElement editJunior;
    @FindBy(xpath = "//form/div[4]")
    private WebElement editUnit;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'U1')]")
    private WebElement editUnit1;
    @FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'U2')]")
    private WebElement editUnit2;
    @FindBy(xpath = "//form/div[5]")
    private WebElement editBusinessUnit;
    @FindBy(xpath = "//span[contains(.,'BU1')]")
    private WebElement editBusinessUnit1;
    @FindBy(xpath = "//span[contains(.,'BU2')]")
    private WebElement editBusinessUnit2;
    @FindBy(xpath = "//input[@formcontrolname='supervisor']")
    private WebElement editSupervisor;
    @FindBy(xpath = "//span[contains(.,'Active')]")
    private WebElement editActiveButton;
    @FindBy(xpath = "//input[@ng-reflect-name='workingHours']")
    private WebElement editWorkingHours;
    @FindBy(xpath = "//input[contains(@formcontrolname,'startDate')]")
    private WebElement editStartDay;
    @FindBy(xpath = "//input[contains(@formcontrolname,'endDate')]")
    private WebElement editEndDay;
    @FindBy(xpath = "//span[contains(.,'Save')]")
    private WebElement editSaveButton;
    private WebDriver driver;

    public EditEmployee(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clearFields() {
        editName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editSupervisor.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editWorkingHours.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editStartDay.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editEndDay.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        //JavascriptExecutor executor=(JavascriptExecutor) driver;
        //if(editActiveButton.isSelected()) executor.executeScript("trait.click()",editActiveButton);
    }

}
