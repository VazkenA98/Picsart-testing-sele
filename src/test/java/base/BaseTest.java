package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static config.DriverSetup.getDriver;

public class BaseTest {

    @BeforeMethod
    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "/Users/ss/dev/chromedriver");
//        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}
