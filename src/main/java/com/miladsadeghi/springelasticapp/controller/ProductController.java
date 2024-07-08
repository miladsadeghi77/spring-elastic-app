package com.miladsadeghi.springelasticapp.controller;

import com.miladsadeghi.springelasticapp.entity.elastic.ProductElastic;
import com.miladsadeghi.springelasticapp.service.elastic.ProductElasticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {

    private ProductElasticServiceImpl productElasticService;

    @Autowired
    public ProductController(ProductElasticServiceImpl productElasticService) {
        this.productElasticService = productElasticService;
    }

    @RequestMapping(path = "saveAll", method = RequestMethod.POST)
    public void saveAllProductFromDBTOElastic() {
        productElasticService.saveProductFormDBToElastic();
    }

    @RequestMapping(path = "getAllProduct", method = RequestMethod.GET)
    public Iterable<ProductElastic> getAllProduct() {
        return productElasticService.getAllProduct();
    }

    @RequestMapping(path = "findByNameOrCategory/{keyword}", method = RequestMethod.GET)
    public List<ProductElastic> findByNameOrCategory(@PathVariable String keyword) {
        return productElasticService.findByNameOrCategory(keyword);
    }
}
