import co.weathershoppers.assignment.pages.WebBasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.io.IOException;

import static co.weathershoppers.assignment.constants.WeatherShoppersTextConstants.PAYMENT_SUCCESS_TEXT;
import static co.weathershoppers.assignment.constants.WeatherShoppersTextConstants.PAYMENT_SUCCESS_MESSAGE_TEXT;

import static co.weathershoppers.assignment.helpers.ExcelHelpers.getValueFromExcelSheet;

public class CartTests extends WebBasePage {
    public String getUserValues(int rowNumber) throws IOException {
        return getValueFromExcelSheet("WeatherShopper.xlsx", "UserInformation", rowNumber);

    }
    @Test(groups = {"Regression"})
    @Description("Verify that the shopping cart looks correct. Then, fill out your payment details and submit the " +
            "form. You can Google for 'Stripe test card numbers' to use valid cards. " +
            "Note: The payment screen will error 5% of the time by design")
    public void testFillAndSubmitPaymentForm() throws IOException {
        String emailAddress = getUserValues(2);
        String cardNumber = getUserValues(3);
        String month = getUserValues(4);
        String year = getUserValues(5);
        String cvcNumber = getUserValues(6);
        String zipCode = getUserValues(7);
        homePage.clickOnBuySunScreensButton();
        sunScreenPage.clickOnCartButton();
        cartPage.clickOnPayWithCard();
        cartPage.enterCreditCardInformation(emailAddress, cardNumber, month,
                year, cvcNumber, zipCode);
        paymentConfirmationPage.verifyURL();
        paymentConfirmationPage.verifyPaymentStatus(PAYMENT_SUCCESS_TEXT);
        paymentConfirmationPage.verifyPaymentMessage(PAYMENT_SUCCESS_MESSAGE_TEXT);
    }
}
