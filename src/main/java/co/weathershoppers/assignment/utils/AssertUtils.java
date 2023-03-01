package co.weathershoppers.assignment.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static co.weathershoppers.assignment.WeatherShoppersTestBase.getWebDriver;
import static co.weathershoppers.assignment.utils.Waits.waitForWebElement;

public class AssertUtils {

    public static void verifyURLEquals(String url){
        String currentURL = getWebDriver().getCurrentUrl();
        if(currentURL.equals(url)){
            System.out.println("Url is same");
        }else {
            System.out.println(url+ " is not correct URL");

        }
    }

    public static void assertElementVisible(WebElement webElement, String elementName) {
        try {
            webElement.isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println(elementName + " is not visible.");
        }
    }

    public static void verifyWebElementTextIs(WebElement webElement, String elementName, String expectedText) {
        String actualText = webElement.getText();
        if (actualText.equals(expectedText)) {
            System.out.println("Text is correct.");
        } else {
            System.out.println("Text of "+elementName+" is not "+expectedText+" , actual text is "+actualText);
        }
    }

    public static void verifyWebElementContainsText(WebElement webElement, String elementName, String containedText) {
        String actualText = webElement.getText();
        if (actualText.contains(containedText)) {
            System.out.println("Text is correct.");
        } else {
            System.out.println("Text of "+elementName+" does not contain "+containedText+" , " +
                    "actual text is "+actualText);

        }
    }
}
