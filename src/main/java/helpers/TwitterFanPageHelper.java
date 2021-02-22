package helpers;

import common.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import pageobjects.TwitterFanPage;

public class TwitterFanPageHelper
{
    private final SeleniumHelper seleniumHelper;
    private final TwitterFanPage twitterFanPage;

    public TwitterFanPageHelper(WebDriver driver)
    {
        seleniumHelper = new SeleniumHelper(driver);
        twitterFanPage = new TwitterFanPage(driver);
    }

    public boolean isFanPageMessageDmDisplayed()
    {
        return seleniumHelper.isElementDisplayed(twitterFanPage.getSendDmFromProfileButton());
    }

    public void clickFollowButton()
    {
        seleniumHelper.waitForElementToBeClickableAndClick(twitterFanPage.getFollowButton());
    }

    public boolean isUnFollowButtonDisplayed()
    {
        return seleniumHelper.isElementDisplayed(twitterFanPage.getUnFollowButton());
    }

    public boolean isFollowButtonDisplayed()
    {
        return seleniumHelper.isElementDisplayed(twitterFanPage.getFollowButton());
    }
}
