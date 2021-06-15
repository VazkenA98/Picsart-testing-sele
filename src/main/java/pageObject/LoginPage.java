package pageObject;

import enums.EditorTypes;
import helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.base.BasePage;
import pageObject.editor.EditorPage;


public class LoginPage extends BasePage<LoginPage> {

    private final By usernameFieldLocation = By.name("username");
    private final By passwordFieldLocation = By.name("password");
    private final By loginButtonLocation = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private final By signInButtonLocation = By.cssSelector(".pa-uiLib-authentication-btn.primary");
    private final By avatarLocation = By.cssSelector(".pa-uiLib-headerProfileInfo-avatar");

    public LoginPage () {
        open(getUrl()+"/create");
    }


    @Override
    public String getUrl() {
        return BASE_URL;
    }

    public void clickLoginButton() {
        click(loginButtonLocation);
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameFieldLocation));
    }

    public void typeUsername(String username) {
        type(usernameFieldLocation, username);
    }

    public void typePassword(String password) {
        type(passwordFieldLocation,password);
    }

    public void clickSignInButton() {
        click(signInButtonLocation);
    }

    public boolean isAvatarDisplayed() {
        return find(avatarLocation).isDisplayed();
    }

    public boolean isUserLoggedIn() {
        WebElement avatarIcon = WaitHelper.waitUntilElementIsVisible(avatarLocation);
        return avatarIcon.isDisplayed();
    }

}
