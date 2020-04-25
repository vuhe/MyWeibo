package site.zhuhe.weibo.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Json 工具类
 * 依赖 jackson
 *
 * @className: JsonUtils
 * @author: zhuhe
 * @date: 2020/4/25 19:37
 */
@Slf4j
public class JsonUtils {
    private final static ObjectMapper objMapper = new ObjectMapper();

    /**
     * Json 字符串转化成对象
     *
     * @param jsonString json 字符串
     * @param clazz 类型实例
     * @param <T> 目前类
     * @return 目标类
     * @throws Exception IO错误
     */
    public static <T> T toObj(String jsonString, Class<T> clazz) {
        objMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        try {
            return objMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            log.error("Json字符串转化成对象出错", e);
        }
        return null;
    }

    /**
     * javaBean 转化成json字符串
     *
     * @param obj 对象
     * @return json 字符串
     * @throws Exception IO错误
     */
    public static String toJson(Object obj) {
        if (obj instanceof Integer || obj instanceof Long || obj instanceof Float ||
                obj instanceof Double || obj instanceof Boolean || obj instanceof String) {
            return String.valueOf(obj);
        }
        try {
            return objMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("转化成json字符串", e);
        }
        return null;
    }
}
