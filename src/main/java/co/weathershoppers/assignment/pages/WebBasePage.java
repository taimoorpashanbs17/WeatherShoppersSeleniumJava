package co.weathershoppers.assignment.pages;
import co.weathershoppers.assignment.WeatherShoppersTestBase;

public class WebBasePage extends WeatherShoppersTestBase {
    public static HomePage homePage;
    public static CartPage cartPage;
    public static MoisturizersPage moisturizersPage;
    public static SunScreenPage sunScreenPage;
    public static QXF2Page qxf2Page;
    public static PaymentConfirmationPage paymentConfirmationPage;

    public static void initAllWebPages(){
        homePage = new HomePage(getWebDriver());
        cartPage = new CartPage(getWebDriver());
        moisturizersPage = new MoisturizersPage(getWebDriver());
        sunScreenPage = new SunScreenPage(getWebDriver());
        qxf2Page = new QXF2Page(getWebDriver());
        paymentConfirmationPage = new PaymentConfirmationPage(getWebDriver());
    }
}
