package pageObject.header;

import helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import pageObject.base.BasePage;

import static config.DriverSetup.getDriver;


public class NavigationHeader extends BasePage<NavigationHeader> {

    private final By headerNavigationButtons = By.cssSelector(".pa-uiLib-headerNavigation-url");
    private final By challengesHeaderLink = By.cssSelector("[data-test='subNavigation-groupList'] a[href='/challenges']");

    public NavigationHeader(){
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    public String getUrl() {
        return null;
    }


    public NavigationHeader hoverDiscover() {
        WaitHelper.waitUntilElementIsVisible(headerNavigationButtons);
        hoverByText(headerNavigationButtons, "Discover");
        return this;
    }
}
