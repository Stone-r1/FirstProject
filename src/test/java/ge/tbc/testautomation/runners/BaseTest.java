package ge.tbc.testautomation.runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Map;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "resolution", "mobileDevice"})
    protected void setUp(
            @Optional("firefox") String browser,
            @Optional("1920x1080") String resolution,
            @Optional("") String mobileDevice) {

        Configuration.timeout = 10000;

        if (!mobileDevice.isEmpty() && browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            Map<String, String> mobileConfig = Map.of("deviceName", mobileDevice);
            chromeOptions.setExperimentalOption("mobileEmulation", mobileConfig);
            Configuration.browserCapabilities = chromeOptions;
            driver = new ChromeDriver(chromeOptions);
        } else {
            Configuration.browserSize = resolution;

            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
        }

        WebDriverRunner.setWebDriver(driver);
        openTestPage();
    }

    // each derived class must implement this method.
    protected abstract void openTestPage();

    @AfterClass
    protected void tearDown() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.getWebDriver().quit();
        }
    }
}
