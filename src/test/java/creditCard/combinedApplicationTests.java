package creditCard;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@SuiteClasses({
        creditCardValidationTests.class,
        fileCategorizerTests.class,
        verifyCreditCardNumberTests.class,
        creditCardInputTests.class })
public class combinedApplicationTests {
    @Test
    void contextLoads() {
    }

    @BeforeClass
    public static void beforeClass() {
    }

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @AfterClass
    public static void afterClass() {
    }
}