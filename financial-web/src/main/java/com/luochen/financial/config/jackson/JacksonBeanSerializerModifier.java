package com.luochen.financial.config.jackson;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.util.Collection;
import java.util.List;

/**
 * Jackson Bean 序列化器
 * <p>声明了不同类型的参数的空值转换配置</p>
 * @author luochenfx
 * @see CustomizeNullJsonSerializer
 */
public class JacksonBeanSerializerModifier extends BeanSerializerModifier {

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
        for(BeanPropertyWriter beanPropertyWriter:beanProperties){
            JsonSerializer<Object> serializer = getJsonSerializer(beanPropertyWriter);
            if(serializer!=null){
                beanPropertyWriter.assignNullSerializer(serializer);
            }
        }
        return beanProperties;
    }

    public JsonSerializer<Object> getJsonSerializer(BeanPropertyWriter beanPropertyWriter){
        if (isArrayType(beanPropertyWriter)) {
            return new CustomizeNullJsonSerializer.NullArrayJsonSerializer();
        }

        if (isStringType(beanPropertyWriter)) {
            return new CustomizeNullJsonSerializer.NullStringJsonSerializer();
        }

        if (isBooleanType(beanPropertyWriter)) {
            return new CustomizeNullJsonSerializer.NullBooleanJsonSerializer();
        }

        if (isNumberType(beanPropertyWriter)) {
            return new CustomizeNullJsonSerializer.NullNumberJsonSerializer();
        }
        return null;
    }
    /**
     * 是否是数组
     */
    private boolean isArrayType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getType().getRawClass();
        return clazz.isArray() || Collection.class.isAssignableFrom(clazz);
    }

    /**
     * 是否是String
     */
    private boolean isStringType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getType().getRawClass();
        return CharSequence.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz);
    }

    /**
     * 是否是数值类型
     */
    private boolean isNumberType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getType().getRawClass();
        return Number.class.isAssignableFrom(clazz);
    }

    /**
     * 是否是boolean
     */
    private boolean isBooleanType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getType().getRawClass();
        return clazz.equals(Boolean.class);
    }
}
