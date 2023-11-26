package org.netty.advanced.byteToMessageDecoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: DecoderDemo
 * @Author Hannibal
 * @Package org.netty.advanced.byteToMessageDecoder
 * @Date 26/11/2023 11:55
 * @Description: TODO
 */
@Slf4j
public class DecoderDemo {

    public static void main(String[] args) {
        /**
         *
         * @param maxFrameLength
         *        the maximum length of the frame.  If the length of the frame is
         *        greater than this value, {@link TooLongFrameException} will be
         *        thrown.
         * @param lengthFieldOffset
         *        the offset of the length field
         * @param lengthFieldLength
         *        the length of the length field
         * @param lengthAdjustment
         *        the compensation value to add to the value of the length field
         * @param initialBytesToStrip
         *        the number of first bytes to strip out from the decoded frame
         *
         * BEFORE DECODE (14 bytes)         AFTER DECODE (14 bytes)
         * +--------+----------------+      +--------+----------------+
         * | Length | Actual Content |----->| Length | Actual Content |
         * | 0x000E | "HELLO, WORLD" |      | 0x000E | "HELLO, WORLD" |
         * +--------+----------------+      +--------+----------------+
         */
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(
                new LengthFieldBasedFrameDecoder(16,
                        0, 4, 0, 4),
                new LoggingHandler());
        ByteBuf buffer = ByteBufAllocator.DEFAULT
                .buffer();

        send(buffer, "hello TLV!");

        send(buffer, "hi!");

        embeddedChannel.writeInbound(buffer);

    }

    private static void send(ByteBuf buffer, String content) {
        byte[] contentBytes = content.getBytes();
        // L: length
        buffer.writeInt(contentBytes.length);
        // V: Value
        buffer.writeBytes(contentBytes);
    }
}
