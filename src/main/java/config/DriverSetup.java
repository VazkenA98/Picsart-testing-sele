package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.base.BasePage;

public class DriverSetup {
    private static WebDriver driver;
    private static final String BROWSER = System.getProperty("selenium.browser", "chrome");

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        switch (BROWSER) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        "src/test/resources/chromedriver");
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver",
                        "./src/main/resources/drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
        }
        assert driver != null;
        driver.get("https://name.am/");
        BasePage.LOGGER.info("Initialising to " + getDriver().getCurrentUrl());
        return driver;
    }


    public static void quit() {
        getDriver().quit();
        driver = null;
    }

}
