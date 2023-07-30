package org.example.bridge.impl;

import org.example.bridge.OperatingSystem;
import org.example.bridge.VideoFile;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: MacOS Mac系统
 * @Author Hannibal
 * @Package org.example.bridge.impl
 * @Date 30/07/2023 21:52
 * @Description: Concrete Abstraction 具体抽象化角色
 */
public class MacOS extends OperatingSystem {
    public MacOS(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void display(String fileName) {
        FG_GREEN.print("macos...");
        videoFile.decode(fileName);
    }
}
