package com.demo.security.contract.exception;

import com.demo.security.contract.constant.HttpEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: BusinessException
 * @Author Hannibal
 * @Package com.demo.security.core.exception
 * @Date 23/08/2023 20:07
 * @Description: TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    private String message;
    private String status;
    public BusinessException(HttpEnum httpEnum) {
        this.message = httpEnum.getMessage();
        this.status = httpEnum.getCode();
    }
}
