package co.weathershoppers.assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static co.weathershoppers.assignment.constants.URLConstants.BASE_URL;
import static co.weathershoppers.assignment.pages.WebBasePage.initAllWebPages;

import static co.weathershoppers.assignment.helpers.Log4jHelper.createPropertyFile;
import static co.weathershoppers.assignment.helpers.Log4jHelper.log;

import static co.weathershoppers.assignment.helpers.PathHelper.getFile;

import static co.weathershoppers.assignment.helpers.FileHelper.getPropertiesFileProperty;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WeatherShoppersTestBase {
    public static WebDriver getWebDriver() {
        return driver.get();
    }

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static String browserPropertiesFilePath = getFile("browser.properties");
    public static String BROWSER_NAME = getPropertiesFileProperty(browserPropertiesFilePath).getProperty("app.browser");

    public static String HEADLESS = getPropertiesFileProperty(browserPropertiesFilePath).getProperty("app.headless");


    public static void createLocalWebDriver() {
        log().info("Starting Testing on "+BROWSER_NAME+" browser");
        if (BROWSER_NAME.startsWith("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (Objects.equals(HEADLESS, "true")) {
                firefoxOptions.addArguments("--headless");
            }
            driver.set(new FirefoxDriver(firefoxOptions));
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            Map<String, Object> preferences = new HashMap<>();
            preferences.put("profile.default_content_settings.popups", 0);
            chromeOptions.setExperimentalOption("prefs", preferences);
            if (Objects.equals(HEADLESS, "true")){
                chromeOptions.addArguments("--headless");
            }
            driver.set(new ChromeDriver(chromeOptions));
        }
        driver.get().get(BASE_URL);
        driver.get().manage().window().maximize();
    }

    public static void startWebBrowser() throws IOException {
        createPropertyFile();
        createLocalWebDriver();
        initAllWebPages();
        getWebDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        startWebBrowser();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDown() throws InterruptedException {
        Thread.sleep(2000);
        getWebDriver().close();
    }

}



