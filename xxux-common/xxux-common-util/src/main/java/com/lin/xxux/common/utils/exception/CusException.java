package com.lin.xxux.common.utils.exception;

import cn.hutool.core.util.StrUtil;
import com.lin.xxux.common.utils.enums.ResultEnum;
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

    private String msg;

    public CusException(String message,Integer code) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    /**
     * 接收枚举类对象
     * @param resultEnum
     */
    public CusException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
    }
    public CusException(String msg, Object... args){
        super(StrUtil.format(msg,args));
        this.code = 500;
        this.msg = StrUtil.format(msg,args);
    }


}
