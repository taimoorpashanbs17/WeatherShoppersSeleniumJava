package co.weathershoppers.assignment.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static co.weathershoppers.assignment.WeatherShoppersTestBase.getWebDriver;
import static co.weathershoppers.assignment.helpers.Log4jHelper.log;

public class AssertUtils {

    public static void verifyURLEquals(String url) {
        String currentURL = getWebDriver().getCurrentUrl();
        if (currentURL.equals(url)) {
            log().info("Url is correct i.e. " + url);
        } else {
            log().error("Expected URL is " + url + " but current URL is " + currentURL);

        }
    }

    public static void assertElementVisible(WebElement webElement, String elementName) {
        try {
            webElement.isDisplayed();
            log().info(elementName + " is displaying.");
        } catch (NoSuchElementException noSuchElementException) {
            log().error(elementName + " is not visible.");
        }
    }

    public static void verifyWebElementTextIs(WebElement webElement, String elementName, String expectedText) {
        String actualText = webElement.getText();
        if (actualText.equals(expectedText)) {
            log().info(expectedText + " on " + elementName + " field is showing.");
        } else {
            log().error("Text of " + elementName + " is not " + expectedText + " , actual text is " + actualText);
        }
    }

    public static void verifyWebElementContainsText(WebElement webElement, String elementName, String containedText) {
        String actualText = webElement.getText();
        if (actualText.contains(containedText)) {
            log().info(elementName + " does contains [" + containedText + "] Text");
        } else {
            log().error("Text of " + elementName + " does not contain " + containedText + " , " +
                    "actual text is " + actualText);
        }
    }
}
