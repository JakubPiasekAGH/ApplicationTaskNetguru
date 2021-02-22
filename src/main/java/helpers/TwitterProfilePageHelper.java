package helpers;

import common.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import pageobjects.TwitterProfilePage;

import java.util.regex.Pattern;

public class TwitterProfilePageHelper
{
    private final SeleniumHelper seleniumHelper;
    private final TwitterProfilePage twitterProfilePage;

    public TwitterProfilePageHelper(WebDriver driver)
    {
        seleniumHelper = new SeleniumHelper(driver);
        twitterProfilePage = new TwitterProfilePage(driver);
    }

    public void clickFollowingSitesLabel()
    {
        seleniumHelper.waitForElementToBeClickableAndClick(twitterProfilePage.getFollowingLabel());
    }

    /**
     * Returns number of following sites
     *
     * @return - int value
     */
    public int getNumberOfFollowingSites()
    {
        var patternString = "\\d";
        var pattern = Pattern.compile(patternString);
        var matcher = pattern.matcher(seleniumHelper.getTextFromElement(twitterProfilePage.getFollowingLabel()));
        if (matcher.find())
            return Integer.parseInt(matcher.group());
        return -1;
    }
}
