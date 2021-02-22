package common;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

public abstract class RepeatableAction
{
    public void performAction() throws InterruptedException
    {
        for (int i = 0; i < 10; i++)
        {
            try
            {
                action();
                if (isActionSuccessful())
                    return;
            } catch (NullPointerException | NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException ex)
            {
                Thread.sleep(100);
            }
        }
    }

    protected abstract boolean isActionSuccessful();

    protected abstract void action();
}
