import co.weathershoppers.assignment.pages.WebBasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class MoisturizersTest extends WebBasePage {
    @Test(groups = {"Regression"})
    @Description("Add two moisturizers to your cart. First, select the least expensive moisturizer that contains Aloe. " +
            "For your second moisturizer, select the least expensive moisturizer that contains almond. C" +
            "lick on cart when you are done.")
    public void verifyUIFeaturesOfMoisturizersPage() {
        homePage.clickOnBuyMoisturizersButton();
        moisturizersPage.addLeastExpensiveAloeProductOnCart();
        moisturizersPage.addLeastExpensiveAlmondsProductOnCart();
        moisturizersPage.clickOnCartButton();
        cartPage.verifyURL();
    }
}
