package pageObject;

import helper.WaitHelper;
import org.openqa.selenium.By;
import pageObject.base.BasePage;



public class ImageBrowserPage extends BasePage {

    private final By likeIconLocation = By.cssSelector(".actions-section .notifier-hover-toggle .like");

    private String imageId;
    private String url = "/create/editor";
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
        String query = imageId == null ? url : url + "/i/" + imageId;
        return BASE_URL.concat(query);
    }

    public void clickOnLikeIcon() {
        WaitHelper.waitUntilElementIsVisible(likeIconLocation);
        click(likeIconLocation);
    }

    public boolean isImageLiked() {
        return find(likeIconLocation).getAttribute("class").contains("active");
    }
}