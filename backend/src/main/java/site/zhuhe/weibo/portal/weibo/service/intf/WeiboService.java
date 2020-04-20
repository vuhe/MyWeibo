package site.zhuhe.weibo.portal.weibo.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import site.zhuhe.weibo.entity.weibo.Weibo;

import java.util.Date;
import java.util.List;

/**
 * 微博 服务接口
 *
 * @className: WeiboService
 * @author: zhuhe
 * @date: 2020/4/20 18:45
 */
public interface WeiboService extends IService<Weibo> {
    /**
     * 获取全部微博信息
     *
     * @return 微博列表
     */
    List<Weibo> getAllWeibo();

    /**
     * 新增微博
     *
     * @param weibo 微博内容
     */
    void addWeibo(Weibo weibo);
}
