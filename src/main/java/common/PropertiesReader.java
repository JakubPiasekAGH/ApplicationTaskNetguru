package common;

import exception.ReadPropertyException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader
{
    private final Properties properties;

    public PropertiesReader(InputStream propertiesFile)
    {
        properties = loadProperties(propertiesFile);
    }

    public Properties loadProperties(InputStream inputStream)
    {
        var loadProperties = new Properties();
        try
        {
            loadProperties.load(inputStream);
        } catch (IOException e)
        {
            throw new ReadPropertyException(e, "Not able to read properties from default test.properties file");
        }
        return loadProperties;
    }

    public String getProperty(String property)
    {
        var systemProperty = System.getProperty(property);
        return systemProperty != null ? systemProperty : properties.getProperty(property);
    }

    private boolean getPropertyAsBoolean(String property)
    {
        return Boolean.parseBoolean(getProperty(property));
    }

    private int getPropertyAsInteger(String property)
    {
        return Integer.parseInt(getProperty(property));
    }

    public boolean isWebdriverHeadless()
    {
        return getPropertyAsBoolean("is.headless");
    }

    public int getImplicitWaitDriverTime()
    {
        return getPropertyAsInteger("wait.timeout");
    }
}