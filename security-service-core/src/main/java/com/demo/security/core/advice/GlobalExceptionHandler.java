package com.demo.security.core.advice;

import com.demo.security.contract.common.ResponseResult;
import com.demo.security.contract.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.demo.security.contract.constant.HttpEnum.INTERNAL_SERVER_ERROR;

/**
 * @Title: GlobalExceptionHandler
 * @Author Hannibal
 * @Package com.demo.security.core.exception
 * @Date 23/08/2023 20:05
 * @Description: TODO
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseResult businessError(BusinessException businessException) {
        log.error("catch exception: " + businessException);
        return ResponseResult.fail(businessException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult businessError(Exception businessException) {
        log.error("catch exception:{}", businessException);
        return ResponseResult.fail(INTERNAL_SERVER_ERROR);
    }
}
