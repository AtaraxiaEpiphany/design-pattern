package org.example.bridge;

import org.example.bridge.impl.AviVideoFile;
import org.example.bridge.impl.LinuxOS;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.bridge
 * @Date 30/07/2023 21:57
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        OperatingSystem os = new LinuxOS(new AviVideoFile());
        os.display("linux.avi");
    }
}
