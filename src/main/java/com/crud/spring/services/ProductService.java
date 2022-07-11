package com.crud.spring.services;

import com.crud.spring.models.entity.Product;
import com.crud.spring.models.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public Product findById(Long id){
        Product product = productRepo.findById(id).orElse(null);

        if (product == null) return null;

        return product;
    }

    public void removeOne(Long id){
        productRepo.deleteById(id);
    }


}
