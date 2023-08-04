package org.example.command;

import java.util.ArrayList;
import java.util.List;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: Waiter 服务员类
 * @Author Hannibal
 * @Package org.example.command
 * @Date 04/08/2023 21:51
 * @Description: TODO Invoker 调用者
 */
public class Waiter {
    /**
     * 调用者持有(多个)命令对象.
     */
    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command command) {
        this.commands.add(command);
    }

    public void orderUp() {
        FG_GREEN.print("接收到订单...");
        commands.forEach(command -> command.execute());
    }
}
