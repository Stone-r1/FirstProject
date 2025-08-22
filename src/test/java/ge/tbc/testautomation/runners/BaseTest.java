package ge.tbc.testautomation.runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
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
        Configuration.browserSize = resolution;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", Map.of(
                    "profile.default_content_setting_values.geolocation", 2,
                    "profile.default_content_setting_values.notifications", 2
            ));

            Configuration.browserCapabilities = chromeOptions;
            driver = new ChromeDriver(chromeOptions);

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            FirefoxOptions firefoxOptions = new FirefoxOptions();

            profile.setPreference("geo.enabled", false);
            profile.setPreference("permissions.default.desktop-notification", 2);
            firefoxOptions.setProfile(profile);

            Configuration.browserCapabilities = firefoxOptions;
            driver = new FirefoxDriver(firefoxOptions);
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
