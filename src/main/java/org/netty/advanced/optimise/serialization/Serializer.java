package org.netty.advanced.optimise.serialization;

import com.alibaba.fastjson2.JSONObject;
import lombok.NonNull;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @Title: Serializer
 * @Author Hannibal
 * @Package org.netty.advanced.optimise
 * @Date 02/12/2023 16:48
 * @Description: TODO
 */
public interface Serializer<T> {
    /**
     * 反序列化
     * @param bytes
     * @param clazz
     * @return
     * @param <T>
     */
    <T> T deserialize(byte[] bytes, Class<T> clazz);

    /**
     * 序列化
     * @param object
     * @return
     * @param <T>
     */
    <T> byte[] serialize(T object);

    /**
     * 枚举类型定义是编译时期确定,泛型具体类型是运行时期确定.
     * 因此Serializer<T>编译时报错.
     */
    enum Algorithm implements Serializer<Object> {
        JDK {
            @Override
            public <T> T deserialize(byte[] bytes, Class<T> clazz) {
                try {
                    try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
                        T object = (T) ois.readObject();
                        return object;
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Deserialize fail...", e);
                }
            }

            @Override
            public <T> byte[] serialize(@NonNull T object) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(bos);
                    oos.writeObject(object);
                    return bos.toByteArray();
                } catch (IOException e) {
                    throw new RuntimeException("Serialize fail...", e);
                }
            }
        },

        JSON {
            @Override
            public <T> T deserialize(byte[] bytes, Class<T> clazz) {
                String json = new String(bytes, StandardCharsets.UTF_8);
                return JSONObject.parseObject(json, clazz);
            }

            @Override
            public <T> byte[] serialize(T object) {
                String json = JSONObject.toJSONString(Objects.requireNonNull(object));
                return json.getBytes(StandardCharsets.UTF_8);
            }
        };

    }


}
