import base.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import pageObject.editor.EditorPage;

import static config.DriverSetup.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EditorTest extends BaseTest {

    @Test
    public void editorPageCheck() {
        LoginPage loginPage = new LoginPage();
        Cookie cookie = new Cookie("user_key", "d02e1fab-8630-4f25-a106-9969ab867447");
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();
        assertTrue(loginPage.isUserLoggedIn(), "User is not logged in!");

        EditorPage editorPage = loginPage.clickOnInstagramStoryLink();
        assertEquals(editorPage.getUrl(),getDriver().getCurrentUrl(),"Did not navigate to [Editor Page] by clicking [instaStoryButton]");
        assertEquals(editorPage.getSlideBarElementsSize(),7,"Slide bar elements are not present in [Editor Page]");

    }
}
