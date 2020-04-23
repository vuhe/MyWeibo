package site.zhuhe.weibo.portal.weibo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     * @param pageNum 页码
     * @return 微博列表
     */
    @Override
    public IPage<Weibo> getWeiboByPage(Integer pageNum) {
        Page<Weibo> page = new Page<>(pageNum, 10);
        IPage<Weibo> selectPage = baseMapper.selectPage(page, null);
        return selectPage;
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
