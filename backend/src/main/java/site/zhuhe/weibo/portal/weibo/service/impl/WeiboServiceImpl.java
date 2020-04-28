package site.zhuhe.weibo.portal.weibo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.zhuhe.weibo.entity.weibo.Weibo;
import site.zhuhe.weibo.mapper.weibo.WeiboMapper;
import site.zhuhe.weibo.portal.weibo.service.intf.WeiboService;

import java.util.Arrays;
import java.util.Date;

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
     * 按页获取微博
     *
     * @param pageNum 页码
     * @return 微博列表
     */
    @Override
    public IPage<Weibo> getWeiboByPage(Integer pageNum) {
        Page<Weibo> page = new Page<>(pageNum, 10);
        QueryWrapper<Weibo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("time");
        return baseMapper.selectPage(page, queryWrapper);
    }

    /**
     * 按 id 获取微博
     *
     * @param id id
     * @return 单条微博
     */
    public Weibo getWeiboById(Integer id) {
        return baseMapper.selectById(id);
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

    /**
     * 更新微博
     *
     * @param weibo 更新内容
     */
    @Override
    public void updateWeibo(Weibo weibo) {
        weibo.setTime(new Date());
        baseMapper.updateById(weibo);
    }

    /**
     * 批量删除微博
     *
     * @param ids id 数组
     */
    @Override
    public void deleteWeibo(Integer[] ids) {
        baseMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
