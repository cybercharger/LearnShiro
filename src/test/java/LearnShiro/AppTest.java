package LearnShiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/test-context.xml")
public class AppTest {
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Test
    public void testApp() {
        Subject s = SecurityUtils.getSubject();
        try {
            s.login(new MyToken("TestAccount", "P4$$w0rd"));
            logger.info("logged in");
            s.logout();
            logger.info("logged out");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

    }
}