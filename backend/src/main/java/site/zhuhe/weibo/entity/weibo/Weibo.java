package site.zhuhe.weibo.entity.weibo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import site.zhuhe.weibo.common.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @className: Weibo
 * @author: zhuhe
 * @date: 2020/4/20 18:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "微博对象", description = "微博信息")
public class Weibo extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "微博内容")
    @TableField(value = "content")
    private String content;

    @ApiModelProperty(value = "发布时间")
    @TableField(value = "timeStamp")
    private Date time;
}
