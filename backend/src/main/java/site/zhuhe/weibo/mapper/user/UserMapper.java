package site.zhuhe.weibo.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import site.zhuhe.weibo.entity.user.User;

/**
 * 用户 Mapper 接口
 *
 * @className: UserMapper
 * @author: zhuhe
 * @date: 2020/4/20 18:42
 */
@Mapper
public interface UserMapper {
    /**
     * 查找用户名
     *
     * @param username 用户名
     * @return 用户类
     */
    User loadUserByUsername (String username);

    /**
     * 获取用户实例
     *
     * @return 用户
     */
    User getUser();
}
