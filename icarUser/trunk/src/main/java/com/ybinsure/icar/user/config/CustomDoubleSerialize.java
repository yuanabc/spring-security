package com.ybinsure.icar.user.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Jackson序列化输出Double保留2位小数
 *
 * @author HANHT
 * @version 2018/7/19 17:31
 */
public class CustomDoubleSerialize extends JsonSerializer<Double> {

    @Override
    public void serialize(Double value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value != null) {
            jsonGenerator.writeNumber(new BigDecimal(Double.toString(value)).setScale(2, BigDecimal.ROUND_HALF_UP));
        }
    }
}
