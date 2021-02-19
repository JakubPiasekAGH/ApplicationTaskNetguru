import common.TestBase;
import helpers.TwitterLoginPageHelper;
import org.junit.jupiter.api.Test;

import javax.annotation.PostConstruct;

public class TwitterTest extends TestBase
{
    private TwitterLoginPageHelper twitterLoginPageHelper;

    @PostConstruct
    void init()
    {
        twitterLoginPageHelper = new TwitterLoginPageHelper(driver);
    }


    @Test
    void test()
    {
        twitterLoginPageHelper.openTwitterLoginPage();
        System.out.println("AA");
    }
}
