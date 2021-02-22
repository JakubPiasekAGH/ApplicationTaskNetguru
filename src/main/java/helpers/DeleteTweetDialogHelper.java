package helpers;

import common.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import pageobjects.ConfirmationDialog;

public class DeleteTweetDialogHelper
{
    private final SeleniumHelper seleniumHelper;
    private final ConfirmationDialog confirmationDialog;

    public DeleteTweetDialogHelper(WebDriver driver)
    {
        seleniumHelper = new SeleniumHelper(driver);
        confirmationDialog = new ConfirmationDialog(driver);
    }

    public void clickDeleteTweetButton()
    {
        seleniumHelper.waitForElementToBeClickableAndClick(confirmationDialog.getConfirmActionButton());
    }
}
