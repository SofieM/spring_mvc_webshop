package spring.demo.repository;

import org.springframework.stereotype.Repository;
import spring.demo.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product>{
    //Collection til håndtering af data
    private List<Product> products = new ArrayList<>();

    public ProductRepository(){
        //Fylder Arraylist med Products (dummy-data)
        this.products.add(new Product(1,"Cornflakes", 20, "Lækre majsflager"));
        this.products.add(new Product(2,"Guldkorn", 17, "Lækre honningristede dimser"));
        this.products.add(new Product(3,"Toiletpapir", 25, "Skal hamstres!"));
    }

    @Override
    //tilføjer nyt produkt til products-listen
    public void create(Product prod){
        products.add(prod);
    }
    @Override
    public List<Product> readAll(){
        return products;
    }

    @Override
    public Product read(long id) {
        //Find element med id
        int i = 0;
        while(i < products.size()){
            if(products.get(i).getId() == id){
                return products.get(i);
            }
            i++;
        }
        return null;
    }

    @Override
    public boolean update(Product product) {

        //find element der skal opdateres i products
        for(int i = 0; i<products.size(); i++){
            //hvis product på index 'i' i 'products' har et id, der svarer til id i det products der er taget imod i parameter
            if(products.get(i).getId() == product.getId()){
                products.set(i,product);
                return true;
            }
        }
        //hvis elements med id ikke fundet
        return false;
    }

    @Override
    public boolean delete(long id) {
        for (int i = 0; i <products.size() ; i++) {
            if(products.get(i).getId() == id){
                products.remove(i);
                return true;
            }
        }
        return false;
    }


}
