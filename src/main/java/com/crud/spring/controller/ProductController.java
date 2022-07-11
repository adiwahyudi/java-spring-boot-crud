package com.crud.spring.controller;

import com.crud.spring.dto.ResponseData;
import com.crud.spring.models.entity.Product;
import com.crud.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product, Errors errors){
        ResponseData<Product> response = new ResponseData<>();
        if (errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                response.getMessage().add(error.getDefaultMessage());
            }
            response.setStatus(false);
            response.setPayload(null);

            return ResponseEntity.badRequest().body(response);
        }
        response.setStatus(true);
        response.setPayload(productService.save(product));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public Iterable<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PutMapping()
    public ResponseEntity<ResponseData<Product>> update(@Valid @RequestBody Product product, Errors errors){
        ResponseData<Product> response = new ResponseData<>();
        if (errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                response.getMessage().add(error.getDefaultMessage());
            }
            response.setStatus(false);
            response.setPayload(null);

            return ResponseEntity.badRequest().body(response);
        }
        response.setStatus(true);
        response.setPayload(productService.save(product));
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productService.removeOne(id);
    }

}
