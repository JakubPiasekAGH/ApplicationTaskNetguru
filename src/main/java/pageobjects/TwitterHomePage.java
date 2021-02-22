package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class TwitterHomePage
{
    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement newTweetTextBox;
    @FindBy(xpath = "//input[@data-testid='fileInput']")
    private WebElement newTweetImageFileInputButton;
    @FindBy(xpath = "//div[@data-testid='tweetButtonInline']")
    private WebElement clickTweetButton;
    @FindBy(xpath = "//div[@data-testid='tweet']")
    private WebElement tweet;
    @FindBy(xpath = "//div[@data-testid='tweet']//div[@lang='en']")
    private WebElement tweetText;
    @FindBy(xpath = "//img[@alt='Image']")
    private WebElement tweetImage;
    @FindBy(xpath = "//article")
    private List<WebElement> tweetsList;
    @FindBy(xpath = "//article//div[@data-testid='caret']")
    private List<WebElement> tweetOptionButtonsList;
    @FindBy(xpath = "//div[@role='menuitem' and contains(.,'Delete')]")
    private WebElement deleteTweetButton;
    private final By tweetsListLocator = By.xpath("//article");

    public TwitterHomePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
