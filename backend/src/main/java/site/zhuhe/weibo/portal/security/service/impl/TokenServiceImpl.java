package site.zhuhe.weibo.portal.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import site.zhuhe.weibo.auth.TokenGenerator;
import site.zhuhe.weibo.common.Result;
import site.zhuhe.weibo.common.exception.enums.ErrorEnum;
import site.zhuhe.weibo.common.util.RedisUtils;
import site.zhuhe.weibo.portal.security.service.intf.TokenService;

import java.util.HashSet;
import java.util.Set;

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

    // 客户端集合
    private final static Set<String> clientSet = new HashSet<String>() {{
        add("web-service");
    }};

    /**
     * 生成Token
     *
     * @param clientTag 客户端类型
     * @return 带token的结果
     */
    @Override
    public Result createToken(String clientTag) {
        if (clientTag == null || !clientSet.contains(clientTag)) {
            return Result.error(ErrorEnum.INVALID_CLIENT);
        }
        // 生成一个token
        String token = TokenGenerator.generateValue();

        String tokenKey = RedisUtils.TOKEN + token;
        String clientKey = RedisUtils.TOKEN + clientTag;

        //判断是否生成过token
        String tokenInRedis = redisUtils.get(clientKey);
        if (!StringUtils.isEmpty(tokenInRedis)) {
            // 将原来的token删除
            redisUtils.delete(RedisUtils.TOKEN + tokenInRedis);
        }

        // 将token存进redis
        redisUtils.set(tokenKey, clientTag, EXPIRE);
        redisUtils.set(clientKey, token, EXPIRE);

        return Result.ok(201, "登陆成功").put("token", token);
    }

    /**
     * 通过 token 查询客户端类型
     *
     * @param token token
     * @return 客户端类型
     */
    @Override
    public String queryByToken(String token) {
        String client = redisUtils.get(RedisUtils.TOKEN + token);
        if (StringUtils.isEmpty(client)) {
            return null;
        } else {
            return client;
        }
    }

    /**
     * 退出登录
     *
     * @param clientTag 客户端类型
     */
    @Override
    public void logout(String clientTag) {
        String clientKey = RedisUtils.TOKEN + clientTag;
        String token = redisUtils.get(clientKey);
        String tokenKey = RedisUtils.TOKEN + token;
        redisUtils.delete(clientKey);
        redisUtils.delete(tokenKey);
    }

    /**
     * 续期
     *
     * @param client 客户端类型
     * @param token token
     */
    @Override
    public void refreshToken(String client, String token) {
        String tokenKey = RedisUtils.TOKEN + token;
        String clientKey = RedisUtils.TOKEN + client;
        redisUtils.updateExpire(tokenKey);
        redisUtils.updateExpire(clientKey);
    }
}
