package com.crud.spring.models.repos;

import com.crud.spring.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product,Long> {

}
