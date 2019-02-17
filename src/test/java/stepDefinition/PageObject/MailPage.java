package stepDefinition.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends Page {

    @FindBy(id = "identifierId")
    public WebElement textboxEmailGmail;

    @FindBy(xpath = "//span[@data-hovercard-id='support@bitmark.com']/ancestor::td")
    public WebElement labelBitmarkMail;

    @FindBy(id = "identifierNext")
    public WebElement buttonNextEmail;

    @FindBy(css = "#password input")
    public WebElement textboxPassword;

    @FindBy(id = "passwordNext")
    public WebElement buttonNextPassword;

    @FindBy(xpath = "//a[contains(text(), 'webapp.test.bitmark.')]")
    public WebElement linkSignIn;

    MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
