package com.ybinsure.auth.bean.security;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ybinsure.auth.model.transfer.Result;

import java.io.IOException;

/**
 * 自定义验证异常转换器
 */
public class CustomOauthExceptionSerializer extends StdSerializer<CustomAuthException> {

    public CustomOauthExceptionSerializer() {
        super(CustomAuthException.class);
    }

    @Override
    public void serialize(CustomAuthException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("status", String.valueOf(Result.AUTH_ERROR));
        gen.writeStringField("msg", Result.AUTH_ERROR_MSG);
        gen.writeEndObject();
    }
}