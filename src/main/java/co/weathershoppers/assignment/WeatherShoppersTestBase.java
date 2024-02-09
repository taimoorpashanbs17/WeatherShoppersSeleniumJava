package co.weathershoppers.assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static co.weathershoppers.assignment.constants.URLConstants.BASE_URL;
import static co.weathershoppers.assignment.pages.WebBasePage.initAllWebPages;

import static co.weathershoppers.assignment.helpers.Log4jHelper.createPropertyFile;
import static co.weathershoppers.assignment.helpers.Log4jHelper.log;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WeatherShoppersTestBase {
    public static WebDriver getWebDriver() {
        return driver.get();
    }

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static String headlessProperty = System.getProperty("headless", "no");

    public static String browser = System.getProperty("browser", "chrome");



    public static void createLocalWebDriver() throws IOException {
        log().info("Starting Testing on "+browser+" browser");
        if (browser.startsWith("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (Objects.equals(headlessProperty, "yes")) {
                firefoxOptions.addArguments("--headless");
            }
            driver.set(new FirefoxDriver(firefoxOptions));
        } if (browser.startsWith("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            Map<String, Object> preferences = new HashMap<>();
            preferences.put("profile.default_content_settings.popups", 0);
            chromeOptions.setExperimentalOption("prefs", preferences);
            if (Objects.equals(headlessProperty, "yes")) {
                chromeOptions.addArguments("--headless");
            }
            driver.set(new ChromeDriver(chromeOptions));
        }  if (browser.startsWith("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions();
            if (Objects.equals(headlessProperty, "yes")) {
                edgeOptions.addArguments("--headless");
            }
            driver.set(new EdgeDriver(edgeOptions));
        } if (browser.startsWith("safari")) {
            WebDriverManager.safaridriver().setup();
            SafariOptions safariOptions = new SafariOptions();
            if (Objects.equals(headlessProperty, "yes")) {
                safariOptions.setCapability("--headless", true);
            }
            driver.set(new SafariDriver(safariOptions));
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
        log().info("Browser Closed");
    }

}



