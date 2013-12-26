package LearnShiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

public class MySecurityManager extends DefaultSecurityManager {
    private final String name;

    public MySecurityManager(String name) {
        System.out.println("Name of MySecurityManager is : " + name);
        this.name = name;
    }

    @Override
    public Subject login(Subject subject, AuthenticationToken token) throws AuthenticationException {
        System.out.println(String.format("[Subject]: %1$s\n[Token]: %2$s", subject, token));
        return super.login(subject, token);
    }
}
