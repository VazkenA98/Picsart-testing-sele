package pageObject;

import enums.EditorTypes;
import helper.WaitHelper;
import org.openqa.selenium.By;
import pageObject.base.BasePage;
import pageObject.editor.EditorPage;
import pageObject.header.NavigationHeader;

public class CreatePage extends BasePage {

    private final By instaStoryButton = By.cssSelector("[data-test='insta-story']");

    private By uploadButtonLocation = By.cssSelector("[class*='uploadButton'] input");
    private By downloadButtonLocation = By.id("download-button");
    private By finalDownloadLocation = By.cssSelector("[data-test='downloaded-button']");
    private By popupLocation = By.cssSelector("[class*='ReactModal__Content']");

    private String url = "/create";


    public CreatePage(){

    }

    public CreatePage open(){
        open(getUrl());
        return this;
    }
    @Override
    public String getUrl() {
        return BASE_URL.concat(url);
    }

    public EditorPage clickOnInstagramStoryLink() {
        clickAndSwitchToNextTab(instaStoryButton);
        return new EditorPage(EditorTypes.INSTA_STORY_TEMP);
    }

    public NavigationHeader getNavigationHeader(){
        return new NavigationHeader();
    }

    public void uploadPhoto() {
        WaitHelper.waitUntilElementIsVisible(uploadButtonLocation);
        type(uploadButtonLocation, "/Users/vazkenabdulian/Downloads/Project_7ee74cbfbb789be693d7305929cbd289.jpg");
    }

    public void downloadPhoto() {
        WaitHelper.waitUntilElementIsVisible(downloadButtonLocation);
        click(downloadButtonLocation);
    }

    public void finalClick() {
        WaitHelper.waitUntilElementIsVisible(finalDownloadLocation);
        click(finalDownloadLocation);
    }
    public boolean popupDisplayed() {
        isDisplayed(popupLocation);
        return true;
    }

}
