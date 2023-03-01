import co.weathershoppers.assignment.pages.WebBasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static co.weathershoppers.assignment.constants.WeatherShoppersTextConstants.PAYMENT_SUCCESS_TEXT;
import static co.weathershoppers.assignment.constants.WeatherShoppersTextConstants.PAYMENT_SUCCESS_MESSAGE_TEXT;

import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.EMAIL;
import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.CARD_NUMBER;
import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.MONTH;
import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.YEAR;
import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.CVC_NUMBER;
import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.ZIP_CODE;

public class CartTests extends WebBasePage {
    @Test(groups = {"Regression"})
    @Description("Verify that the shopping cart looks correct. Then, fill out your payment details and submit the " +
            "form. You can Google for 'Stripe test card numbers' to use valid cards. " +
            "Note: The payment screen will error 5% of the time by design")
    public void testFillAndSubmitPaymentForm() {
        homePage.clickOnBuySunScreensButton();
        sunScreenPage.clickOnCartButton();
        cartPage.clickOnPayWithCard();
        cartPage.enterCreditCardInformation(EMAIL, String.valueOf(CARD_NUMBER), String.valueOf(MONTH),
                String.valueOf(YEAR), String.valueOf(CVC_NUMBER), String.valueOf(ZIP_CODE));
        paymentConfirmationPage.verifyURL();
        paymentConfirmationPage.verifyPaymentStatus(PAYMENT_SUCCESS_TEXT);
        paymentConfirmationPage.verifyPaymentMessage(PAYMENT_SUCCESS_MESSAGE_TEXT);
    }
}
