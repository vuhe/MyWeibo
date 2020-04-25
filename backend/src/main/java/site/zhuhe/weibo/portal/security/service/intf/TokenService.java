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
     * @return 带token的结果
     */
    Result createToken();


    /**
     * 退出登录
     */
    void logout();
}
