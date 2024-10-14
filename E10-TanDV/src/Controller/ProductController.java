package Controller;

import Entity.Product;
import ExceptionValidation.InvalidProducCodeException;
import Service.ProductService;
import Validattion.Validation;

public class ProductController {
    private ProductService productService;
    public ProductController() {;}
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void add(Product product) {
        if(Validation.isProductCode(product.getCode()) && Validation.isProductName(product.getName())) {
            productService.add(product);
        } else {
            throw new InvalidProducCodeException("Product code or name is invalid!");
        }
    }
}
