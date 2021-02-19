package common;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@ContextConfiguration(classes = TestConfig.class)
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase
{
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected PropertiesReader propertiesReader;
    protected SeleniumHelper seleniumHelper;

    @PostConstruct
    void init()
    {
        seleniumHelper = new SeleniumHelper(driver);
    }

    @BeforeAll
    public void setUp()
    {
        driver.manage().timeouts().implicitlyWait(propertiesReader.getImplicitWaitDriverTime(), TimeUnit.SECONDS);
    }

    @AfterAll
    public void tearDown()
    {
        if (driver != null)
            driver.quit();
    }
}
