package helpers;

import common.RepeatableAction;
import common.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import pageobjects.TwitterCommonParts;

public class TwitterCommonPartsHelper
{
    private final SeleniumHelper seleniumHelper;
    private final TwitterFanPageHelper twitterFanPageHelper;
    private final TwitterCommonParts twitterCommonParts;

    public TwitterCommonPartsHelper(WebDriver driver)
    {
        seleniumHelper = new SeleniumHelper(driver);
        twitterCommonParts = new TwitterCommonParts(driver);
        twitterFanPageHelper = new TwitterFanPageHelper(driver);
    }

    public void searchForTweeterPage(String phrase)
    {
        seleniumHelper.insertTextIntoTextBox(twitterCommonParts.getSearchTextBox(), phrase);
    }

    public void clickFirstSearchResultWithRepeatableAction() throws InterruptedException
    {
        new RepeatableAction()
        {
            @Override
            protected boolean isActionSuccessful()
            {
                return twitterFanPageHelper.isFanPageMessageDmDisplayed();
            }

            @Override
            protected void action()
            {
                clickFirstSearchResult();
            }
        }.performAction();
    }

    private void clickFirstSearchResult()
    {
        seleniumHelper.waitForElementToBeClickableAndClick(twitterCommonParts.getSearchResultList().get(0));
    }

    public void clickProfileButton()
    {
        seleniumHelper.waitForElementToBeClickableAndClick(twitterCommonParts.getProfileButton());
    }
}
