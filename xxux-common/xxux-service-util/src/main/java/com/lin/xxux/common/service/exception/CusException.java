package com.lin.xxux.common.service.exception;

import com.lin.xxux.common.service.enums.ResultEnum;
import lombok.Data;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/11/20 16:19
 */
@Data
public class CusException extends RuntimeException {

    private Integer code;

    public CusException(String message,Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类对象
     * @param resultEnum
     */
    public CusException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }


}
