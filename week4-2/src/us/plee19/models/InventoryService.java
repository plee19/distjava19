package us.plee19.models;

import java.util.Arrays;
import java.util.List;

public class InventoryService {

    private List<Product> productList = Arrays.asList(
            new Product(1, "Pizza", 12.99),
            new Product(2, "Pasta", 11.99),
            new Product(3, "Tiramisu", 8.99),
            new Product(4, "Coffee", 1.99),
            new Product(5, "Soda", 2.99),
            new Product(6, "Cookies", 1.29)
    );

    public List<Product> getAllProducts() { return productList; }
}
