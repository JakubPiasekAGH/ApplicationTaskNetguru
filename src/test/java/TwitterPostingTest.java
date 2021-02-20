import common.FileHelper;
import common.ImageComparisonHelper;
import helpers.DeleteTweetDialogHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.*;

class TwitterPostingTest extends TwitterTestBase
{
    private static final String TWEET = "#rel What an entertaining mem :D :D added:" + System.currentTimeMillis();
    private static final String MEME = "meme.jpg";
    private DeleteTweetDialogHelper deleteTweetDialogHelper;

    @PostConstruct
    void initTwitterPostingTest()
    {
        deleteTweetDialogHelper = new DeleteTweetDialogHelper(driver);
    }

    @BeforeAll
    void logInToTweeterAsPostingUser()
    {
        twitterLoginPageHelper.logInToTwitterWithCredentials(propertiesReader.getPostingUserName(),
                propertiesReader.getPostingUserPassword());
    }

    @Order(0)
    @Test
    void publicTweetWithPicture()
    {
        twitterHomePageHelper.enterTextIntoNewTweetTextBox(TWEET);
        twitterHomePageHelper.addImageToTweet(FileHelper.getFileFromResourcesByName(MEME));
        var numberOfTweets = twitterHomePageHelper.getNumberOfTweets();
        twitterHomePageHelper.clickTweetButton();
        twitterHomePageHelper.waitForNumberOfTweetsToMeetExpected(numberOfTweets + 1);
        var tweetMessage = "Tweet was not displayed at all on your page";
        var textMessage = "Tweet text was not matching expected: " + TWEET;
        var imageMessage = "Image does not meet expected";
        assertAll(() -> assertTrue(twitterHomePageHelper.isTweetDisplayed(), tweetMessage),
                () -> assertEquals(TWEET, twitterHomePageHelper.getTextFromNewestTweet(), textMessage),
                () -> assertEquals(1, ImageComparisonHelper.compareImage(twitterHomePageHelper.getImageFromTweet(),
                        FileHelper.getImageFromResources(MEME)), imageMessage));
    }

    @Order(1)
    @Test
    void deleteTweetWithPicture()
    {
        var numberOfTweets = twitterHomePageHelper.getNumberOfTweets();
        twitterHomePageHelper.clickFirstTweetCaretButton();
        twitterHomePageHelper.clickDeleteTweetButton();
        deleteTweetDialogHelper.clickDeleteTweetButton();
        twitterHomePageHelper.waitForNumberOfTweetsToMeetExpected(numberOfTweets - 1);
        var tweetMessage = "Number of tweets on home page was not decremented after removing tweet";
        var textMessage = "Newest tweet text equal expected -> tweet was NOT removed";
        assertAll(() -> assertEquals(numberOfTweets - 1, twitterHomePageHelper.getNumberOfTweets(), tweetMessage),
                () -> assertNotEquals(TWEET, twitterHomePageHelper.getTextFromNewestTweet(), textMessage));
    }
}
