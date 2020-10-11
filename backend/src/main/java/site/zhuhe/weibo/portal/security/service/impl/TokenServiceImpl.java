package site.zhuhe.weibo.portal.security.service.impl;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import site.zhuhe.weibo.auth.TokenGenerator;
import site.zhuhe.weibo.common.Result;
import site.zhuhe.weibo.common.util.RedisUtils;
import site.zhuhe.weibo.entity.user.User;
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
    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 生成Token
     *
     * @param user 用户
     * @return 带token的结果
     */
    @Override
    public Result<?> createToken(User user) {
        // 生成一个token
        String token = TokenGenerator.generateValue();

        String tokenKey = RedisUtils.TOKEN + token;
        String userKey = RedisUtils.TOKEN + user.getName();

        //判断是否生成过token
        String tokenInRedis = redisUtils.get(userKey);
        if (!StringUtils.isEmpty(tokenInRedis)) {
            // 将原来的token删除
            redisUtils.delete(RedisUtils.TOKEN + tokenInRedis);
        }

        // 将token存进redis
        redisUtils.set(tokenKey, user.getName(), EXPIRE);
        redisUtils.set(userKey, token, EXPIRE);

        return Result.of(201, "登陆成功", "token", token);
    }

    /**
     * 通过 token 查询用户
     *
     * @param token token
     * @return 用户名
     */
    @Override
    public String queryByToken(String token) {
        String username = redisUtils.get(RedisUtils.TOKEN + token);
        if (StringUtils.isEmpty(username)) {
            return null;
        } else {
            return username;
        }
    }

    /**
     * 退出登录
     */
    @Override
    public void logout() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String userKey = RedisUtils.TOKEN + user.getName();
        String token = redisUtils.get(userKey);
        String tokenKey = RedisUtils.TOKEN + token;
        redisUtils.delete(userKey);
        redisUtils.delete(tokenKey);
    }

    /**
     * 续期
     *
     * @param username 用户
     * @param token token
     */
    @Override
    public void refreshToken(String username, String token) {
        String tokenKey = RedisUtils.TOKEN + token;
        String userKey = RedisUtils.TOKEN + username;
        redisUtils.updateExpire(tokenKey);
        redisUtils.updateExpire(userKey);
    }
}
