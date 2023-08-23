package com.demo.security.contract.common;

import com.demo.security.contract.constant.HttpEnum;
import com.demo.security.contract.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Title: ResponseResult
 * @Author Hannibal
 * @Package com.demo.security.contract.common
 * @Date 23/08/2023 20:10
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {

    private List<T> list;
    private String status;
    private String message;

    public static final ResponseResult EMPTY = new ResponseResult();

    public ResponseResult(List list, HttpEnum httpEnum) {
        this.list = list;
        this.status = httpEnum.getCode();
        this.message = httpEnum.getMessage();
    }

    public static ResponseResult ok(List list) {
        return new ResponseResult(list, HttpEnum.OK);
    }

    public static ResponseResult ok() {
        return EMPTY;
    }

    public static ResponseResult fail(HttpEnum httpEnum) {
        return new ResponseResult<>(null, httpEnum.getCode(), httpEnum.getMessage());
    }

    public static ResponseResult fail(BusinessException businessException) {
        return new ResponseResult(null, businessException.getStatus(), businessException.getMessage());
    }
}
