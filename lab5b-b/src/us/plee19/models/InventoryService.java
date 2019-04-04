package us.plee19.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<Product>();
        final String DB_URL = "jdbc:derby:CatalogDB";
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ProdNum, Description, Price FROM Catalog";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("ProdNum");
                double price = rs.getDouble("Price");
                String description = rs.getString("Description");
                productList.add(new Product(id, description, price));

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {}
            try{
                if (conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
        return productList;
    }
}
