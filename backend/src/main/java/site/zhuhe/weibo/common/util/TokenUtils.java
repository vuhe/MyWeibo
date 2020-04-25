package site.zhuhe.weibo.common.util;

import site.zhuhe.weibo.auth.OAuth2Token;

/**
 * Token 单例类
 *
 * @className: TokenUtils
 * @author: zhuhe
 * @date: 2020/4/25 20:41
 */
public class TokenUtils {

    private static final TokenUtils tokenUtils = new TokenUtils();
    private OAuth2Token token = null;

    private TokenUtils(){}

    public static TokenUtils getTokenUtils() {
        return tokenUtils;
    }

    public OAuth2Token getToken() {
        return token;
    }

    public void setToken(OAuth2Token token) {
        this.token = token;
    }

}
