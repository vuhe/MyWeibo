package site.zhuhe.weibo.portal.security.controller;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.zhuhe.weibo.common.Result;
import site.zhuhe.weibo.common.exception.enums.ErrorEnum;
import site.zhuhe.weibo.entity.user.User;
import site.zhuhe.weibo.mapper.user.UserMapper;
import site.zhuhe.weibo.portal.security.service.intf.TokenService;

/**
 * 权限控制器
 *
 * @className: SecurityController
 * @author: zhuhe
 * @date: 2020/4/23 18:39
 */
@RestController
public class SecurityController {
    @Autowired
    TokenService tokenService;

    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        // 用户信息
        User userInfo = userMapper.getUser();
        if (user == null || !userInfo.getPwd().equals(
                new Sha256Hash(user.getPwd(), user.getName()).toHex())) {
            // 用户名或密码错误
            return Result.error(ErrorEnum.USERNAME_OR_PASSWORD_WRONG);
        }

        //生成token，并保存
        return tokenService.createToken();
    }

    @PostMapping("/logout")
    public Result logout() {
        tokenService.logout();
        return Result.ok();
    }

}
