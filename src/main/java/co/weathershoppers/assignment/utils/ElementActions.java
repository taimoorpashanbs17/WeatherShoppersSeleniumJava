package co.weathershoppers.assignment.utils;

import co.weathershoppers.assignment.WeatherShoppersTestBase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static co.weathershoppers.assignment.utils.Waits.waitForWebElement;
import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.TIME_TO_WAIT;
import static co.weathershoppers.assignment.helpers.Log4jHelper.log;

public class ElementActions extends WeatherShoppersTestBase {
    public static void clickWebElement(WebElement element, String elementName) {
        try {
            element.click();
            log().info("Clicked on "+elementName);

        } catch (NoSuchElementException e) {
            log().error("Unable to click on "+elementName+" due to "+e.getMessage());
        }
    }

    public static void goBack(){
        try{
            getWebDriver().navigate().back();
            log().info("Navigating back.");
        }
        catch (RuntimeException e){
            log().error("Unable to navigate back, due to "+e.getMessage());
        }

    }

    public static void sendTextToWebElement(WebElement element, String elementName, String textToEnter) {
        waitForWebElement(element, TIME_TO_WAIT, elementName);
        try {
            element.sendKeys(textToEnter);
            log().info("Entered "+textToEnter+" on "+elementName+" input field");
        } catch (NoSuchElementException e) {
            log().error("Unable to Enter " + textToEnter + " on "
                    + elementName + " Field, due to "+e.getMessage());
        }

    }

}
