package site.zhuhe.weibo.entity.weibo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "weibo")
@ApiModel(value = "微博对象", description = "微博信息")
public class WeiboDTO extends Weibo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableField(value = "userId")
    private Integer user;

    @ApiModelProperty(value = "喜欢数")
    @TableField(value = "likeNum")
    private Integer likeNum;
}
