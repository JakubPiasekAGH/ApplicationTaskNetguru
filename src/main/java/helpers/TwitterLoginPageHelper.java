package helpers;

import common.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import pageobjects.TwitterLoginPage;

public class TwitterLoginPageHelper
{
    private static final String TWITTER_URL = "https://twitter.com/login";
    private final SeleniumHelper seleniumHelper;
    private final TwitterLoginPage twitterLoginPage;

    public TwitterLoginPageHelper(WebDriver driver)
    {
        seleniumHelper = new SeleniumHelper(driver);
        twitterLoginPage = new TwitterLoginPage(driver);
    }

    private void openTwitterLoginPage()
    {
        seleniumHelper.navigateToUrl(TWITTER_URL);
    }

    private void insertUsernameOrEmailIntoUsernameOrEmailTextBox(String usernameOrEmail)
    {
        seleniumHelper.insertTextIntoTextBox(twitterLoginPage.getUsernameOrEmailTextBox(), usernameOrEmail);
    }

    private void insertPasswordIntoPasswordTextBox(String password)
    {
        seleniumHelper.insertTextIntoTextBox(twitterLoginPage.getPasswordTextBox(), password);
    }

    private void clickTwitterLogInButton()
    {
        seleniumHelper.waitForElementToBeClickableAndClick(twitterLoginPage.getLogInButton());
    }

    public void logInToTwitterWithCredentials(String usernameOrEmail, String password)
    {
        openTwitterLoginPage();
        insertUsernameOrEmailIntoUsernameOrEmailTextBox(usernameOrEmail);
        insertPasswordIntoPasswordTextBox(password);
        clickTwitterLogInButton();
    }

}
