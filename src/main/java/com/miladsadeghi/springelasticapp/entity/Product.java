package com.miladsadeghi.springelasticapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
@Table(name = "product")
public class Product {
    @Id
    @SequenceGenerator(
            name = "PRODUCT_SEQ",
            sequenceName = "PRODUCT_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PRODUCT_SEQ"
    )
    @Column(
            name = "id",
            updatable = false,
            unique = true,
            nullable = false
    )
    private Long id;
    @Column(columnDefinition = "varchar")
    private String name;
    @Column(columnDefinition = "varchar")
    private String category;
    @Column(columnDefinition = "varchar")
    private String subcategory;
    @Column(columnDefinition = "varchar")
    private String price;

}
