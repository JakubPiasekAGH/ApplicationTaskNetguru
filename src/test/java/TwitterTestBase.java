import common.TestBase;
import helpers.TwitterHomePageHelper;
import helpers.TwitterLoginPageHelper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import javax.annotation.PostConstruct;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TwitterTestBase extends TestBase
{
    protected TwitterLoginPageHelper twitterLoginPageHelper;
    protected TwitterHomePageHelper twitterHomePageHelper;

    @PostConstruct
    void initTwitterTestBase()
    {
        twitterLoginPageHelper = new TwitterLoginPageHelper(driver);
        twitterHomePageHelper = new TwitterHomePageHelper(driver);
    }
}
