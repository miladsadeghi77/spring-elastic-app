package com.miladsadeghi.springelasticapp.repository.elastic;

import com.miladsadeghi.springelasticapp.entity.elastic.ProductElastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductElasticRepository extends ElasticsearchRepository<ProductElastic,String> {
}
