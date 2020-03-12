package com.mall.common.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;

/**
 * @author hc
 * @classname ElasticSearchController
 * @description 也是两种，一种是repository,一种是highLevelClient
 * @date 2020/3/5
 */
@Controller
public class ElasticSearchController {

    @Autowired
    private RestHighLevelClient highLevelClient;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public void createIndex() {
        elasticsearchTemplate.createIndex(Item.class);
    }

    public void deleteIndex() {
        elasticsearchTemplate.deleteIndex(Item.class);
    }

}
