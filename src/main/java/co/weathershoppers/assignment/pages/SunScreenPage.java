package co.weathershoppers.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.TreeMap;

import static co.weathershoppers.assignment.constants.URLConstants.BASE_URL;
import static co.weathershoppers.assignment.constants.URLConstants.SUNSCREEN_PATH;
import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.TIME_TO_WAIT;
import static co.weathershoppers.assignment.helpers.DataStructureHelpers.*;

import static co.weathershoppers.assignment.utils.ElementActions.clickWebElement;

import static co.weathershoppers.assignment.utils.AssertUtils.verifyURLEquals;
import static co.weathershoppers.assignment.utils.ElementActions.goBack;

import static co.weathershoppers.assignment.utils.Waits.waitForWebElementClickable;
import static co.weathershoppers.assignment.utils.Waits.waitForWebElementTillDisplayedAndClickable;

public class SunScreenPage {
    public SunScreenPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/div/p[1]")
    List<WebElement> nameOfProducts;

    @FindBy(xpath = "//div/div/p[1]")
    WebElement nameOfProduct;

    @FindBy(xpath = "//div/div/p[2]")
    List<WebElement> pricesOfProducts;

    @FindBy(xpath = "//button[@class='thin-text nav-link']")
    WebElement cartButton;

    public void verifyURL(){
        String fullURL = BASE_URL + SUNSCREEN_PATH;
        verifyURLEquals(fullURL);
    }

    public void goBackToPreviousPage(){
        goBack();
    }

    public List<String> listOfSunScreenNames() {
        waitForWebElementClickable(nameOfProduct, TIME_TO_WAIT, "SunScreen Product");
        return generateTextList(nameOfProducts);
    }

    public List<Integer> listOfSunScreenPrices() {
        List<String> pricesList = generateTextList(pricesOfProducts);
        return createListOfNumbers(pricesList);
    }

    public TreeMap<String, Integer> treeMapForAllSunScreens() {
        return generateHashMapFromTwoArrayListWithStringAndInteger(listOfSunScreenNames(),
                listOfSunScreenPrices());
    }

    public List<String> getListOfSPF50ProductNames() {
        TreeMap<String, Integer> namesAndPricesOfMoisturisers = treeMapForAllSunScreens();
        return generateListOfNamesFromTreeMap("SPF-50", namesAndPricesOfMoisturisers);
    }

    public List<Integer> getListOfSPF50ProductPrices() {
        TreeMap<String, Integer> namesAndPricesOfMoisturisers = treeMapForAllSunScreens();
        List<String> aloeProductNames = getListOfSPF50ProductNames();
        return generateListOfPricesFromListAndTreeMap(namesAndPricesOfMoisturisers, aloeProductNames);
    }

    public TreeMap<Integer, String> treeMapOfAllSPF50SunScreens() {
        return generateHashMapFromTwoArrayListWithIntegerAndString(getListOfSPF50ProductPrices(),
                getListOfSPF50ProductNames());
    }

    public List<String> getListOfSPF30ProductNames(){
        TreeMap<String, Integer> namesAndPricesOfSunScreen = treeMapForAllSunScreens();
        return generateListOfNamesFromTreeMap("SPF-30", namesAndPricesOfSunScreen);
    }

    public List<Integer> getListOfSPF30ProductPrices() {
        TreeMap<String, Integer> namesAndPricesOfSPF30SunScreen = treeMapForAllSunScreens();
        List<String> sPF30ProductNames = getListOfSPF30ProductNames();
        return generateListOfPricesFromListAndTreeMap(namesAndPricesOfSPF30SunScreen, sPF30ProductNames);
    }

    public TreeMap<Integer, String> treeMapOfAllSPF30SunScreens() {
        return generateHashMapFromTwoArrayListWithIntegerAndString(getListOfSPF30ProductPrices(),
                getListOfSPF30ProductNames());
    }

    public void addLeastExpensiveSPF50ProductOnCart() {
        addLeastExpensiveProductOnCart(getListOfSPF50ProductPrices(), treeMapOfAllSPF50SunScreens(),
                listOfSunScreenNames(), "SPF-50");
    }

    public void addLeastExpensiveSPF30ProductOnCart() {
        addLeastExpensiveProductOnCart(getListOfSPF30ProductPrices(), treeMapOfAllSPF30SunScreens(),
                listOfSunScreenNames(), "SPF-30");
    }

    public void clickOnCartButton(){
        waitForWebElementTillDisplayedAndClickable(cartButton, TIME_TO_WAIT, "Cart Button");
        clickWebElement(cartButton, "Cart Button");
    }
}
