package org.netty.entry.byteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import lombok.extern.slf4j.Slf4j;
import org.netty.util.ByteBufUtil;

import java.nio.charset.Charset;

/**
 * @Title: CompositeDemo
 * @Author Hannibal
 * @Package org.netty.entry.byteBuf
 * @Date 26/11/2023 10:31
 * @Description: TODO
 */
@Slf4j
public class CompositeDemo {
    public static void main(String[] args) {
        ByteBuf bf1 = ByteBufAllocator.DEFAULT
                .buffer()
                .writeBytes("byte buf 1".getBytes(Charset.defaultCharset()));
        ByteBuf bf2 = ByteBufAllocator.DEFAULT
                .buffer()
                .writeBytes("byte buf 2".getBytes(Charset.defaultCharset()));
        /**
         * 可以逻辑上将byteBuf 组合在一起, 体现了零拷贝的思想.
         */
        CompositeByteBuf compositeBuffer = ByteBufAllocator.DEFAULT.compositeBuffer();
        /**
         * 自动调整写指针.
         */
        compositeBuffer.addComponents(true, bf1, bf2);

        ByteBufUtil.log(compositeBuffer);
    }
}
