package Java;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class DeleteEmployee {
    @FindBy(xpath = "(//span[@class='material-icons'][contains(.,'delete')])[1]")
    private WebElement deleteButton;
    @FindBy(xpath = "//span[contains(.,'Yes')]")
    private WebElement yesButton;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Cancel')]")
    private WebElement cancelButton;
    private WebDriver driver;

    public DeleteEmployee(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
