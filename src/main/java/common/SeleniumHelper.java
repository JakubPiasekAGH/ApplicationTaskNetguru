package common;

import org.openqa.selenium.By;
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

    public void insertTextIntoTextBox(WebElement element, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public void waitForNumberOfElementToBe(By locator, int number)
    {
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, number));
    }

    /**
     * Method allows to send keys directly to web element. It is useful when you want e.g. to insert image to input
     * element
     *
     * @param webElement - element to send keys to
     * @param text       - phrase you want to send
     */
    public void sendKeysToWebElement(WebElement webElement, String text)
    {
        webElement.sendKeys(text);
    }

    public boolean isElementDisplayed(WebElement element)
    {
        return element.isDisplayed();
    }

    public String getTextFromElement(WebElement element)
    {
        return element.getText();
    }

    public String getAttributeFromElement(WebElement element, String attribute)
    {
        return element.getAttribute(attribute);
    }
}
