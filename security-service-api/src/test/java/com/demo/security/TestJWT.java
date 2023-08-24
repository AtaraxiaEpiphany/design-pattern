package com.demo.security;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSONObject;
import com.demo.security.contract.model.RoleEntity;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: TestJWT
 * @Author Hannibal
 * @Package com.demo.security
 * @Date 24/08/2023 20:10
 * @Description: TODO
 */

public class TestJWT {
    private String secret = "secret";

    @Test
    public void test() {
        RoleEntity role = new RoleEntity(IdUtil.getSnowflakeNextIdStr(), "admin", "super");
        Map<String, Object> map = BeanUtil.beanToMap(role);
        String token = JWTUtil.createToken(map, secret.getBytes());
        FG_GREEN.print("token ==> %s", token);
        JWT jwt = JWTUtil.parseToken(token);
        Object payload = jwt.getPayload();
        FG_GREEN.print("payload ==> %s",
                FG_GREEN.getJsonStr(JSONObject.parse(payload.toString())));

        boolean verify = JWTUtil.verify(token, secret.getBytes());
        FG_GREEN.print("verify with secret '%s' ==> %s", secret, verify);
        boolean v = JWTUtil.verify(token, ("incorrect " + secret).getBytes());
        FG_GREEN.print("verify with secret '%s' ==> %s", ("incorrect " + secret), v);
    }
}
