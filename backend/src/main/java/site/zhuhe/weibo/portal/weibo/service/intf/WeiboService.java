package site.zhuhe.weibo.portal.weibo.service.intf;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import site.zhuhe.weibo.entity.weibo.Weibo;
import site.zhuhe.weibo.entity.weibo.WeiboDTO;
import site.zhuhe.weibo.entity.weibo.WeiboVO;

/**
 * 微博 服务接口
 *
 * @className: WeiboService
 * @author: zhuhe
 * @date: 2020/4/20 18:45
 */
public interface WeiboService extends IService<WeiboDTO> {
    /**
     * 按页获取微博
     *
     * @param page 页码
     * @return 微博列表
     */
    IPage<WeiboVO> getWeiboByPage(Integer page);

    /**
     * 按用户页获取微博
     *
     * @param page 页码
     * @return 微博列表
     */
    IPage<Weibo> getWeiboByUserPage(Integer page);

    /**
     * 按 id 获取微博
     *
     * @param id id
     * @return 单条微博
     */
    Weibo getWeiboById(Integer id);

    /**
     * 新增微博
     *
     * @param weibo 微博内容
     */
    void addWeibo(Weibo weibo);

    /**
     * 喜欢微博
     *
     * @param id 微博id
     */
    void likeWeibo(Integer id);

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
