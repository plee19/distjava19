package us.plee19.models;

import java.util.List;

import static java.util.Arrays.asList;

public class InventoryService {

    private List<Product> productList = asList(
            new Product(1, "Pizza", 12.99),
            new Product(2, "Pasta", 11.99),
            new Product(3, "Tiramisu", 8.99),
            new Product(4, "Coffee", 1.99),
            new Product(5, "Soda", 2.99),
            new Product(6, "Cookies", 1.29)
    );

    public List<Product> getAllProducts() { return productList; }

    public Product getSingleProduct(int productNum) {
        Product product = null;

        for(Product i: productList) {
            if (i.getId() == productNum) {
                return i;
            }
        }
        return product;
    }
}
