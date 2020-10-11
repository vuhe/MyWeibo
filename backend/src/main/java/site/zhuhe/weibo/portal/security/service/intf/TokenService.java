package site.zhuhe.weibo.portal.security.service.intf;

import site.zhuhe.weibo.common.Result;

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
     * @param clientTag 客户端类型
     * @return 带token的结果
     */
    Result<?> createToken(String clientTag);

    /**
     * 通过 token 查询客户端类型
     *
     * @param token token
     * @return 客户端类型
     */
    String queryByToken(String token);

    /**
     * 退出登录
     *
     * @param clientTag 客户端类型
     */
    void logout(String clientTag);

    /**
     * 续期
     *
     * @param client 客户端类型
     * @param token token
     */
    void refreshToken(String client, String token);
}
