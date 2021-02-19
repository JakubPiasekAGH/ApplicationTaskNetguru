package exception;

import lombok.Getter;

import java.io.IOException;

@Getter
public class ReadPropertyException extends RuntimeException
{
    private final String message;
    private final IOException originalException;

    public ReadPropertyException(IOException exception, String message)
    {
        this.originalException = exception;
        this.message = message;
    }
}
