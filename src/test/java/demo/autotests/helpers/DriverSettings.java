package demo.autotests.helpers;

import com.codeborne.selenide.Configuration;
import demo.autotests.config.Project;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {

    public static void configure() {
        Configuration.browser = Project.config.browser();
        Configuration.browserSize = Project.config.browserSize();
        Configuration.baseUrl = EnvironmentSettings.getEnvironmentUrl();

        MutableCapabilities capabilities = new DesiredCapabilities();

        switch (Configuration.browser) {
            case "chrome":
                setChromeOptions(capabilities);
                break;
            case "firefox":
                setFirefoxOptions(capabilities);
                break;
            default:
                Configuration.browserCapabilities = capabilities;
        }

        if (Project.isRemoteWebDriver()) {
            // TODO: check remote browser settings
            capabilities.setCapability("browserName", Configuration.browser);
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = Project.config.remoteDriverUrl();
        }
    }
    public static void setChromeOptions(MutableCapabilities capabilities) {
        Configuration.browserCapabilities = new ChromeOptions()
                .addArguments("--no-sandbox")
                .addArguments("--disable-infobars")
                .addArguments("--disable-popup-blocking")
                .addArguments("--disable-notifications")
                .addArguments("--lang=en-US")
                .setExperimentalOption("excludeSwitches", new String[]{"enable-automation"})
                .merge(capabilities);
    }
    public static void setFirefoxOptions(MutableCapabilities capabilities) {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", "en-US");
        Configuration.browserCapabilities = new FirefoxOptions()
                .setProfile(profile)
                .merge(capabilities);
    }
}