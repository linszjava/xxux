package com.lin.xxux.service.search.reposity;

import com.lin.xxux.model.search.SkuEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/18 03:18
 */
public interface SkuRepository extends ElasticsearchRepository<SkuEs,Long> {
}
