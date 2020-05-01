package site.zhuhe.weibo.portal.weibo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.*;
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
@Api(tags = "微博获取接口")
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
    @ApiOperation(value = "按页获取微博", notes = "此接口为前后台公用")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "系统内部错误")
    })
    @GetMapping("/get/{page}")
    public Result getWeiboByPage(@ApiParam(name = "page", value = "页码", required = true)
                                 @PathVariable Integer page) {
        IPage<Weibo> weiboList = weiboService.getWeiboByPage(page);
        return Result.ok().put("page", weiboList);
    }

    /**
     * 按 id 获取微博
     * 权限：ADMIN
     *
     * @param id id
     * @return 单条微博
     */
    @ApiOperation(value = "按id获取微博", notes = "此接口为后台接口，返回单条微博")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "系统内部错误")
    })
    @GetMapping("/weibo/{id}")
    public Result getWeiboById(@ApiParam(name = "id", value = "id", required = true)
                               @PathVariable Integer id) {
        return Result.ok().put("weibo", weiboService.getWeiboById(id));
    }

    /**
     * 新增微博
     * 权限：ADMIN
     *
     * @param weibo 新增微博内容
     * @return 添加成功
     */
    @ApiOperation(value = "新增微博", notes = "此接口为后台接口，用于新增微博")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "系统内部错误")
    })
    @PostMapping("/add")
    public Result addWeibo(@ApiParam(name = "weibo", value = "新增微博内容", required = true)
                           @RequestBody Weibo weibo) {
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
    @ApiOperation(value = "修改微博", notes = "此接口为后台接口，用于修改微博")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "系统内部错误")
    })
    @PutMapping("/modify")
    public Result updateWeibo(@ApiParam(name = "weibo", value = "修改微博内容", required = true)
                              @RequestBody Weibo weibo) {
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
    @ApiOperation(value = "批量删除微博", notes = "此接口为后台接口，用于批量删除微博")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "系统内部错误")
    })
    @DeleteMapping("/delete")
    public Result delete(@ApiParam(name = "ids", value = "id数组", required = true)
                         @RequestBody Integer[] ids) {
        weiboService.deleteWeibo(ids);
        return Result.ok();
    }
}
