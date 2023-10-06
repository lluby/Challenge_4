package com.example.Challenge_4.Service;

import com.example.Challenge_4.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProduct();
    Product updateProduct(Product product);
    void deleteProduct(String ProductCode);
}
