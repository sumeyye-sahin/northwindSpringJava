package kodlamaio.northwind.entities.concretes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="products")
@Data
public class Product {

    @Id
    @GeneratedValue
    @Column(name="product_id")
    private int id;

    @Column(name="category_id")
    private int categoryId;

    @Column(name="product_name")
    private String productName;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private short unitInStock;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    public Product(){}

    public Product(int id, int categoryId, String productName, double unitPrice, short unitInStock, String quantityPerUnit) {
        this.id = id;
        this.categoryId = categoryId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.unitInStock = unitInStock;
        this.quantityPerUnit = quantityPerUnit;
    }
}
