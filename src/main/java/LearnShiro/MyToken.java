package LearnShiro;

import org.apache.shiro.authc.AuthenticationToken;

public class MyToken implements AuthenticationToken {
    private final String principal;
    private final String credential;

    public MyToken(String principal, String credential) {
        this.principal = principal;
        this.credential = credential;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public Object getCredentials() {
        return credential;
    }

    @Override
    public String toString() {
        return "{[Principal]: " + principal + " [Credential]: " + credential + "}";
    }
}
