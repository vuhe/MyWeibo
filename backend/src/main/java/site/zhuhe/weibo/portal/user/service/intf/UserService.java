package site.zhuhe.weibo.portal.user.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import site.zhuhe.weibo.common.Result;
import site.zhuhe.weibo.entity.user.User;

public interface UserService extends IService<User> {
    /**
     * 注册用户
     *
     * @param user 新用户
     */
    Result<?> registeredUser(User user);

    /**
     * 通过用户名查找用户
     *
     * @param name 用户名
     * @return 用户
     */
    User searchUserByName(String name);
}
