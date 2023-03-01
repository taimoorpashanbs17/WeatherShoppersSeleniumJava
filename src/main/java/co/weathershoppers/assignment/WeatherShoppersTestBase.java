package co.weathershoppers.assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static co.weathershoppers.assignment.constants.URLConstants.BASE_URL;
import static co.weathershoppers.assignment.pages.WebBasePage.initAllWebPages;

import static co.weathershoppers.assignment.constants.WeatherShoppersConstants.HEADLESS;


import java.util.HashMap;
import java.util.Map;

public class WeatherShoppersTestBase {
    public static WebDriver getWebDriver() {
        return driver.get();
    }

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createLocalWebDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        Map<String, Object> preferences = new HashMap<>();
        preferences.put("profile.default_content_settings.popups", 0);
        chromeOptions.setExperimentalOption("prefs", preferences);
        driver.set(new ChromeDriver(chromeOptions));
        driver.get().get(BASE_URL);
        driver.get().manage().window().maximize();
    }

    public static void startWebBrowser() {

        createLocalWebDriver();
        initAllWebPages();
        getWebDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        startWebBrowser();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDown() throws InterruptedException {
        Thread.sleep(2000);
        getWebDriver().close();
    }

}



