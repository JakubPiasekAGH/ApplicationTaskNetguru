import common.TestBase;
import helpers.TwitterLoginPageHelper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import javax.annotation.PostConstruct;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TwitterTestBase extends TestBase
{
    protected TwitterLoginPageHelper twitterLoginPageHelper;

    @PostConstruct
    void init()
    {
        twitterLoginPageHelper = new TwitterLoginPageHelper(driver);
    }
}
