package co.weathershoppers.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.TreeMap;

import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.TIME_TO_WAIT;
import static co.weathershoppers.assignment.utils.AssertUtils.verifyURLEquals;
import static co.weathershoppers.assignment.constants.URLConstants.MOISTURIZERS_PATH;
import static co.weathershoppers.assignment.constants.URLConstants.BASE_URL;

import static co.weathershoppers.assignment.utils.ElementActions.clickWebElement;
import static co.weathershoppers.assignment.utils.ElementActions.goBack;
import static co.weathershoppers.assignment.utils.Waits.waitForWebElementClickable;

import static co.weathershoppers.assignment.helpers.DataStructureHelpers.generateTextList;
import static co.weathershoppers.assignment.helpers.DataStructureHelpers.createListOfNumbers;
import static co.weathershoppers.assignment.helpers.DataStructureHelpers.generateHashMapFromTwoArrayListWithStringAndInteger;
import static co.weathershoppers.assignment.helpers.DataStructureHelpers.generateListOfNamesFromTreeMap;
import static co.weathershoppers.assignment.helpers.DataStructureHelpers.generateListOfPricesFromListAndTreeMap;

import static co.weathershoppers.assignment.helpers.DataStructureHelpers.generateHashMapFromTwoArrayListWithIntegerAndString;
import static co.weathershoppers.assignment.helpers.DataStructureHelpers.addLeastExpensiveProductOnCart;
import static co.weathershoppers.assignment.utils.Waits.waitForWebElementTillDisplayedAndClickable;


public class MoisturizersPage {
    public MoisturizersPage(WebDriver driver) {
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


    public void verifyURL() {
        String fullURL = BASE_URL + MOISTURIZERS_PATH;
        verifyURLEquals(fullURL);
    }

    public void goBackToPreviousPage() {
        goBack();
    }

    public List<String> listOfMoisturizersNames() {
        waitForWebElementClickable(nameOfProduct, TIME_TO_WAIT);
        return generateTextList(nameOfProducts);
    }

    public List<Integer> listOfMoisturizersPrices() {
        List<String> pricesList = generateTextList(pricesOfProducts);
        return createListOfNumbers(pricesList);
    }

    public TreeMap<String, Integer> treeMapForAllMoisturizers() {
        return generateHashMapFromTwoArrayListWithStringAndInteger(listOfMoisturizersNames(),
                listOfMoisturizersPrices());
    }

    public List<String> getListOfAloeProductNames() {
        TreeMap<String, Integer> namesAndPricesOfMoisturisers = treeMapForAllMoisturizers();
        return generateListOfNamesFromTreeMap("Aloe", namesAndPricesOfMoisturisers);
    }

    public List<Integer> getListOfAloeProductPrices() {
        TreeMap<String, Integer> namesAndPricesOfMoisturisers = treeMapForAllMoisturizers();
        List<String> aloeProductNames = getListOfAloeProductNames();
        return generateListOfPricesFromListAndTreeMap(namesAndPricesOfMoisturisers, aloeProductNames);
    }

    public TreeMap<Integer, String> treeMapOfAllAloeMoisturizers() {
        return generateHashMapFromTwoArrayListWithIntegerAndString(getListOfAloeProductPrices(),
                getListOfAloeProductNames());
    }

    public List<String> getListOfAlmondsProductNames(){
        TreeMap<String, Integer> namesAndPricesOfMoisturisers = treeMapForAllMoisturizers();
        return generateListOfNamesFromTreeMap("almond", namesAndPricesOfMoisturisers);
    }

    public List<Integer> getListOfAlmondsProductPrices() {
        TreeMap<String, Integer> namesAndPricesOfMoisturisers = treeMapForAllMoisturizers();
        List<String> almondsProductNames = getListOfAlmondsProductNames();
        return generateListOfPricesFromListAndTreeMap(namesAndPricesOfMoisturisers, almondsProductNames);
    }

    public TreeMap<Integer, String> treeMapOfAllAlmondsMoisturizers() {
        return generateHashMapFromTwoArrayListWithIntegerAndString(getListOfAlmondsProductPrices(),
                getListOfAlmondsProductNames());
    }

    public void addLeastExpensiveAloeProductOnCart() {
        addLeastExpensiveProductOnCart(getListOfAloeProductPrices(), treeMapOfAllAloeMoisturizers(),
                listOfMoisturizersNames(), "aloe");
    }

    public void addLeastExpensiveAlmondsProductOnCart() {
        addLeastExpensiveProductOnCart(getListOfAlmondsProductPrices(), treeMapOfAllAlmondsMoisturizers(),
                listOfMoisturizersNames(), "almond");
    }

    public void clickOnCartButton(){
        waitForWebElementTillDisplayedAndClickable(cartButton, TIME_TO_WAIT);
        clickWebElement(cartButton);
    }
}
