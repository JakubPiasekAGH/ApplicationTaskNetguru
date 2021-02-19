import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TwitterPostingTest extends TwitterTestBase
{

    @BeforeAll
    void logInToTweeterAsPostingUser()
    {
        twitterLoginPageHelper.logInToTwitterWithCredentials(propertiesReader.getPostingUserName(),
                propertiesReader.getPostingUserPassword());
    }

    @Test
    void test()
    {
        System.out.println("AA");
    }

    @Test
    void tes4t()
    {
        System.out.println("AA");
    }


    @Test
    void tes34t()
    {
        System.out.println("AA");
    }


    @Test
    void tes3t()
    {
        System.out.println("AA");
    }
}
