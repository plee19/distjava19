package us.plee19.first;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Pizza", 12.99));
        products.add(new Product(2,"Pasta", 11.99));
        products.add(new Product(3,"Tiramisu", 8.99));
        products.add(new Product(4,"Coffee", 1.99));
        products.add(new Product(5,"Soda", 2.99));
        products.add(new Product(6,"Cookies", 1.29));
        return products;
    }
}