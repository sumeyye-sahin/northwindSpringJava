package kodlamaio.northwind.api.controllers;


import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/products") //kodlama.io/api/products bu uzantıdan bize istek gelirse sen çalış / kontrol et demiş olduk
public class ProductsController {


    private ProductService productService ;

    @Autowired
    public ProductsController(ProductService productService){
        this.productService=productService;
    }


    @GetMapping("/getall")           //kodlama.io/api/products/getall bu uzantıdan bize istek gelirse sen çalış demiş oluyoruz
    public List<Product> getAll(){
        return this.productService.getAll();
    }
}

//kodlama.io/api/products bu uzantıdan bize istek gelirse sem kontrol et demiş olduk