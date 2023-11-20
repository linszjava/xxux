package com.lin.xxux.common.service.result;

import cn.hutool.core.util.ObjectUtil;
import com.lin.xxux.common.service.enums.ResultEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/11/20 16:06
 */
@Data
@Accessors(chain = true)
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    private Result() {}

   public static<T> Result<T> build(T data, ResultEnum resultEnum) {
       Result<T> result = new Result<>();
       if (ObjectUtil.isNotEmpty(data)) {
           result.setData(data);
       }
       result.setCode(resultEnum.getCode())
               .setMessage(resultEnum.getMessage());

       return result;
   }

   public static<T> Result<T> build(T data, Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code)
                .setMessage(message)
                .setData(data);
       return result;
   }

    /**
     * 成功且返回数据
     * @param data
     * @return
     * @param <T>
     */
   public static<T> Result<T> ok(T data) {
       return build(data, ResultEnum.SUCCESS);
   }
   public static<T> Result<T> ok() {
       return build(null, ResultEnum.SUCCESS);
   }

    /**
     * 失败但返回数据
     * @param data
     * @return
     * @param <T>
     */
    public static<T> Result<T> fail(T data) {
         return build(data, ResultEnum.SUCCESS);
    }

    /**
     * 失败且无返回数据
     * @return
     * @param <T>
     */
    public static<T> Result<T> fail() {
        return build(null, ResultEnum.FAIL);
    }
}
