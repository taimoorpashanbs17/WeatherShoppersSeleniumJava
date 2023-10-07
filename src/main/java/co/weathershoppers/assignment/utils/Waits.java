package co.weathershoppers.assignment.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static co.weathershoppers.assignment.helpers.Log4jHelper.log;

import static co.weathershoppers.assignment.WeatherShoppersTestBase.getWebDriver;
import static org.awaitility.Awaitility.await;

public class Waits {
    public static void waitForWebElement(WebElement element, int waitTime, String elementName) {
        log().info("Waiting for "+elementName+ " to be displayed");
        try {
            await()
                    .atMost(waitTime, TimeUnit.SECONDS)
                    .pollInterval(200, TimeUnit.MILLISECONDS)
                    .ignoreExceptions()
                    .until(element::isEnabled);
        } catch (Exception ex) {
            log().error("Waited for "+waitTime+" seconds, but "+elementName+" didn't get displayed, due to " +ex.getMessage());
        }
    }

    public static void waitForWebElementClickable(WebElement element, int waitTime, String elementName) {
        log().info("Waiting for "+elementName+ " to be clickable");
        try {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(waitTime));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception var5) {
            log().error("Unable to click "+elementName+" within " +waitTime+" seconds, due to "+var5.getMessage());
        }
    }

    public static void waitForWebElementTillDisplayedAndClickable(WebElement element, int waitTime, String elementName) {
        waitForWebElement(element, waitTime, elementName);
        waitForWebElementClickable(element, waitTime, elementName);
    }

    public static void waitForNavigationToIFrame(int frameIndex, int waitTime) {
        log().info("Waiting to Navigate "+frameIndex+" index iFrame");
        try {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(waitTime));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
        } catch (Exception var5) {
            log().error("Unable to navigate to "+frameIndex+" index iFrame, within "+waitTime+
                    "seconds, due to "+var5.getMessage());
        }
    }

    public static void waitTillURLToBe(String url, int waitTime) {
        log().info("Waiting for URL to be "+url);
        try {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(waitTime));
            wait.until(ExpectedConditions.urlToBe(url));
        } catch (Exception var5) {
            log().error("URL is not changed to "+url+" , within " +waitTime+" seconds, due to "+var5.getMessage());
        }
    }
}
