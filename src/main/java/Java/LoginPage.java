package Java;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPage {
    @FindBy(xpath = "//input[contains(@id,'mat-input-0')]")
    private WebElement username;
    @FindBy(xpath = "//input[contains(@id,'mat-input-1')]")
    private WebElement password;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Login')]")
    private WebElement loginButton;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
