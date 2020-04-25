package site.zhuhe.weibo.auth;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Shiro 认证类
 * 实现 Token
 *
 * @className: OAuth2Token
 * @author: zhuhe
 * @date: 2020/4/25 19:45
 */
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
