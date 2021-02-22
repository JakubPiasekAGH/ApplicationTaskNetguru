package helpers;

import common.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import pageobjects.ConfirmationDialog;
import pageobjects.TwitterFollowingPage;

public class TwitterFollowingPageHelper
{
    private final SeleniumHelper seleniumHelper;
    private final TwitterFollowingPage twitterFollowingPage;
    private final ConfirmationDialog confirmationDialog;

    public TwitterFollowingPageHelper(WebDriver driver)
    {
        seleniumHelper = new SeleniumHelper(driver);
        twitterFollowingPage = new TwitterFollowingPage(driver);
        confirmationDialog = new ConfirmationDialog(driver);
    }

    public void unFollowAllSites()
    {
        twitterFollowingPage.getUnFollowButtonsList().forEach(e -> {
            seleniumHelper.waitForElementToBeClickableAndClick(e);
            seleniumHelper.waitForElementToBeClickableAndClick(confirmationDialog.getConfirmActionButton());
        });
    }

    public int getNumberOfFollowingSites()
    {
        return twitterFollowingPage.getUnFollowButtonsList().size();
    }
}
