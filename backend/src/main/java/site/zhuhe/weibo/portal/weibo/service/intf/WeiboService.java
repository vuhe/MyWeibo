package site.zhuhe.weibo.portal.weibo.service.intf;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import site.zhuhe.weibo.entity.weibo.Weibo;

/**
 * 微博 服务接口
 *
 * @className: WeiboService
 * @author: zhuhe
 * @date: 2020/4/20 18:45
 */
public interface WeiboService extends IService<Weibo> {
    /**
     * 按页获取微博
     *
     * @param page 页码
     * @return 微博列表
     */
    IPage<Weibo> getWeiboByPage(Integer page);

    /**
     * 新增微博
     *
     * @param weibo 微博内容
     */
    void addWeibo(Weibo weibo);

    /**
     * 更新微博
     *
     * @param weibo 更新内容
     */
    void updateWeibo(Weibo weibo);

    /**
     * 批量删除微博
     *
     * @param ids id 数组
     */
    void deleteWeibo(Integer[] ids);
}
