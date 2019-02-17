package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import stepDefinition.PageObject.PageProvider;

public class Hook {

    @Before
    public void before() {
        String driverPath;
        switch (System.getProperty("os.name")) {
            case "Linux":
                driverPath = "src/test/resources/driver/chromedriver";
                break;
            default:
                driverPath = "src/test/resources/driver/windowchromedriver";
                break;
        }

        System.setProperty("webdriver.chrome.driver", driverPath);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        PageProvider.setDriver(new ChromeDriver(capabilities));
    }

    @After
    public void after() {
        PageProvider.driver.quit();
    }
}