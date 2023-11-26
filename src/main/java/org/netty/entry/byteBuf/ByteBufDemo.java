package org.netty.entry.byteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.netty.util.ByteBufUtil;

import java.nio.charset.Charset;

/**
 * @Title: ByteBufDemo
 * @Author Hannibal
 * @Package org.netty.entry.byteBuf
 * @Date 25/11/2023 16:03
 * @Description: TODO
 */
@Slf4j
public class ByteBufDemo {
    public static void main(String[] args) {
        ByteBuf byteBuf = ByteBufAllocator
                .DEFAULT
                .buffer()
                .writeBytes("byte buf".getBytes(Charset.defaultCharset()));
        log.info("{}", byteBuf);
        ByteBufUtil.log(byteBuf);
    }
}
