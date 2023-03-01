import co.weathershoppers.assignment.pages.WebBasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static co.weathershoppers.assignment.constants.WeatherShoppersTextConstants.TEMPERATURE_FORMAT_TEXT;
import static co.weathershoppers.assignment.constants.WeatherShoppersTextConstants.MOISTURIZER_TEXT;
import static co.weathershoppers.assignment.constants.WeatherShoppersTextConstants.SUNSCREEN_TEXT;

public class HomeTests extends WebBasePage {
    @Test
    @Description("Verify that UI Buttons and Texts within Home Page are displaying")
    public void verifyUIFeaturesOfHomePage(){
        homePage.checkCurrentTemperatureHeaderDisplaying();
        homePage.checkTemperatureContainsText(TEMPERATURE_FORMAT_TEXT);
        homePage.checkBuyMoisturizersButtonDisplaying();
        homePage.checkBuySunScreenButtonDisplaying();
        homePage.checkQxf2LinkDisplaying();
        homePage.verifyMoisturizerTextDisplayingAndIs(MOISTURIZER_TEXT);
        homePage.verifySunScreenTextDisplayingAndIs(SUNSCREEN_TEXT);
    }

    @Test
    @Description("Verify Page Navigation from various pages and coming back to Home Page")
    public void verifyUINavigationFromHomePage(){
        homePage.clickOnBuyMoisturizersButton();
        moisturizersPage.verifyURL();
        moisturizersPage.goBackToPreviousPage();
        homePage.verifyURL();
        homePage.clickOnBuySunScreensButton();
        sunScreenPage.verifyURL();
        sunScreenPage.goBackToPreviousPage();
        homePage.verifyURL();
        homePage.clickOnQXF2Link();
        qxf2Page.verifyURL();
        qxf2Page.goBackToPreviousPage();
        homePage.verifyURL();
    }

    @Test(groups = {"Regression"})
    @Description("Shop for moisturizers if the weather is below 19 degrees. Shop for SunScreens if the weather " +
            "is above 34 degrees.")
    public void verifyShoppingMenu(){
        Integer temperature = homePage.getTemperature();
        homePage.selectShoppingAccordingly(temperature);
    }
}
