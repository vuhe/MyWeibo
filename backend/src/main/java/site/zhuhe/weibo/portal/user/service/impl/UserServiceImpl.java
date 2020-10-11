package site.zhuhe.weibo.portal.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;
import site.zhuhe.weibo.common.Result;
import site.zhuhe.weibo.common.exception.enums.ErrorEnum;
import site.zhuhe.weibo.entity.user.User;
import site.zhuhe.weibo.mapper.user.UserMapper;
import site.zhuhe.weibo.portal.user.service.intf.UserService;

@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /**
     * 注册用户
     *
     * @param user 新用户
     */
    @Override
    public Result<?> registeredUser(User user) {
        user.setId(null);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", user.getName());
        if (count(queryWrapper) > 0) {
            return Result.ofErrorEnum(ErrorEnum.USERNAME_WRONG);
        }
        String encodePassword = new Sha256Hash(user.getPwd(), user.getName()).toHex();
        user.setPwd(encodePassword);
        baseMapper.insert(user);
        return Result.ofSuccess();
    }

    /**
     * 通过用户名查找用户
     *
     * @param name 用户名
     * @return 用户
     */
    @Override
    public User searchUserByName(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name)
                .last("LIMIT 1");
        return getOne(queryWrapper);
    }
}
