package pageObject.header;

import helper.WaitHelper;
import org.openqa.selenium.By;
import pageObject.Challenges.ChallengesPage;
import pageObject.base.BasePage;


public class NavigationHeader extends BasePage {

    private final By headerNavigationButtons = By.cssSelector(".pa-uiLib-headerNavigation-url");
    private final By challengesHeaderLink = By.cssSelector("[data-test='subNavigation-groupList'] a[href='/challenges']");

    public NavigationHeader(){

    }

    @Override
    public String getUrl() {
        return null;
    }

    public ChallengesPage clickOnChallengesHeaderLink(){
        WaitHelper.waitUntilElementIsVisible(headerNavigationButtons);
        hoverDiscover();
        click(challengesHeaderLink);
        return new ChallengesPage();
    }

    public NavigationHeader hoverDiscover() {
        WaitHelper.waitUntilElementIsVisible(headerNavigationButtons);
        hoverByText(headerNavigationButtons, "Discover");
        return this;
    }
}
