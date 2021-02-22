package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class TwitterProfilePage
{
    @FindBy(xpath = "//a[contains(@href,'following')]")
    private WebElement followingLabel;

    public TwitterProfilePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
