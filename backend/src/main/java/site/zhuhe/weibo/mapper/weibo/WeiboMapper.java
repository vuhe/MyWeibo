package site.zhuhe.weibo.mapper.weibo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import site.zhuhe.weibo.entity.weibo.Weibo;

import java.util.List;

/**
 * 微博 Mapper 接口
 *
 * @className: WeiboMapper
 * @author: zhuhe
 * @date: 2020/4/20 18:34
 */
@Mapper
public interface WeiboMapper extends BaseMapper<Weibo> {
}
