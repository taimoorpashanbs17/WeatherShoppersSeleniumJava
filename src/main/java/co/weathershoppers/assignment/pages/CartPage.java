package co.weathershoppers.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static co.weathershoppers.assignment.constants.URLConstants.BASE_URL;
import static co.weathershoppers.assignment.constants.URLConstants.CART_PATH;

import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.TIME_TO_WAIT;

import static co.weathershoppers.assignment.utils.AssertUtils.verifyURLEquals;

import static co.weathershoppers.assignment.utils.Waits.waitForWebElementTillDisplayedAndClickable;
import static co.weathershoppers.assignment.utils.Waits.waitForNavigationToIFrame;
import static co.weathershoppers.assignment.utils.Waits.waitForWebElementClickable;

import static co.weathershoppers.assignment.utils.ElementActions.clickWebElement;
import static co.weathershoppers.assignment.utils.ElementActions.sendTextToWebElement;

import static co.weathershoppers.assignment.WeatherShoppersTestBase.getWebDriver;

public class CartPage {

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Pay with Card']")
    WebElement payWithCard;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "card_number")
    WebElement cardNumberField;

    @FindBy(id = "cc-exp")
    WebElement monthYearExpiryField;

    @FindBy(id = "cc-csc")
    WebElement cvcField;

    @FindBy(id = "submitButton")
    WebElement payButton;

    @FindBy(name = "zip")
    WebElement zipCodeField;

    public void verifyURL(){
        String url = BASE_URL + CART_PATH;
        verifyURLEquals(url);
    }

    public void clickOnPayWithCard(){
        waitForWebElementTillDisplayedAndClickable(payWithCard, TIME_TO_WAIT, "Pay with Card Button");
        clickWebElement(payWithCard, "Pay with Card Button");
    }

    public void enterCreditCardInformation(String email, String cardNumber, String month, String year,
                                           String cvcNumber, String zipCode) {
        waitForNavigationToIFrame(0, TIME_TO_WAIT);
        waitForWebElementTillDisplayedAndClickable(emailField, TIME_TO_WAIT, "Email Field");
        sendTextToWebElement(emailField, "Email Field", email);
        waitForWebElementTillDisplayedAndClickable(cardNumberField, TIME_TO_WAIT, "Credit Card Field");
        sendTextToWebElement(cardNumberField, "Credit Card Field", cardNumber);
        waitForWebElementClickable(cardNumberField, TIME_TO_WAIT, "Credit Card Field");
        sendTextToWebElement(cardNumberField, "Credit Card Field", cardNumber);
        waitForWebElementClickable(cardNumberField, TIME_TO_WAIT, "Credit Card Field");
        sendTextToWebElement(cardNumberField, "Credit Card Field", cardNumber);
        waitForWebElementClickable(cardNumberField, TIME_TO_WAIT, "Credit Card Field");
        sendTextToWebElement(cardNumberField, "Credit Card Field", cardNumber);
        sendTextToWebElement(monthYearExpiryField, "Month and Year Expiry Field", month);
        sendTextToWebElement(cvcField, "CVC Field", cvcNumber);
        sendTextToWebElement(monthYearExpiryField, "Month and Year Expiry Field", year);
        sendTextToWebElement(zipCodeField, "Zip Code Field", zipCode);
        waitForWebElementTillDisplayedAndClickable(payButton, TIME_TO_WAIT, "Pay Button");
        clickWebElement(payButton, "Pay Button");
        getWebDriver().switchTo().defaultContent();
    }
}
