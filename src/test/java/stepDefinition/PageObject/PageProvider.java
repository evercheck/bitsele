package stepDefinition.PageObject;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    public static WebDriver driver;
    private static SignInPage signInPage;
    private static MailPage mailPage;
    private static WebAppPage webAppPage;
    private static AssetPage assetPage;
    private static PropertiesPage propertiesPage;

    public static void setDriver(WebDriver driver) {
        PageProvider.driver = driver;
        signInPage = new SignInPage(driver);
        mailPage = new MailPage(driver);
        webAppPage = new WebAppPage(driver);
        assetPage = new AssetPage(driver);
        propertiesPage = new PropertiesPage(driver);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static SignInPage getSignInPage() {
        if (signInPage == null) {
            signInPage = new SignInPage(driver);
        }
        return signInPage;
    }

    public static MailPage getMailPage() {
        if (mailPage == null) {
            mailPage = new MailPage(driver);
        }
        return mailPage;
    }

    public static WebAppPage getWebAppPage() {
        if (webAppPage == null) {
            webAppPage = new WebAppPage(driver);
        }
        return webAppPage;
    }

    public static AssetPage getAssetPage() {
        if (assetPage == null) {
            assetPage = new AssetPage(driver);
        }
        return assetPage;
    }

    public static PropertiesPage getPropertiesPage() {
        if (propertiesPage == null) {
            propertiesPage = new PropertiesPage(driver);
        }

        return propertiesPage;
    }
}
