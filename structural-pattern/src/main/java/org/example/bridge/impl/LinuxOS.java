package org.example.bridge.impl;

import org.example.bridge.OperatingSystem;
import org.example.bridge.VideoFile;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: LinuxOS
 * @Author Hannibal
 * @Package org.example.bridge.impl
 * @Date 30/07/2023 21:54
 * @Description: Concrete Abstraction 具体抽象化
 */
public class LinuxOS extends OperatingSystem {
    public LinuxOS(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void display(String fileName) {
        FG_GREEN.print("linux...");
        videoFile.decode(fileName);
    }
}
