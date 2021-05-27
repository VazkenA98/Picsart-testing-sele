package base;

import helper.ApiHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Cookie;
import pageObject.LoginPage;

import static config.DriverSetup.getDriver;

public class BaseTest {

    protected String userKey;

    @BeforeMethod
    public void setup() {
        userKey = ApiHelper.createUser().get("response").getAsJsonObject().get("key").getAsString();
        new LoginPage();
        getDriver().manage().window().maximize();
        Cookie cookie = new Cookie("user_key", userKey);
        getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));
        getDriver().manage().addCookie(new Cookie("we-editor-photo-first-open", "true"));
        getDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();
    }

    @AfterMethod
    public void tearDown() {
        ApiHelper.removeUser(userKey);
        getDriver().navigate().refresh();
        System.out.println("Test ends! ");
        getDriver().quit();

    }

}
