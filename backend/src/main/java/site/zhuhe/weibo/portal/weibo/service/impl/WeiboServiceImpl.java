package site.zhuhe.weibo.portal.weibo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.zhuhe.weibo.entity.user.User;
import site.zhuhe.weibo.entity.weibo.Weibo;
import site.zhuhe.weibo.entity.weibo.WeiboDTO;
import site.zhuhe.weibo.entity.weibo.WeiboVO;
import site.zhuhe.weibo.mapper.user.UserMapper;
import site.zhuhe.weibo.mapper.weibo.WeiboMapper;
import site.zhuhe.weibo.portal.user.service.intf.UserService;
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
public class WeiboServiceImpl extends ServiceImpl<WeiboMapper, WeiboDTO> implements WeiboService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    /**
     * 按页获取微博
     *
     * @param pageNum 页码
     * @return 微博列表
     */
    @Override
    public IPage<WeiboVO> getWeiboByPage(Integer pageNum) {
        Page<WeiboDTO> page = new Page<>(pageNum, 10);
        QueryWrapper<WeiboDTO> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("timeStamp");
        IPage<WeiboDTO> weiboIPage = baseMapper.selectPage(page, queryWrapper);
        return weiboIPage.convert(weibo -> {
            WeiboVO weiboVO = new WeiboVO();
            BeanUtils.copyProperties(weibo, weiboVO);
            String userName = userMapper.selectById(weibo.getUser()).getName();
            weiboVO.setUserName(userName);
            return weiboVO;
        });
    }

    /**
     * 按用户页获取微博
     *
     * @param pageNum 页码
     * @return 微博列表
     */
    @Override
    public IPage<Weibo> getWeiboByUserPage(Integer pageNum) {
        Page<WeiboDTO> page = new Page<>(pageNum, 10);
        QueryWrapper<WeiboDTO> queryWrapper = new QueryWrapper<>();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        queryWrapper.eq("userId", user.getId())
                .orderByDesc("timeStamp");
        IPage<WeiboDTO> weiboIPage = baseMapper.selectPage(page, queryWrapper);
        return weiboIPage.convert(weibo -> {
            Weibo w = new Weibo();
            BeanUtils.copyProperties(weibo, w);
            return w;
        });
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
        WeiboDTO w = new WeiboDTO();
        BeanUtils.copyProperties(weibo, w);
        w.setLikeNum(0);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        w.setUser(user.getId());
        baseMapper.insert(w);
    }

    /**
     * 喜欢微博
     *
     * @param id 微博id
     */
    @Override
    public void likeWeibo(Integer id) {
        WeiboDTO weibo = baseMapper.selectById(id);
        weibo.setLikeNum(weibo.getLikeNum() + 1);
        baseMapper.updateById(weibo);
    }

    /**
     * 更新微博
     *
     * @param weibo 更新内容
     */
    @Override
    public void updateWeibo(Weibo weibo) {
        weibo.setTime(new Date());
        WeiboDTO w = new WeiboDTO();
        BeanUtils.copyProperties(weibo, w);
        baseMapper.updateById(w);
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
