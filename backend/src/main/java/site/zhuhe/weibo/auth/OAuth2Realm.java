package site.zhuhe.weibo.auth;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.zhuhe.weibo.entity.user.User;
import site.zhuhe.weibo.portal.security.service.intf.TokenService;
import site.zhuhe.weibo.portal.user.service.intf.UserService;

import java.util.HashSet;
import java.util.Set;

/**
 * Shiro 认证类
 * 权限管理
 *
 * @className: OAuth2Realm
 * @author: zhuhe
 * @date: 2020/4/25 19:47
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //用户权限列表
        Set<String> permsSet = new HashSet<>() {{
            add("ADMIN");
        }};

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        //根据accessToken，查询用户名
        String username = tokenService.queryByToken(accessToken);
        // token失效
        if (username == null) {
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }

        //查询用户信息
        User user = userService.searchUserByName(username);
        if (user == null) {
            throw new IncorrectCredentialsException("内部错误！");
        }

        // 续期
        tokenService.refreshToken(username, accessToken);

        return new SimpleAuthenticationInfo(user, accessToken, getName());
    }
}
