package site.zhuhe.weibo.common.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @className: BaseEntity
 * @author: zhuhe
 * @date: 2020/4/20 18:13
 * @description: 基础实体类
 */
@Data
public class BaseEntity {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;
}
