package pageObject;

import helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.base.BasePage;

import java.util.ArrayList;
import java.util.List;


public class ImageBrowserPage extends BasePage {

    private final By likeIconLocation = By.cssSelector(".actions-section .notifier-hover-toggle .like");
    private final By descriptionLocationHashtagsList = By.cssSelector(".description a");
    private final By likesCountIconLocation = By.cssSelector(".notifier-hover-toggle .js-likes-count");

    private String imageId;
    public ImageBrowserPage() {
    }

    public ImageBrowserPage(String imageID) {
        this.imageId = imageID;
        System.out.println("Opening url -> " + getUrl());
    }

    public ImageBrowserPage open(){
        open(getUrl());
        return this;
    }

    @Override
    public String getUrl() {
        String query = imageId == null ? BASE_URL : BASE_URL + "/i/" + imageId;
        return query;
    }

    public void clickOnLikeIcon() {
        WaitHelper.waitUntilElementIsVisible(likeIconLocation);
        click(likeIconLocation);
    }
    public ArrayList<String> getHashtagsList() {
        WaitHelper.waitUntilElementIsVisible(descriptionLocationHashtagsList);
        List<WebElement> hashtagsElements = findAll(descriptionLocationHashtagsList);
        ArrayList<String> hashtagsList = new ArrayList<>();
        for (WebElement hashtagElement : hashtagsElements) {
            hashtagsList.add(hashtagElement.getText());
        }
        return hashtagsList;
    }

    public boolean isHashtagAdded(String hashtag){
        return getHashtagsList().contains("#"+hashtag);
    }

    public boolean isLikedOld() {
        WaitHelper.waitUntilElementIsVisible(likeIconLocation);
        return find(likeIconLocation).getAttribute("class").contains("active");
    }

    public boolean isLiked() {
        WaitHelper.waitUntilElementIsVisible(likesCountIconLocation);
        return find(likesCountIconLocation).getText().equals("1");
    }

}