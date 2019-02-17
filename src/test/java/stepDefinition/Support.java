package stepDefinition;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinition.PageObject.PageProvider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Support {

    static void waitForVisible(WebElement webElement) {
        waitStaleElement(webElement);
    }

    static void waitForVisible(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(PageProvider.driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static WebElement waitForVisibleLocator(By by) {
        WebDriverWait wait = new WebDriverWait(PageProvider.driver, 5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static boolean isValidDateFormat(String format, String value) {
        System.out.println("TESTING - isValidDateFormat " + value);
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date).toUpperCase())) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

    /**
     * Duel to Selenium issue
     * https://www.seleniumhq.org/exceptions/stale_element_reference.jsp
     *
     */
    private static boolean waitStaleElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(PageProvider.driver, 2);
        boolean staleElement = true;
        int count = 0;
        while (staleElement || count < 2) {
            try {
                sleep(1);
                wait.until(ExpectedConditions.visibilityOf(webElement));
                staleElement = false;

            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
            count++;
            System.out.println("TESTING - waitStaleElement" + staleElement + webElement);
        }

        return staleElement;
    }

    public static void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(PageProvider.driver, 2);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = PageProvider.driver.switchTo().alert();
            alert.accept();
            System.out.println("alert was present and accepted");

        } catch (TimeoutException e) {
            System.out.println("alert was not present");
        }
    }
}
