package site.zhuhe.weibo.portal.user.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import site.zhuhe.weibo.portal.weibo.service.intf.WeiboService;

import javax.annotation.Resource;

@Api(tags = "微博获取接口")
@RestController("UserController")
public class UserController {
    @Resource
    private WeiboService weiboService;


}
