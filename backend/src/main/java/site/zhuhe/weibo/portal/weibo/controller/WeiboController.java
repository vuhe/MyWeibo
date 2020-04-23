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

    /**
     * 按页获取微博
     * 权限：ALL
     *
     * @param page 页码
     * @return 微博页信息
     */
    @GetMapping("/get/{page}")
    public Result getWeiboByPage(@PathVariable Integer page) {
        IPage<Weibo> weiboList = weiboService.getWeiboByPage(page);
        return Result.ok().put("page", weiboList);
    }

    /**
     * 新增微博
     * 权限：ADMIN
     *
     * @param weibo 新增微博内容
     * @return 添加成功
     */
    @PostMapping("/add")
    public Result addWeibo(@RequestBody Weibo weibo) {
        weiboService.addWeibo(weibo);
        return Result.ok();
    }

    /**
     * 修改微博
     * 权限：ADMIN
     *
     * @param weibo 修改微博内容
     * @return 修改成功
     */
    @PutMapping("/modify")
    public Result updateWeibo(@RequestBody Weibo weibo) {
        weiboService.updateWeibo(weibo);
        return Result.ok();
    }

    /**
     * 批量删除微博
     * 权限：ADMIN
     *
     * @param ids 删除微博序号数组
     * @return 删除成功
     */
    @DeleteMapping("/delete")
    public Result delete(@RequestBody Integer[] ids) {
        weiboService.deleteWeibo(ids);
        return Result.ok();
    }
}
