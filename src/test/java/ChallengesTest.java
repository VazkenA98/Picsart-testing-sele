import org.testng.annotations.Test;
import pageObject.Challenges.ChallengesPage;
import pageObject.CreatePage;
import user.VerifiedUserTest;

import static config.DriverSetup.getDriver;
import static org.testng.Assert.assertEquals;

public class ChallengesTest extends VerifiedUserTest {

    @Test
    public void checkQRForChallenges(){
        CreatePage createPage =  new CreatePage().open();
        login();

        ChallengesPage challengesPage = createPage.getNavigationHeader().clickOnChallengesHeaderLink().open();
        assertEquals(challengesPage.getUrl(),getDriver().getCurrentUrl(),"Did not navigate to [Challenges Page] by clicking [ChallengesHeaderLink]");

    }
}
