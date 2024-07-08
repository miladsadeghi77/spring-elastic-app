package com.miladsadeghi.springelasticapp.repository.elastic;

import com.miladsadeghi.springelasticapp.entity.elastic.ProductElastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductElasticRepository extends ElasticsearchRepository<ProductElastic,String> {
   // @Query("select a from appointment a where a.appointmentCode = :appointmentCode ")
   @Query("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
   List<ProductElastic> findProductElasticByName(String keyword);
}
