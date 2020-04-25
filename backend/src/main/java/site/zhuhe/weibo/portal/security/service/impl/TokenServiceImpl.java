package site.zhuhe.weibo.portal.security.service.impl;

import org.springframework.stereotype.Service;
import site.zhuhe.weibo.auth.OAuth2Token;
import site.zhuhe.weibo.auth.TokenGenerator;
import site.zhuhe.weibo.common.Result;
import site.zhuhe.weibo.common.util.TokenUtils;
import site.zhuhe.weibo.portal.security.service.intf.TokenService;

/**
 * Token 服务类实现
 *
 * @className: TokenServiceImpl
 * @author: zhuhe
 * @date: 2020/4/25 20:07
 */
@Service
public class TokenServiceImpl implements TokenService {

    /**
     * 生成Token
     *
     * @return 带token的结果
     */
    @Override
    public Result createToken() {
        // 生成一个token
        String token = TokenGenerator.generateValue();
        // 全局token
        TokenUtils.getTokenUtils().setToken(new OAuth2Token(token));
        return Result.ok(201, "登陆成功").put("token", token);
    }

    /**
     * 退出登录
     */
    @Override
    public void logout() {
        // 清楚全局token
        TokenUtils.getTokenUtils().setToken(null);
    }
}
