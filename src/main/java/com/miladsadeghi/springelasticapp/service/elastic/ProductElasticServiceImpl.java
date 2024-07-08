package com.miladsadeghi.springelasticapp.service.elastic;

import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import com.miladsadeghi.springelasticapp.entity.Product;
import com.miladsadeghi.springelasticapp.entity.elastic.ProductElastic;
import com.miladsadeghi.springelasticapp.mapper.ProductMapper;
import com.miladsadeghi.springelasticapp.repository.elastic.ProductElasticRepository;
import com.miladsadeghi.springelasticapp.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductElasticServiceImpl {
    private ProductElasticRepository productElasticRepository;
    private ProductServiceImpl productServiceImpl;
    private ProductMapper productMapper;
    @Autowired

    public ProductElasticServiceImpl(ProductElasticRepository productElasticRepository, ProductServiceImpl productServiceImpl, ProductMapper productMapper) {
        this.productElasticRepository = productElasticRepository;
        this.productServiceImpl = productServiceImpl;
        this.productMapper = productMapper;
    }
    public Iterable<ProductElastic> getAllProduct(){
       return productElasticRepository.findAll();
    }

    public List<ProductElastic> findByNameOrCategory(String keyword){
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
