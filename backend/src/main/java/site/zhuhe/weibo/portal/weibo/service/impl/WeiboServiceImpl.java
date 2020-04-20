package site.zhuhe.weibo.portal.weibo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.zhuhe.weibo.entity.weibo.Weibo;
import site.zhuhe.weibo.mapper.weibo.WeiboMapper;
import site.zhuhe.weibo.portal.weibo.service.intf.WeiboService;

import java.util.Date;
import java.util.List;

/**
 * 微博 服务接口实现
 *
 * @className: WeiboServiceImpl
 * @author: zhuhe
 * @date: 2020/4/20 18:48
 */
@Service("WeiboService")
public class WeiboServiceImpl extends ServiceImpl<WeiboMapper, Weibo> implements WeiboService {
    /**
     * 获取全部微博信息
     *
     * @return 微博列表
     */
    @Override
    public List<Weibo> getAllWeibo() {
        return baseMapper.getAllWeibo();
    }

    /**
     * 新增微博
     *
     * @param weibo 微博内容
     */
    @Override
    public void addWeibo(Weibo weibo) {
        weibo.setTime(new Date());
        baseMapper.insert(weibo);
    }
}
