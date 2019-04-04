package us.plee19.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "InventoryController")
public class InventoryController extends HttpServlet {
    protected void doPost(HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        final String DB_URL = "jdbc:derby:CatalogDB";
        Statement stmt = null;
        Connection conn = null;
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ProdNum, Description, Price FROM Catalog";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("ProdNum");
                double price = rs.getDouble("Price");
                String description = rs.getString("Description");

                out.print("ID: " + id.trim());
                out.print(", Price: " + price);
                out.println(", Description: " + description);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        /*out.println("<html><body><table><tr><th>Product ID</th><th>Product Name</th><th>Price</th></tr>");


        InventoryService inventory = new InventoryService();
        for (Product p : inventory.getAllProducts()
        ) {
            out.println("<tr><td>" + p.getId() + "</td><td>" + p.getName() + "</td><td>" + p.getPrice() + "</td></tr>");
            out.print("href=\"DeleteController?product=" + URLEncoder.encode(p.getName(),"UTF-8") + "\">Remove");
        }

        out.println("</body></html>");*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        final String DB_URL = "jdbc:derby:CatalogDB";
        Statement stmt = null;
        Connection conn = null;
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ProdNum, Description, Price FROM Catalog";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("ProdNum");
                double price = rs.getDouble("Price");
                String description = rs.getString("Description");

                out.print("ID: " + id.trim());
                out.print(", Price: " + price);
                out.println(", Description: " + description);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        /*out.println("<html><body><table><tr><th>Product ID</th><th>Product Name</th><th>Price</th></tr>");


        InventoryService inventory = new InventoryService();
        for (Product p : inventory.getAllProducts()
        ) {
            out.println("<tr><td>" + p.getId() + "</td><td>" + p.getName() + "</td><td>" + p.getPrice() + "</td></tr>");
            out.print("href=\"DeleteController?product=" + URLEncoder.encode(p.getName(),"UTF-8") + "\">Remove");
        }

        out.println("</body></html>");*/
    }
}
