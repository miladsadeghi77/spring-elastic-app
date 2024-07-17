package com.miladsadeghi.springelasticapp.service.elastic;

import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.WildcardQuery;
import com.miladsadeghi.springelasticapp.entity.Product;
import com.miladsadeghi.springelasticapp.entity.elastic.ProductElastic;
import com.miladsadeghi.springelasticapp.mapper.ProductMapper;
import com.miladsadeghi.springelasticapp.repository.elastic.ProductElasticRepository;
import com.miladsadeghi.springelasticapp.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductElasticServiceImpl {
    private ProductElasticRepository productElasticRepository;
    private ProductServiceImpl productServiceImpl;
    private ProductMapper productMapper;
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    public ProductElasticServiceImpl(ProductElasticRepository productElasticRepository, ProductServiceImpl productServiceImpl, ProductMapper productMapper, ElasticsearchTemplate elasticsearchTemplate) {
        this.productElasticRepository = productElasticRepository;
        this.productServiceImpl = productServiceImpl;
        this.productMapper = productMapper;
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public Iterable<ProductElastic> getAllProduct(){
       return productElasticRepository.findAll();
    }

    public List<ProductElastic> findByNameOrCategory(String keyword){
        //MatchQuery matchQuery = QueryBuilders.match().field("name").query(keyword).build();
        WildcardQuery wildcardQuery = QueryBuilders.wildcard().field("name").value("*" + keyword + "*").build();
        NativeQuery nativeQuery = new NativeQuery(wildcardQuery._toQuery());
        SearchHits<ProductElastic> searchHits = elasticsearchTemplate.search(nativeQuery, ProductElastic.class);
        List<ProductElastic> productElasticList = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        List<ProductElastic> productElasticByNameOrCategory = productElasticRepository.findProductElasticByName(keyword);
        return productElasticByNameOrCategory;
    }
    public void saveProductFormDBToElastic(){
        List<Product> productList = productServiceImpl.findAll();
        for (Product product: productList) {
            productElasticRepository.save(productMapper.convertToElastic(product));
        }
    }
}
