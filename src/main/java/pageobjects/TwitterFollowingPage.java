package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class TwitterFollowingPage
{
    @FindBy(xpath = "//section//div[@data-testid='UserCell']//div[contains(@data-testid,'unfollow')]")
    private List<WebElement> unFollowButtonsList;

    public TwitterFollowingPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
