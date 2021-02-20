package helpers;

import common.SeleniumHelper;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pageobjects.TwitterHomePage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TwitterHomePageHelper
{
    private SeleniumHelper seleniumHelper;
    private TwitterHomePage twitterHomePage;

    public TwitterHomePageHelper(WebDriver driver)
    {
        seleniumHelper = new SeleniumHelper(driver);
        twitterHomePage = new TwitterHomePage(driver);
    }

    public void enterTextIntoNewTweetTextBox(String text)
    {
        seleniumHelper.insertTextIntoTextBox(twitterHomePage.getNewTweetTextBox(), text);
    }

    public void addImageToTweet(File image)
    {
        seleniumHelper.sendKeysToWebElement(twitterHomePage.getNewTweetImageFileInputButton(), image.getAbsolutePath());
    }

    public void clickTweetButton()
    {
        seleniumHelper.waitForElementToBeClickableAndClick(twitterHomePage.getClickTweetButton());
    }

    public int getNumberOfTweets()
    {
        return twitterHomePage.getTweetsList().size();
    }

    public void waitForNumberOfTweetsToMeetExpected(int expectedNumberOfTweets)
    {
        seleniumHelper.waitForNumberOfElementToBe(twitterHomePage.getTweetsListLocator(), expectedNumberOfTweets);
    }

    public boolean isTweetDisplayed()
    {
        return seleniumHelper.isElementDisplayed(twitterHomePage.getTweet());
    }

    public String getTextFromNewestTweet()
    {
        try
        {
            return seleniumHelper.getTextFromElement(twitterHomePage.getTweetText());
        } catch (NoSuchElementException exception)
        {
            return StringUtils.EMPTY;
        }
    }

    public BufferedImage getImageFromTweet() throws IOException
    {
        return ImageIO.read(new URL(seleniumHelper.getAttributeFromElement(twitterHomePage.getTweetImage(), "src")));
    }

    public void clickFirstTweetCaretButton()
    {
        seleniumHelper.waitForElementToBeClickableAndClick(twitterHomePage.getTweetOptionButtonsList().get(0));
    }

    public void clickDeleteTweetButton()
    {
        seleniumHelper.waitForElementToBeClickableAndClick(twitterHomePage.getDeleteTweetButton());
    }
}
