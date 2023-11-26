package org.netty.entry.byteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.netty.util.ByteBufUtil;

/**
 * @Title: SliceDemo
 * @Author Hannibal
 * @Package org.netty.entry.byteBuf
 * @Date 26/11/2023 10:05
 * @Description: TODO
 */
@Slf4j
public class SliceDemo {
    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator
                .DEFAULT
                .buffer(16);
        byte[] src = {'a', 'b', 'c', 'd', 'e'};
        buffer.writeBytes(src);
        ByteBufUtil.log(buffer);

        /**
         * 在切片过程中并没有发生数据复制,只是多维护了一对读写指针
         */
        ByteBuf bf1 = buffer.slice(0, 3);

        ByteBuf bf2 = buffer.slice(3, src.length);

        ByteBufUtil.log(bf1);
        ByteBufUtil.log(bf2);

        /**
         * 对slice出来的byteBuf 进行修改
         */
        bf1.setByte(0, '0');

        ByteBufUtil.log(buffer);
    }
}
