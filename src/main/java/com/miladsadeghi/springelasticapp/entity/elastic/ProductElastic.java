package com.miladsadeghi.springelasticapp.entity.elastic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "products")
public class ProductElastic {
    @Id
    private String id;
    @Field(name = "name",type = FieldType.Text)
    private String name;
    @Field(name = "category",type = FieldType.Text)
    private String category;
    @Field(name = "subcategory",type = FieldType.Text)
    private String subcategory;
    @Field(name = "price",type = FieldType.Text)
    private String price;
}
