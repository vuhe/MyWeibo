package site.zhuhe.weibo.mapper.weibo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.zhuhe.weibo.entity.weibo.WeiboDTO;

/**
 * 微博 Mapper 接口
 *
 * @className: WeiboMapper
 * @author: zhuhe
 * @date: 2020/4/20 18:34
 */
@Mapper
@Repository
public interface WeiboMapper extends BaseMapper<WeiboDTO> {
}
