package org.example.memento.whiteBox;

/**
 * @Title: RoleStateMemento
 * @Author Hannibal
 * @Package org.example.memento.whiteBox
 * @Date 06/08/2023 15:12
 * @Description: Memento 备忘录,存储发起人的对象状态.
 */
public class RoleStateMemento {
    private int vit;//生命值
    private int atk;//攻击力
    private int def;//防御力

    public RoleStateMemento() {
    }

    public RoleStateMemento(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
