package org.example.observer.impl;

import org.example.observer.Observer;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: WechatUser
 * @Author Hannibal
 * @Package org.example.observer.impl
 * @Date 05/08/2023 22:38
 * @Description: TODO Concrete Observer 具体观察者
 */
public class WechatUser implements Observer {

    private String name;

    public WechatUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        FG_YELLOW.print("name ==> %s, message ==> %s", name, message);
    }
}
