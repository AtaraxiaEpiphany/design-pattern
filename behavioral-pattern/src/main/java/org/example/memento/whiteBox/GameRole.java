package org.example.memento.whiteBox;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: GameRole 游戏角色
 * @Author Hannibal
 * @Package org.example.memento.whiteBox
 * @Date 06/08/2023 15:08
 * @Description: TODO Originator 发起者
 */
public class GameRole {
    private int vit;//生命值
    private int atk;//攻击力
    private int def;//防御力

    public void initState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    public RoleStateMemento saveState() {
        return new RoleStateMemento(vit, atk, def);
    }

    /**
     * 恢复状态.
     */
    public void revertState(RoleStateMemento memento) {
        this.vit = memento.getVit();
        this.atk = memento.getAtk();
        this.def = memento.getDef();
    }

    public void showState() {
        FG_GREEN.print("""
                vit ==>   %s
                atk ==>   %s
                def ==>   %s
                """, vit, atk, def);
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
