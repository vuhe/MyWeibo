package site.zhuhe.weibo.portal.weibo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zhuhe.weibo.common.Result;
import site.zhuhe.weibo.entity.weibo.Weibo;
import site.zhuhe.weibo.portal.weibo.service.intf.WeiboService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 微博 前端控制器
 *
 * @className: WeiboController
 * @author: zhuhe
 * @date: 2020/4/20 18:52
 */
@RestController("WeiboController")
public class WeiboController {
    @Resource
    private WeiboService weiboService;

    @GetMapping("/get/all")
    public Result getAllWeibo() {
        List<Weibo> weiboList = weiboService.getAllWeibo();
        return Result.ok().put("list", weiboList);
    }
}
