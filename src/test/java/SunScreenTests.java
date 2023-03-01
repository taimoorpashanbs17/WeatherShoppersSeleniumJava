import co.weathershoppers.assignment.pages.WebBasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SunScreenTests extends WebBasePage {
    @Test(groups = {"Regression"})
    @Description("Add two sunscreens to your cart. First, select the least expensive sunscreen that is SPF-50. " +
            "For your second sunscreen, select the least expensive sunscreen that is SPF-30. " +
            "Click on the cart when you are done.")
    public void testSunScreenAddLeastExpensiveProductOnCartFunctionality() {
        homePage.clickOnBuySunScreensButton();
        sunScreenPage.addLeastExpensiveSPF50ProductOnCart();
        sunScreenPage.addLeastExpensiveSPF30ProductOnCart();
        sunScreenPage.clickOnCartButton();
        cartPage.verifyURL();
    }

}
