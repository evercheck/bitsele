package stepDefinition.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefinition.Status;
import stepDefinition.Support;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Page {

    public Map<String, String> scenarioContext = new HashMap();
    private String labelXpath = "//*[contains(text(), '%s')]";

    WebDriver driver;

    public void openPage(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public void verifyElementStatus(WebElement webElement, Status status) {
        if (status.equals(Status.ENABLED)) {
            assertTrue(webElement.isEnabled());
        } else {
            assertFalse(webElement.isEnabled());
        }
    }

    public void verifyLabelIsDisplayed(String value) {
        WebElement element = Support.waitForVisibleLocator(By.xpath(String.format(labelXpath, value)));
        assertTrue(element.isDisplayed());
    }
}
