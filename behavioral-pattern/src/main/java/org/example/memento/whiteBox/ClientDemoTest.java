package org.example.memento.whiteBox;

import com.common.util.LogUtil;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.memento.whiteBox
 * @Date 06/08/2023 15:18
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        LogUtil.FG_YELLOW.print("决战前...");
        GameRole gameRole = new GameRole();
        /**
         * 初始状态
         */
        gameRole.initState();
        gameRole.showState();
        /**
         * 通过管理者备份
         */
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setMemento(gameRole.saveState());

        LogUtil.FG_YELLOW.print("决战后...");
        gameRole.fight();
        gameRole.showState();

        LogUtil.FG_YELLOW.print("恢复前...");
        gameRole.revertState(roleStateCaretaker.getMemento());

        LogUtil.FG_YELLOW.print("恢复后...");
        gameRole.showState();
    }
}
