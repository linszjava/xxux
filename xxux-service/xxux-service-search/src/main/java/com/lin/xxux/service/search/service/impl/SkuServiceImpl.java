package com.lin.xxux.service.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.lin.xxux.enums.SkuType;
import com.lin.xxux.model.product.Category;
import com.lin.xxux.model.product.SkuInfo;
import com.lin.xxux.model.search.SkuEs;
import com.lin.xxux.service.client.product.service.ProductFeignClientService;
import com.lin.xxux.service.search.reposity.SkuRepository;
import com.lin.xxux.service.search.service.SkuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.checkerframework.checker.units.qual.A;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/18 03:04
 */
@Service
@Slf4j
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuRepository skuRepository;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ProductFeignClientService productFeignClientService;
    /**
     * 上架商品列表
     *
     * @param skuId
     */
    @Override
    public void upperSku(Long skuId) {
        log.info("上架商品列表upperSku:{}",skuId);
        SkuEs skuEs = new SkuEs();
        //1.查询sku基本信息
        SkuInfo skuInfo = productFeignClientService.getSkuInfo(skuId);
        if (ObjectUtils.isEmpty(skuInfo)) {
            return;
        }
        //2.查询分类
        Category category = productFeignClientService.getCategory(skuInfo.getCategoryId());
        if (ObjectUtils.isNotEmpty(category)) {
            skuEs.setCategoryId(category.getId()).setCategoryName(category.getName());
        }
        skuEs.setId(skuInfo.getId())
                .setKeyword(skuInfo.getSkuName()+","+skuEs.getCategoryName())
                .setWareId(skuInfo.getWareId())
                .setIsNewPerson(skuInfo.getIsNewPerson())
                .setImgUrl(skuInfo.getImgUrl())
                .setTitle(skuInfo.getSkuName());
        if (Objects.equals(skuInfo.getSkuType(), SkuType.COMMON.getCode())) {
            skuEs.setSkuType(0)
                    .setPrice(skuInfo.getPrice().doubleValue())
                    .setStock(skuInfo.getStock())
                    .setSale(skuInfo.getSale())
                    .setPerLimit(skuInfo.getPerLimit());
        }else {
            // TODO 待完善 秒杀商品
        }
        SkuEs save = skuRepository.save(skuEs);
        log.info("上架商品列表upperSku:{}", JSON.toJSONString(save));


    }

    /**
     * 下架商品列表
     *
     * @param skuId
     */
    @Override
    public void lowerSku(Long skuId) {
        skuRepository.deleteById(skuId);

    }
}
