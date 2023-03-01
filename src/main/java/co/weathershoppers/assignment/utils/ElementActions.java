package co.weathershoppers.assignment.utils;

import co.weathershoppers.assignment.WeatherShoppersTestBase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static co.weathershoppers.assignment.utils.Waits.waitForWebElement;
import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.TIME_TO_WAIT;

public class ElementActions extends WeatherShoppersTestBase {
    public static void clickWebElement(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException see) {
            see.getStackTrace();
        }
    }

    public static void goBack(){
        getWebDriver().navigate().back();
    }

    public static void sendTextToWebElement(WebElement element, String elementName, String textToEnter) {
        waitForWebElement(element, TIME_TO_WAIT);
        try {
            element.sendKeys(textToEnter);
        } catch (NoSuchElementException var5) {
            System.out.println("Unable to Enter "+textToEnter+" on "+elementName+" Field.");
        }

    }

}
