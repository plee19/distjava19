package us.plee19.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static java.util.Arrays.asList;

public class InventoryService {

    public InventoryService() {
        try {
            final String DB_URL = "jdbc:derby:CatalogDB;create=true";
            Connection conn = DriverManager.getConnection(DB_URL);
            dropTables(conn);
            buildCatalogTable(conn);
            conn.close(); }
        catch (Exception e) {
            System.out.println("Error Creating the Catalog Table");
            System.out.println(e.getMessage());
        }
    }

    public static void dropTables(Connection conn) {
        System.out.println("Checking for existing tables.");
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.execute("DROP TABLE Catalog");
                System.out.println("Catalog table dropped.");
            } catch (SQLException ex) {}
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void buildCatalogTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE Catalog (" +
                    "Description CHAR(25)," +
                    "ProdNum CHAR(10) NOT NULL PRIMARY KEY, " +
                    "Price DOUBLE " +
                    ")");

            stmt.execute("INSERT INTO Catalog VALUES ( " +
                    "'Pizza', " +
                    "'1', " +
                    "12.99 )");

            stmt.execute("INSERT INTO Catalog VALUES ( " +
                    "'Pasta', " +
                    "'2', " +
                    "11.99 )");

            stmt.execute("INSERT INTO Catalog VALUES ( " +
                    "'Tiramisu', " +
                    "'3', " +
                    "8.99 )");

            stmt.execute("INSERT INTO Catalog VALUES ( " +
                    "'Coffee', " +
                    "'4', " +
                    "1.99 )");

            stmt.execute("INSERT INTO Catalog VALUES ( " +
                    "'Soda', " +
                    "'5', " +
                    "2.99 )");

            stmt.execute("INSERT INTO Catalog VALUES ( " +
                    "'Cookies', " +
                    "'6', " +
                    "1.29 )");

            System.out.println("Catalog table created.");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /*private List<Product> productList = asList(
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
    }*/
}
