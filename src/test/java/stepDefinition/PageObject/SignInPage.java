package stepDefinition.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Page {

    @FindBy(xpath = "//div[contains(text(), 'Bitmark digital estate')]")
    public WebElement labelTitle;

    @FindBy(xpath = "//div[@class='logo']//img[@alt='bitmark logo']")
    public WebElement imageTitle;

    @FindBy(xpath = "//li[contains(text(), 'Sign in with app')]")
    public WebElement tabSignInWithApp;

    @FindBy(xpath = "//li[contains(text(), 'Sign in / Sign up')]")
    public WebElement tabSignInSignUp;

    @FindBy(id = "tlemail")
    public WebElement textboxEmail;

    @FindBy(xpath = "//button[text()='CONTINUE']")
    public WebElement buttonContinue;


    SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void verifyEmailIsSubmit() {
        verifyLabelIsDisplayed("Check your email!");
        verifyLabelIsDisplayed("Click the magic link we emailed you to join Bitmark.");
        verifyLabelIsDisplayed("Didn’t get an email?");
        verifyLabelIsDisplayed("Try again.");
    }
}
