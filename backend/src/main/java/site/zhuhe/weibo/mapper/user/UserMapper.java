package site.zhuhe.weibo.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.zhuhe.weibo.entity.user.User;

/**
 * 用户 Mapper 接口
 *
 * @className: UserMapper
 * @author: zhuhe
 * @date: 2020/4/20 18:42
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
