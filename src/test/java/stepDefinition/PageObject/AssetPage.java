package stepDefinition.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssetPage extends Page {

    @FindBy(xpath = "//button[text()='Issue']")
    public WebElement buttonIssue;

    @FindBy(id = "name")
    public WebElement textboxPropertyName;

    @FindBy(xpath = "//input[@placeholder='Number of bitmarks']")
    public WebElement textboxNumberOfBitmark;

    AssetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
