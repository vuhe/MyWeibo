package site.zhuhe.weibo.portal.weibo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;
import site.zhuhe.weibo.common.Result;
import site.zhuhe.weibo.entity.weibo.Weibo;
import site.zhuhe.weibo.portal.weibo.service.intf.WeiboService;

import javax.annotation.Resource;

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

    @GetMapping("/get/{page}")
    public Result getAllWeibo(@PathVariable Integer page) {
        IPage<Weibo> weiboList = weiboService.getWeiboByPage(page);
        return Result.ok().put("page", weiboList);
    }

    @PostMapping("/add")
    public Result addWeibo(@RequestBody Weibo weibo) {
        weiboService.addWeibo(weibo);
        return Result.ok();
    }
}
