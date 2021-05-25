import base.BaseTest;
import org.testng.annotations.Test;
import pageObject.CreatePage;

import static org.testng.Assert.assertTrue;


public class CreateTest extends BaseTest {

    @Test
    public void uploadAndDownload(){
        CreatePage createPage = new CreatePage();
        createPage.open();
        createPage.uploadPhoto();
        createPage.downloadPhoto();
        createPage.finalClick();
        assertTrue(createPage.popupDisplayed(), "Download failed!");

    }
}
