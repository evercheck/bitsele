package stepDefinition.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertiesPage extends Page {

    @FindBy(xpath = "//a[contains(text(), 'YOUR PROPERTIES')]")
    public WebElement linkYourProperties;

    @FindBy(xpath = "(//div[@class='download']/a[contains(text(), 'DOWNLOAD')])[1]")
    public WebElement linkDownload;

    @FindBy(css = "#property-list .tb-list .time")
    public WebElement cellTimeStamp;

    @FindBy(css = "#property-list .tb-list .details")
    public WebElement cellDetails;


    PropertiesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
