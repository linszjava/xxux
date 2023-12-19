package com.lin.xxux.model.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.lin.xxux.model.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 三级分类表
 * @TableName base_category_trademark
 */
@TableName(value ="base_category_trademark")
@Data
public class BaseCategoryTrademark extends BaseEntity {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 三级级分类id
     */
    @ApiModelProperty(value = "三级级分类id")
    private Long category3Id;

    /**
     * 品牌id
     */
    @ApiModelProperty(value = "品牌id")
    private Long trademarkId;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}