package site.zhuhe.weibo.portal.security.controller;

import io.swagger.annotations.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.zhuhe.weibo.common.Result;
import site.zhuhe.weibo.common.exception.enums.ErrorEnum;
import site.zhuhe.weibo.entity.user.User;
import site.zhuhe.weibo.portal.security.service.intf.TokenService;
import site.zhuhe.weibo.portal.user.service.intf.UserService;

/**
 * 权限控制器
 *
 * @className: SecurityController
 * @author: zhuhe
 * @date: 2020/4/23 18:39
 */
@Api(tags = "权限验证接口")
@RestController
public class SecurityController {
    @Autowired
    TokenService tokenService;

    @Autowired
    UserService userService;

    @ApiOperation(value = "登录", notes = "此接口为后台接口")
    @ApiResponses({
            @ApiResponse(code = 201, message = "成功"),
            @ApiResponse(code = 500, message = "系统内部错误"),
            @ApiResponse(code = 1001, message = "token不合法"),
            @ApiResponse(code = 1002, message = "登录信息不合法"),
            @ApiResponse(code = 1003, message = "非法客户端"),
            @ApiResponse(code = 10001, message = "登录失败"),
            @ApiResponse(code = 10003, message = "用户名或密码错误")
    })
    @PostMapping("/login")
    public Result<?> login(@ApiParam(name = "user", value = "用户信息", required = true)
                        @RequestBody User user) {
        if (user == null) {
            // 登录信息为空
            return Result.ofErrorEnum(ErrorEnum.INVALID_LOGIN);
        } else {
            User userInfo = userService.searchUserByName(user.getName());
            if (userInfo == null || !userInfo.getPwd().equals(
                    new Sha256Hash(user.getPwd(), user.getName()).toHex())) {
                // 用户名或密码错误
                return Result.ofErrorEnum(ErrorEnum.PASSWORD_WRONG);
            }
        }

        //生成token，并保存
        return tokenService.createToken(user);
    }

    @ApiOperation(value = "登出", notes = "此接口为后台接口")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "系统内部错误")
    })
    @PostMapping("/logout")
    public Result<?> logout() {
        tokenService.logout();
        return Result.ofSuccess();
    }

    @ApiOperation(value = "检查token", notes = "此接口为后台接口")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "系统内部错误")
    })
    @GetMapping("/token")
    public Result<?> checkToken() {
        return Result.ofSuccess();
    }

}
