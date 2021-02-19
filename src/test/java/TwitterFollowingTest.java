import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TwitterFollowingTest extends TwitterTestBase
{
    @BeforeAll
    void logInToTweeterAsPostingUser()
    {
        twitterLoginPageHelper.logInToTwitterWithCredentials(propertiesReader.getFollowingUserName(),
                propertiesReader.getFollowingUserPassword());
    }

    @Order(1)
    @Test
    void doSomething()
    {
        System.out.println("Simple test 1");
    }

    @Order(2)
    @Test
    void doSomethingElse()
    {
        System.out.println("AAAAAAAAA else 2");
    }

    @Order(3)
    @Test
    void doSomethingEsslse()
    {
        System.out.println("AAAAAAAAA else 3");
    }
}
