package LearnShiro;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/test-context.xml")
public class AppTest {
    private static final Log log = LogFactory.getLog(AppTest.class);

    @Test
    public void testCorrectLogin() {
        Subject s = SecurityUtils.getSubject();
        try {
            s.login(new MyToken("TestAccount", "P4$$w0rd"));
            log.info("logged in");
            s.logout();
            log.info("logged out");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFailedLogin() {
        try {
            Subject s = SecurityUtils.getSubject();
            s.login(new MyToken("AAA", "aaa"));
            log.info("logged in");
            s.logout();
            log.info("logged out");
        } catch (AuthenticationException e) {
            log.error("failed to login: " + e.getMessage());
        }
    }
}
