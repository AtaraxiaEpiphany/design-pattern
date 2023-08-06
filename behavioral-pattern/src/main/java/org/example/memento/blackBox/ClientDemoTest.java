package org.example.memento.blackBox;

import com.common.util.LogUtil;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.memento.blackBox
 * @Date 06/08/2023 15:35
 * @Description: TODO
 */
@SuppressWarnings("all")
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
        /**
         * Narrow Interface.窄接口,没有任何操作方法.
         */
        Memento memento = gameRole.saveState();

        roleStateCaretaker.setMemento(memento);

        LogUtil.FG_YELLOW.print("决战后...");
        gameRole.fight();
        gameRole.showState();

        LogUtil.FG_YELLOW.print("恢复前...");
        gameRole.revertState(roleStateCaretaker.getMemento());

        LogUtil.FG_YELLOW.print("恢复后...");
        gameRole.showState();
    }
}

