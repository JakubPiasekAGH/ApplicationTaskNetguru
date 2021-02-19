package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class TwitterLoginPage
{
    @FindBy(xpath = "//main//input[@name='session[username_or_email]']")
    private WebElement usernameOrEmailTextBox;
    @FindBy(xpath = "//main//input[@name='session[password]']")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//main//div[@role='button']")
    private WebElement logInButton;

    public TwitterLoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
