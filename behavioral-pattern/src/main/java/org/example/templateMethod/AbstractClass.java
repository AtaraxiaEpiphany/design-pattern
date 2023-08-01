package org.example.templateMethod;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: AbstractClass
 * @Author Hannibal
 * @Package org.example.templateMethod
 * @Date 01/08/2023 21:53
 * @Description: TODO Abstract Class 抽象类
 */
public abstract class AbstractClass {
    /**
     * template method.
     * 定义了炒菜的基本流程...算法的框架.
     * 声明为final,确保不被子类重写
     */
    public final void coolProcess() {
        pourOil();
        heatOil();
        pourVegetable();
        pourSauce();
        fry();
    }

    /**
     * Concrete method.
     */
    public void pourOil() {
        FG_GREEN.print("倒油...");
    }

    public void heatOil() {
        FG_GREEN.print("热油...");
    }

    /**
     * Abstract method.
     * 炒菜步骤不一样
     */
    public abstract void pourVegetable();

    /**
     * 调料不一样
     */
    public abstract void pourSauce();

    /**
     * 炒菜
     */
    public void fry() {
        FG_GREEN.print("翻炒...");
    }

}
