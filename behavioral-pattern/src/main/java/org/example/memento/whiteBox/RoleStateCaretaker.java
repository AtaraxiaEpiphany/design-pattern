package org.example.memento.whiteBox;

/**
 * @Title: RoleStateCaretaker
 * @Author Hannibal
 * @Package org.example.memento.whiteBox
 * @Date 06/08/2023 15:17
 * @Description: TODO Caretaker 管理者
 */
public class RoleStateCaretaker {
    private RoleStateMemento memento;

    public RoleStateMemento getMemento() {
        return memento;
    }

    public void setMemento(RoleStateMemento memento) {
        this.memento = memento;
    }
}
