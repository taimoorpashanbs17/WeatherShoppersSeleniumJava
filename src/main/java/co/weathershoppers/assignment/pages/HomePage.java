package co.weathershoppers.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static co.weathershoppers.assignment.utils.ElementActions.clickWebElement;

import static co.weathershoppers.assignment.utils.Waits.waitForWebElementTillDisplayedAndClickable;

import static co.weathershoppers.assignment.utils.AssertUtils.assertElementVisible;
import static co.weathershoppers.assignment.utils.AssertUtils.verifyWebElementTextIs;
import static co.weathershoppers.assignment.utils.AssertUtils.verifyWebElementContainsText;

import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.TIME_TO_WAIT;

import static co.weathershoppers.assignment.constants.URLConstants.BASE_URL;
import static co.weathershoppers.assignment.utils.AssertUtils.verifyURLEquals;

/**
     * <h2> Home Page </h2>
     * All Methods and Variables (Locators) of 'Home' Page will be done here.
     * <p>
     * <b>Note:</b> Comments make the code readable and
     * easy to understand.
     *
     * @author Taimoor Pasha
     * @version 1.0
     * @since 2023-03-01
 */
public class HomePage {

    /**
     * Constructor for HomePage, so that it can be called at WebBasePage and
     * direct Method can be called on Test Pages.
     */

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /**
     * All locators of Home Page are Defined below.
     *
     */

    @FindBy(tagName = "h2")
    WebElement currentTemperatureHeader;

    @FindBy(id = "temperature")
    WebElement temperatureText;

    @FindBy(xpath = "//button[normalize-space()='Buy moisturizers']")
    WebElement buyMoisturizersButton;

    @FindBy(xpath = "//button[normalize-space()='Buy sunscreens']")
    WebElement buySunScreensButton;

    @FindBy(xpath = "//div[3]/div[1]/p")
    WebElement moisturizerText;

    @FindBy(xpath = "//div[3]/div[2]/p")
    WebElement sunScreenText;

    @FindBy(xpath = "//a[contains(text(),'Qxf2')]")
    WebElement qxf2Link;

    public void verifyURL(){
        verifyURLEquals(BASE_URL);
    }

    /**
     * Waiting for 'Buy Moisturizers' Button to be displayed and clickable,
     after that, It will click that button.
     *
     */
    public void clickOnBuyMoisturizersButton(){
        waitForWebElementTillDisplayedAndClickable(buyMoisturizersButton, TIME_TO_WAIT);
        clickWebElement(buyMoisturizersButton);
    }

    /**
     * Waiting for 'Buy SunScreen' Button to be displayed and clickable,
     after that, It will click that button.
     *
     */

    public void clickOnBuySunScreensButton(){
        waitForWebElementTillDisplayedAndClickable(buySunScreensButton, TIME_TO_WAIT);
        clickWebElement(buySunScreensButton);
    }

    /**
     * Waiting for 'QXF2' Link to be displayed and clickable,
     after that, It will click that button.
     *
     */
    public void clickOnQXF2Link(){
        waitForWebElementTillDisplayedAndClickable(qxf2Link, TIME_TO_WAIT);
        clickWebElement(qxf2Link);
    }

    /**
     * Check that Current Temperature Header is displaying or not.
     *
     */
    public void checkCurrentTemperatureHeaderDisplaying(){
        assertElementVisible(currentTemperatureHeader, "Current Temperature Header");
    }

    /**
     * Check that 'Buy Moisturizers' Button is displaying or not.
     *
     */
    public void checkBuyMoisturizersButtonDisplaying(){
        assertElementVisible(buyMoisturizersButton, "Buy Moisturizers Button");
    }

    /**
     * Check that 'Buy SunScreen' Button is displaying or not.
     *
     */
    public void checkBuySunScreenButtonDisplaying(){
        assertElementVisible(buySunScreensButton, "Buy Sun Screen Button");
    }

    public void checkQxf2LinkDisplaying(){
        assertElementVisible(qxf2Link, "qxf2 Link");
    }

    public void checkTemperatureContainsText(String textToBeContained){
        verifyWebElementContainsText(temperatureText, "Temperature Text", textToBeContained);
    }

    public void verifyMoisturizerTextDisplayingAndIs(String textMessage){
        assertElementVisible(moisturizerText, "Moisturizer Text");
        verifyWebElementTextIs(moisturizerText, "Moisturizer Text", textMessage);
    }

    public void verifySunScreenTextDisplayingAndIs(String textMessage){
        assertElementVisible(sunScreenText, "SunScreen Text");
        verifyWebElementTextIs(sunScreenText, "SunScreen Text", textMessage);
    }

    public int getTemperature(){
        String getTemperatureText = temperatureText.getText();
        int textSize = getTemperatureText.length();
        int actualTemperature = 0;
        if (textSize == 4){
            actualTemperature = Integer.parseInt(getTemperatureText.substring(0, 1));
        }
        else if (textSize == 5) {
            actualTemperature = Integer.parseInt(getTemperatureText.substring(0, 2));
        }
        return actualTemperature;
    }

    public void selectShoppingAccordingly(Integer temperature){
        if(temperature>34){
            clickOnBuySunScreensButton();
        }
        else if (temperature<19){
            clickOnBuyMoisturizersButton();
        }
    }
}
