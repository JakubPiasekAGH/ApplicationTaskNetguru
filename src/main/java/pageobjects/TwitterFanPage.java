package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class TwitterFanPage
{
    @FindBy(xpath = "//div[@data-testid='placementTracking']")
    private WebElement followButton;
    @FindBy(xpath = "//div[contains(@data-testid,'unfollow')]")
    private WebElement unFollowButton;
    @FindBy(xpath = "//div[@data-testid='sendDMFromProfile']")
    private WebElement sendDmFromProfileButton;

    public TwitterFanPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
