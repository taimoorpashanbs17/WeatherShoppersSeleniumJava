package co.weathershoppers.assignment.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static co.weathershoppers.assignment.WeatherShoppersTestBase.getWebDriver;
import static org.awaitility.Awaitility.await;

public class Waits {
    public static void waitForWebElement(WebElement element, int waitTime) {
        try {
            await()
                    .atMost(waitTime, TimeUnit.SECONDS)
                    .pollInterval(200, TimeUnit.MILLISECONDS)
                    .ignoreExceptions()
                    .until(element::isEnabled);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void waitForWebElementClickable(WebElement element, int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    public static void waitForWebElementTillDisplayedAndClickable(WebElement element, int waitTime) {
        try {
            waitForWebElement(element, waitTime);
            waitForWebElementClickable(element, waitTime);
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    public static void waitForNavigationToIFrame(int frameIndex, int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), waitTime);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    public static void waitTillURLToBe(String url, int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), waitTime);
            wait.until(ExpectedConditions.urlToBe(url));
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }
}
