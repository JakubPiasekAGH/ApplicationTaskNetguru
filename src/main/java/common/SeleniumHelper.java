package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper
{
    private final WebDriverWait wait;
    private final Actions actions;
    private final WebDriver driver;

    public SeleniumHelper(WebDriver driver)
    {
        this.wait = new WebDriverWait(driver, 15);
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    public void navigateToUrl(String url)
    {
        driver.get(url);
    }

    public void waitForElementToBeClickableAndClick(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
