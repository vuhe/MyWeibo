package site.zhuhe.weibo.portal.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import site.zhuhe.weibo.common.Result;
import site.zhuhe.weibo.common.exception.enums.ErrorEnum;

/**
 * 权限控制器
 *
 * @className: SecurityController
 * @author: zhuhe
 * @date: 2020/4/23 18:39
 */
@RestController
public class SecurityController {

    @GetMapping("/login")
    public Result login() {
        return Result.error(ErrorEnum.INVALID_LOGIN);
    }

}
