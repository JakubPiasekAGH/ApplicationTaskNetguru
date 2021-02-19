package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.springframework.boot.logging.LoggingSystem.SYSTEM_PROPERTY;

@Getter
@Configuration
public class TestConfig
{
    private static final String PROPERTIES_FILENAME = "test.properties";
    private static final String ENABLE_AUTOMATION = "enable-automation";
    private static final String START_MAXIMIZED = "start-maximized";
    private final ChromeOptions chromeOptions = new ChromeOptions();
    private InputStream defaultTestPropertiesFile;
    private PropertiesReader propertiesReader;

    public TestConfig()
    {
        WebDriverManager.chromedriver().setup();
    }

    @PostConstruct
    void init() throws IOException
    {
        propertiesReader = new PropertiesReader(getTestExecutionPropertiesFile());
        setChromeOptions();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriver webDriver()
    {
        return getDriverInstance();
    }

    @Bean
    public PropertiesReader propertiesReader() throws IOException
    {
        return new PropertiesReader(getTestExecutionPropertiesFile());
    }

    private InputStream getTestExecutionPropertiesFile() throws IOException
    {
        defaultTestPropertiesFile = ClassLoader.getSystemClassLoader().getResourceAsStream(PROPERTIES_FILENAME);
        var externalProperties = System.getProperty(SYSTEM_PROPERTY);
        return externalProperties != null ? FileUtils.openInputStream(
                new File(externalProperties)) : defaultTestPropertiesFile;
    }

    private void setChromeOptions()
    {
        chromeOptions.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        chromeOptions.addArguments(START_MAXIMIZED);
        chromeOptions.setHeadless(propertiesReader.isWebdriverHeadless());
        chromeOptions.setExperimentalOption("excludeSwitches", List.of(ENABLE_AUTOMATION));
    }

    private WebDriver getDriverInstance()
    {
        return new ChromeDriver(chromeOptions);
    }
}
