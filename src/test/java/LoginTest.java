import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import pageObject.LoginPage;

import static org.testng.Assert.assertTrue;
import static config.DriverSetup.getDriver;


public class LoginTest {


    @Test
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginButton();
        loginPage.typeUsername("vazkena98");
        loginPage.typePassword("");
        loginPage.clickSignInButton();

        assertTrue(loginPage.isUserLoggedIn(), "User is not logged in!");
    }

    @Test
    public void loginWithKey() {
        LoginPage loginPage = new LoginPage();

        Cookie cookie = new Cookie("user_key", "d02e1fab-8630-4f25-a106-9969ab867447");
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();

        assertTrue(loginPage.isUserLoggedIn(), "User is not logged in!");
    }
}
