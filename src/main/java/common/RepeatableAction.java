package common;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

public abstract class RepeatableAction
{
    private int numberOfRepeats = 10;

    public RepeatableAction setNumberOfRepeats(int numberOfRepeats)
    {
        this.numberOfRepeats = numberOfRepeats;
        return this;
    }

    public boolean performAction() throws InterruptedException
    {
        for (int i = 0; i < numberOfRepeats; i++)
        {
            try
            {
                action();
                if (isActionSuccessful())
                    return true;
            } catch (NullPointerException | NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException ex)
            {
                Thread.sleep(100);
            }
        }
        return false;
    }

    protected abstract boolean isActionSuccessful();

    protected abstract void action();
}
