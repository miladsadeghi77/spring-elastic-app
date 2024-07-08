package com.miladsadeghi.springelasticapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.miladsadeghi.springelasticapp.repository.elastic")
public class SpringElasticAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringElasticAppApplication.class, args);
	}

}
