package helpers;

import common.SeleniumHelper;
import org.openqa.selenium.WebDriver;

public class TwitterLoginPageHelper
{
    private static final String twitterUrl = "https://twitter.com/login";
    private SeleniumHelper seleniumHelper;

    public TwitterLoginPageHelper(WebDriver driver)
    {
        seleniumHelper = new SeleniumHelper(driver);
    }

    public void openTwitterLoginPage()
    {
        seleniumHelper.navigateToUrl(twitterUrl);
    }

}
