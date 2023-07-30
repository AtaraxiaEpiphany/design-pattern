package org.example.bridge;

/**
 * @Title: OperatingSystem 操作系统类
 * @Author Hannibal
 * @Package org.example.bridge
 * @Date 30/07/2023 21:50
 * @Description: Abstraction 抽象化角色
 */
public abstract class OperatingSystem {
    /**
     * 维护一个指向Implementor(实现化角色)的引用
     */
    protected VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void display(String fileName);
}
