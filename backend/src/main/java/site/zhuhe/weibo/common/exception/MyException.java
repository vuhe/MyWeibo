package site.zhuhe.weibo.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import site.zhuhe.weibo.common.exception.enums.ErrorEnum;

/**
 * @className: MyException
 * @author: zhuhe
 * @date: 2020/4/20 18:06
 * @description: 自定义异常
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MyException extends RuntimeException {
    private String msg;
    private int code = 500;

    public MyException() {
        super(ErrorEnum.UNKNOWN.getMsg());
        this.msg = ErrorEnum.UNKNOWN.getMsg();
    }


    public MyException(ErrorEnum eEnum, Throwable e) {
        super(eEnum.getMsg(), e);
        this.msg = eEnum.getMsg();
        this.code = eEnum.getCode();
    }

    public MyException(ErrorEnum eEnum) {
        this.msg = eEnum.getMsg();
        this.code = eEnum.getCode();
    }

    public MyException(String exception) {
        this.msg = exception;
    }
}
