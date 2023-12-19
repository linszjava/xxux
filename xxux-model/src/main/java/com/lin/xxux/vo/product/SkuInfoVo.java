package com.lin.xxux.vo.product;
import com.lin.xxux.model.product.SkuAttrValue;
import com.lin.xxux.model.product.SkuImage;
import com.lin.xxux.model.product.SkuInfo;
import com.lin.xxux.model.product.SkuPoster;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class SkuInfoVo extends SkuInfo {

	@ApiModelProperty(value = "海报列表")
	private List<SkuPoster> skuPosterList;

	@ApiModelProperty(value = "属性值")
	private List<SkuAttrValue> skuAttrValueList;

	@ApiModelProperty(value = "图片")
	private List<SkuImage> skuImagesList;

}

