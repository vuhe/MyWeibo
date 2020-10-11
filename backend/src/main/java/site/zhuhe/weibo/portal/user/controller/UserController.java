package site.zhuhe.weibo.portal.user.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import site.zhuhe.weibo.common.Result;
import site.zhuhe.weibo.entity.user.User;
import site.zhuhe.weibo.portal.user.service.intf.UserService;

import javax.annotation.Resource;

@Api(tags = "用户获取接口")
@RestController("UserController")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 新增用户
     * 权限：ALL
     *
     * @param user 新用户
     * @return 添加成功
     */
    @ApiOperation(value = "新增用户", notes = "此接口为后台公共接口，用于新增用户")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "系统内部错误")
    })
    @PostMapping("/registered")
    public Result<?> registeredUser(@ApiParam(name = "user", value = "新用户", required = true)
                                    @RequestBody User user) {
        return userService.registeredUser(user);
    }
}
