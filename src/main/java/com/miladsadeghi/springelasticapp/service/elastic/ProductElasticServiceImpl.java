package com.miladsadeghi.springelasticapp.service.elastic;

import com.miladsadeghi.springelasticapp.repository.elastic.ProductElasticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductElasticServiceImpl {
    private ProductElasticRepository productElasticRepository;
    @Autowired
    public ProductElasticServiceImpl(ProductElasticRepository productElasticRepository) {
        this.productElasticRepository = productElasticRepository;
    }

}
