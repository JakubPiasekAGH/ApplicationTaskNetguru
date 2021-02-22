import helpers.TwitterCommonPartsHelper;
import helpers.TwitterFanPageHelper;
import helpers.TwitterFollowingPageHelper;
import helpers.TwitterProfilePageHelper;
import org.junit.jupiter.api.*;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwitterFollowingTest extends TwitterTestBase
{
    private TwitterCommonPartsHelper twitterCommonPartsHelper;
    private TwitterProfilePageHelper twitterProfilePageHelper;
    private TwitterFollowingPageHelper twitterFollowingPageHelper;
    private TwitterFanPageHelper twitterFanPageHelper;
    private static final String WHOLESOME_MEMES = "WholesomeMemes";

    @PostConstruct
    void initTwitterFollowingTest()
    {
        twitterCommonPartsHelper = new TwitterCommonPartsHelper(driver);
        twitterFanPageHelper = new TwitterFanPageHelper(driver);
        twitterProfilePageHelper = new TwitterProfilePageHelper(driver);
        twitterFollowingPageHelper = new TwitterFollowingPageHelper(driver);
    }

    @BeforeAll
    void logInToTweeterAsPostingUserAndCleanAllFollowedSites()
    {
        twitterLoginPageHelper.logInToTwitterWithCredentials(propertiesReader.getFollowingUserName(),
                propertiesReader.getFollowingUserPassword());
        twitterCommonPartsHelper.clickProfileButton();
        twitterProfilePageHelper.clickFollowingSitesLabel();
        twitterFollowingPageHelper.unFollowAllSites();
        seleniumHelper.refreshPage();
    }

    @Order(0)
    @Test
    void verifyIfUserDoNotFollowAnySites()
    {
        twitterCommonPartsHelper.clickProfileButton();
        var message = "Clean up went wrong and not all conditions are meet to execute tests";
        assertEquals(0, twitterProfilePageHelper.getNumberOfFollowingSites(), message);
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class TwitterFollowingTestWithPreconditionsSet
    {
        @Order(1)
        @Test
        void searchForFanPageAndFollow() throws InterruptedException
        {
            twitterCommonPartsHelper.searchForTweeterPage(WHOLESOME_MEMES);
            twitterCommonPartsHelper.clickFirstSearchResultWithRepeatableAction();
            twitterFanPageHelper.clickFollowButton();
            var message = "Following site went wrong - un-follow button is NOT displayed";
            assertTrue(twitterFanPageHelper.isUnFollowButtonDisplayed(), message);
        }

        @Order(2)
        @Test
        void verifyIfFollowedSiteAppearsInYourProfile()
        {
            twitterCommonPartsHelper.clickProfileButton();
            var message = "Profile 'Following' label does not have exactly 1 following site as expected";
            assertEquals(1, twitterProfilePageHelper.getNumberOfFollowingSites(), message);
        }

        @Order(3)
        @Test
        void verifyFollowedSiteList()
        {
            twitterProfilePageHelper.clickFollowingSitesLabel();
            seleniumHelper.refreshPage();
            var message = "Following site list should contain exactly one site";
            assertEquals(1, twitterFollowingPageHelper.getNumberOfFollowingSites(), message);
        }

        @Order(4)
        @Test
        void unFollowFanPageAndVerifyWithFollowingList()
        {
            twitterFollowingPageHelper.unFollowAllSites();
            seleniumHelper.refreshPage();
            var message = "Following site list should be empty";
            assertEquals(0, twitterFollowingPageHelper.getNumberOfFollowingSites(), message);
        }

        @Order(5)
        @Test
        void verifyIfUnFollowedSiteDoNotAppearsInYourProfile()
        {
            twitterCommonPartsHelper.clickProfileButton();
            var message = "Profile 'Following' label does not have exactly 0 following site as expected";
            assertEquals(0, twitterProfilePageHelper.getNumberOfFollowingSites(), message);
        }

        @Order(6)
        @Test
        void verifyIfSiteIsUnFollowed() throws InterruptedException
        {
            twitterCommonPartsHelper.searchForTweeterPage(WHOLESOME_MEMES);
            twitterCommonPartsHelper.clickFirstSearchResultWithRepeatableAction();
            var message = "Following site went wrong - un-follow button is NOT displayed";
            assertTrue(twitterFanPageHelper.isFollowButtonDisplayed(), message);
        }
    }
}