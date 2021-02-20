package helpers;

import common.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import pageobjects.DeleteTweetDialog;

public class DeleteTweetDialogHelper
{
    private SeleniumHelper seleniumHelper;
    private DeleteTweetDialog deleteTweetDialog;

    public DeleteTweetDialogHelper(WebDriver driver)
    {
        seleniumHelper = new SeleniumHelper(driver);
        deleteTweetDialog = new DeleteTweetDialog(driver);
    }

    public void clickDeleteTweetButton()
    {
        seleniumHelper.waitForElementToBeClickableAndClick(deleteTweetDialog.getDeleteTweetButton());
    }
}
