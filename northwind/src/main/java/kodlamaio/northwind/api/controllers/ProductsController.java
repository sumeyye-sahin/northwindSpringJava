package kodlamaio.northwind.api.controllers;


import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/products") //kodlama.io/api/products bu uzantıdan bize istek gelirse sen çalış / kontrol et demiş olduk
public class ProductsController {


    private ProductService productService ;

    @Autowired
    public ProductsController(ProductService productService){
        this.productService=productService;
    }


    @GetMapping("/getall")           //kodlama.io/api/products/getall bu uzantıdan bize istek gelirse sen çalış demiş oluyoruz
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public  DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }


    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product>
    getByProductNameAndCategory(@RequestParam String productName, @RequestParam int categoryId){
        return this.productService.getByProductNameAndCategory(productName,categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return  this.productService.getByProductNameContains(productName);
    }
    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll (int pageNo, int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }

}

//kodlama.io/api/products bu uzantıdan bize istek gelirse sem kontrol et demiş olduk