package LearnShiro;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySecurityManager extends DefaultSecurityManager {
    private final static Log log = LogFactory.getLog(MySecurityManager.class);
    private final String name;

    public MySecurityManager(String name) {
        log.info("MySecurityManager: " + name);
        this.name = name;
    }

    @Override
    public Subject login(Subject subject, AuthenticationToken token) throws AuthenticationException {
        log.info(String.format("[Subject]: %1$s\t[Token]: %2$s", subject, token));
        return super.login(subject, token);
    }
}
