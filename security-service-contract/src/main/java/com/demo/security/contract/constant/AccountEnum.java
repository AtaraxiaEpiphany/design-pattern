package com.demo.security.contract.constant;

/**
 * @Title: AccountEnum
 * @Author Hannibal
 * @Package com.demo.security.contract.constant
 * @Date 23/08/2023 20:43
 * @Description: TODO
 */
public enum AccountEnum {
    ACCOUNT_EXPIRED("0", "账号已过期"),
    ACCOUNT_NON_EXPIRED("1", "账号未过期"),
    ACCOUNT_LOCKED("0", "账号已锁定"),
    ACCOUNT_NON_LOCKED("1", "账号未锁定"),
    CREDENTIALS_EXPIRED("0", "凭证已过期"),
    CREDENTIALS_NON_EXPIRED("1", "凭证未过期"),
    ENABLED("1", "账号已启用"),
    NON_ENABLED("0", "账号未启用");

    private final String code;
    private final String description;

    AccountEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
