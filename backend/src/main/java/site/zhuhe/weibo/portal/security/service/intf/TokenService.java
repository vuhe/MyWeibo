package site.zhuhe.weibo.portal.security.service.intf;

import site.zhuhe.weibo.common.Result;
import site.zhuhe.weibo.entity.user.User;

/**
 * Token 服务类
 *
 * @className: TokenService
 * @author: zhuhe
 * @date: 2020/4/25 20:05
 */
public interface TokenService {
    /**
     * 生成Token
     *
     * @param user 用户
     * @return 带token的结果
     */
    Result<?> createToken(User user);

    /**
     * 通过 token 查询用户
     *
     * @param token token
     * @return 用户名
     */
    String queryByToken(String token);

    /**
     * 退出登录
     */
    void logout();

    /**
     * 续期
     *
     * @param username 用户
     * @param token token
     */
    void refreshToken(String username, String token);
}
