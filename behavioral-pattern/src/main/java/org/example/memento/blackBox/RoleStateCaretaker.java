package org.example.memento.blackBox;

/**
 * @Title: RoleStateCaretaker
 * @Author Hannibal
 * @Package org.example.memento.blackBox
 * @Date 06/08/2023 15:17
 * @Description: Caretaker 管理者,负责保存和恢复`备忘录对象的对象`,不能直接操作备忘录对象内部数据
 */
public class RoleStateCaretaker {
    private Memento memento;

    public Memento getMemento() {
        /**
         * Revert.
         */
        return memento;
    }

    public void setMemento(Memento memento) {
        /**
         * Save.
         */
        this.memento = memento;
    }
}
