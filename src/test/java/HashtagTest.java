import base.BaseTest;
import helper.ApiHelper;
import org.testng.annotations.Test;
import pageObject.ImageBrowserPage;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class HashtagTest extends BaseTest {

    private static File imageFile =  new File("/Users/vazkenabdulian/Downloads/Web_Photo_Editor.jpg");

    @Test
    public void addingHashtagsToExistingImage() {
        String uploadedImageID = ApiHelper.uploadPhoto(userKey, imageFile).get("id").getAsString();
        ApiHelper.addHashtag(userKey, uploadedImageID, "test_hashtag");

        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(uploadedImageID).open();

        assertTrue(imageBrowserPage.isHashtagAdded("test_hashtag"), "Hashtags were not being added successfully!");
        ApiHelper.removePhoto(uploadedImageID, userKey);
    }

    @Test
    public void likePhoto() {
        String uploadedImageID = ApiHelper.uploadPhoto(userKey, imageFile).get("id").getAsString();
        ApiHelper.likePhoto(userKey, uploadedImageID);
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(uploadedImageID);
        assertTrue(imageBrowserPage.isLiked(), "Image wasn't liked!");

    }

}
