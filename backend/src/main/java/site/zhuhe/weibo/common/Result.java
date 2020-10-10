package site.zhuhe.weibo.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import site.zhuhe.weibo.common.exception.MyException;
import site.zhuhe.weibo.common.exception.enums.ErrorEnum;

/**
 * @className: Result
 * @author: zhuhe
 * @date: 2020/4/20 18:04
 * @description: 通用返回类
 */
@Getter
@JsonSerialize(using = ResultSerializer.class)
public class Result<T> {
    private int code;
    private String msg;
    private String objName = "";
    private T object = null;

    private Result() {}

    private Result(Integer code, String message, String name, T data) {
        this.code = code;
        this.msg = message;
        this.objName = name;
        this.object = data;
    }

    public static <T> Result<T> of(Integer code, String message, String name, T data) {
        return new Result<>(code, message, name, data);
    }

    public static <T> Result<T> of(Integer code, String message) {
        return new Result<>(code, message, "", null);
    }

    public static <T> Result<T> ofSuccessWithDate(String name, T date) {
        return of(200, "成功", name, date);
    }

    public static <T> Result<T> ofSuccess() {
        return of(200, "成功");
    }

    public static <T> Result<T> ofException(MyException e) {
        return of(e.getCode(), e.getMessage());
    }

    public static <T> Result<T> ofErrorEnum(ErrorEnum e) {
        return of(e.getCode(), e.getMsg());
    }
}
