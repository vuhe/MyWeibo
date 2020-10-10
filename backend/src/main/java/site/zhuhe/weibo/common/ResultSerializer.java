package site.zhuhe.weibo.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ResultSerializer extends StdSerializer<Result<?>> {
    public ResultSerializer() {
        this(null);
    }

    public ResultSerializer(Class<Result<?>> t) {
        super(t);
    }

    @Override
    public void serialize(
            Result value, JsonGenerator jGen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jGen.writeStartObject();
        jGen.writeNumberField("code", value.getCode());
        jGen.writeStringField("msg", value.getMsg());
        if (value.getObject() != null) {
            jGen.writeObjectField(value.getObjName(), value.getObject());
        }
        jGen.writeEndObject();
    }
}
