package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SucccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao; //DI

    @Autowired
    public ProductManager(ProductDao productDao){
        this.productDao=productDao;

    }

    @Override
    public DataResult<List<Product>> getAll() {
        productDao.findAll();
        return new SucccessDataResult<List<Product>>
                (this.productDao.findAll(),"Data listelendi.");


    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SucccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün eklendi.");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SucccessDataResult<Product>
                (this.productDao.getByProductName(productName),"Data Listelendi.");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
        return new SucccessDataResult<Product>
                (this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return new SucccessDataResult<List<Product>>
                (this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SucccessDataResult<List<Product>>
                (this.productDao.getByCategory_CategoryIdIn(categories),"Data Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SucccessDataResult<List<Product>>
                (this.productDao.getByProductNameContains(productName),"Data Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SucccessDataResult<List<Product>>
                (this.productDao.getByProductNameStartsWith(productName),"Data Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SucccessDataResult<List<Product>>
                (this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi.");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SucccessDataResult<List<ProductWithCategoryDto>>
                (this.productDao.getProductWithCategoryDetails(),"Data Listelendi");
    }
}
