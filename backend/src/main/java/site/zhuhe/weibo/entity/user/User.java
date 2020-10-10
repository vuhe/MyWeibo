package site.zhuhe.weibo.entity.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import site.zhuhe.weibo.common.base.BaseEntity;

/**
 * @className: User
 * @author: zhuhe
 * @date: 2020/4/20 18:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户对象", description = "用户信息")
public class User extends BaseEntity {

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String pwd;
}
