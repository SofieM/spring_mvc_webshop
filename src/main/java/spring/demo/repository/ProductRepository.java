package spring.demo.repository;

import org.springframework.stereotype.Repository;
import spring.demo.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    //Collection til håndtering af data
    private List<Product> products = new ArrayList<>();

    public ProductRepository(){
        //Fylder Arraylist med Products (dummy-data)
        this.products.add(new Product(1,"Cornflakes", 20, "Lækre majsflager"));
        this.products.add(new Product(2,"Guldkorn", 17, "Lækre honningristede dimser"));
        this.products.add(new Product(3,"Toiletpapir", 25, "Skal hamstres!"));
    }

    public List<Product> readAll(){
        return products;
    }
    //tilføjer nyt produkt til products-listen
    public void create(Product prod){
        products.add(prod);
    }
}
