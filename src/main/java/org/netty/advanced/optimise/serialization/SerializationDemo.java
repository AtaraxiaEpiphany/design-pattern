package org.netty.advanced.optimise.serialization;

import io.netty.channel.embedded.EmbeddedChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Serialization
 * @Author Hannibal
 * @Package org.netty.advanced.optimise
 * @Date 02/12/2023 16:37
 * @Description: 序列化
 */
@Slf4j
public class SerializationDemo {

    public static void main(String[] args) {
        int ordinal = Serializer.Algorithm.JSON.ordinal();//返回枚举顺序 ordinal
        log.info("ordinal ==> " + ordinal);
        EmbeddedChannel channel = new EmbeddedChannel();
    }
}
