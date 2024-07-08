package com.miladsadeghi.springelasticapp.mapper;

import com.miladsadeghi.springelasticapp.entity.Product;
import com.miladsadeghi.springelasticapp.entity.elastic.ProductElastic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private ModelMapper modelMapper;

    @Autowired
    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public ProductElastic convertToElastic(Product product){
        return modelMapper.map(product , ProductElastic.class);
    }
}
