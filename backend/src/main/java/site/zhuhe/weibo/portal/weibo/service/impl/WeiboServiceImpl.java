package site.zhuhe.weibo.portal.weibo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.zhuhe.weibo.entity.weibo.Weibo;
import site.zhuhe.weibo.mapper.weibo.WeiboMapper;
import site.zhuhe.weibo.portal.weibo.service.intf.WeiboService;

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
    @Override
    public List<Weibo> getAllWeibo() {
        return baseMapper.getAllWeibo();
    }
}
