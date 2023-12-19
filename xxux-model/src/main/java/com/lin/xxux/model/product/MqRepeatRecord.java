package com.lin.xxux.model.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.lin.xxux.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * mq去重表
 * @TableName mq_repeat_record
 */
@TableName(value ="mq_repeat_record")
@Data
@ApiModel(value = "mq去重表")
public class MqRepeatRecord extends BaseEntity {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 业务编号
     */
    @ApiModelProperty(value = "业务编号")
    private String businessNo;

    private static final long serialVersionUID = 1L;



}