package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class DeleteTweetDialog
{
    @FindBy(xpath = "//div[@data-testid='confirmationSheetConfirm']")
    private WebElement deleteTweetButton;

    public DeleteTweetDialog(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
