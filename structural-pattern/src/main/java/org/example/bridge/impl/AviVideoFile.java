package org.example.bridge.impl;

import org.example.bridge.VideoFile;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: AviVideoFile Avi视频文件
 * @Author Hannibal
 * @Package org.example.bridge.impl
 * @Date 30/07/2023 21:47
 * @Description: Concrete Implementor 具体实现化角色
 */
public class AviVideoFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        FG_YELLOW.print("Avi file: ==> %s", fileName);
    }
}
