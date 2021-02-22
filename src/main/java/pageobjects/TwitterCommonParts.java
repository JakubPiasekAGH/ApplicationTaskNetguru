package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class TwitterCommonParts
{
    @FindBy(xpath = "//input[@data-testid='SearchBox_Search_Input']")
    private WebElement searchTextBox;
    @FindBy(xpath = "//div[@role='listbox']")
    private WebElement searchResultListbox;
    @FindBy(xpath = "//li[@data-testid='TypeaheadUser']/..")
    private List<WebElement> searchResultList;
    @FindBy(xpath = "//a[@aria-label='Profile']")
    private WebElement profileButton;
    @FindBy(xpath = "//a[@aria-label='Home']")
    private WebElement homeButton;

    public TwitterCommonParts(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
