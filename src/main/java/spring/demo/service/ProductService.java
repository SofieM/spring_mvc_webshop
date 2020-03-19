package spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.demo.model.Product;
import spring.demo.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listAll(){
        List<Product> allProducts = new ArrayList<>();

        for (Product product:productRepository.readAll()){
            allProducts.add(product);
        }

        return allProducts;
    }
}
