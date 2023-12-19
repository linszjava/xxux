package com.lin.xxux.common.service.exception;

import com.lin.xxux.common.service.result.Result;
import com.lin.xxux.common.utils.exception.CusException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>全局异常处理类</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/11/20 16:17
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(CusException.class)
    public Result cusExceptionHandler(CusException e) {
        e.printStackTrace();
        return Result.build(null,e.getCode(),e.getMessage());
    }
}
