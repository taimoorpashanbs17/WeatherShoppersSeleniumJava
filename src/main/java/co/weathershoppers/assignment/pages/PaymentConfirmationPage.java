package co.weathershoppers.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static co.weathershoppers.assignment.constants.URLConstants.BASE_URL;
import static co.weathershoppers.assignment.constants.URLConstants.PAYMENT_CONFIRMATION_PATH;

import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.TIME_TO_WAIT;

import static co.weathershoppers.assignment.utils.Waits.waitTillURLToBe;
import static co.weathershoppers.assignment.utils.Waits.waitForWebElement;

import static co.weathershoppers.assignment.utils.AssertUtils.verifyURLEquals;
import static co.weathershoppers.assignment.utils.AssertUtils.verifyWebElementTextIs;

public class PaymentConfirmationPage {
    public PaymentConfirmationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement paymentStatusHeader;

    @FindBy(xpath = "//p[@class='text-justify']")
    WebElement paymentMessage;

    public void verifyURL(){
        String url = BASE_URL + PAYMENT_CONFIRMATION_PATH;
        waitTillURLToBe(url, TIME_TO_WAIT);
        verifyURLEquals(url);
    }

    public void verifyPaymentStatus(String paymentMessage){
        waitForWebElement(paymentStatusHeader, TIME_TO_WAIT);
        verifyWebElementTextIs(paymentStatusHeader, "Payment Status Header Text", paymentMessage);
    }

    public void verifyPaymentMessage(String paymentTextMessage){
        waitForWebElement(paymentMessage, TIME_TO_WAIT);
        verifyWebElementTextIs(paymentMessage, "Payment Message Text", paymentTextMessage);
    }

}
