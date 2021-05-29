
import org.testng.annotations.Test;
import pageObject.CreatePage;
import pageObject.editor.EditorPage;
import user.VerifiedUserTest;

import static config.DriverSetup.getDriver;
import static org.testng.Assert.assertEquals;


public class EditorTest extends VerifiedUserTest {

    @Test
    public void editorPageCheck() {
        CreatePage createPage = new CreatePage().open();
        login();

        EditorPage editorPage = createPage.open().clickOnInstagramStoryLink();
        assertEquals(editorPage.getUrl(),getDriver().getCurrentUrl(),"Did not navigate to [Editor Page] by clicking [instaStoryButton]");
        assertEquals(editorPage.getSlideBarElementsSize(),7,"Slide bar elements are not present in [Editor Page]");

        editorPage = editorPage.clickFitButton();
        assertEquals(editorPage.getFitButtonItemsSize(),28,"Items elements are not present in [Editor Page] by clicking [Fit Button]");
    }

    @Test
    public void facebookAdScrollCheck(){
        CreatePage createPage = new CreatePage().open();
        login();
        EditorPage editorPage = createPage.clickOnFacebookAdLink().open();
        editorPage = editorPage.clickFitButtonByJS();
        assertEquals(editorPage.getUrl(),getDriver().getCurrentUrl(),"Did not navigate to [Editor Page] by clicking [FacebookAdLink]");
        assertEquals(editorPage.getFitButtonItemsSize(),28,"Items elements are not present in [Editor Page] by clicking [Fit Button]");
    }
}
