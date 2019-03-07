package us.plee19.controllers;

import us.plee19.models.InventoryService;
import us.plee19.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InventoryController")
public class InventoryController extends HttpServlet {
    protected void doPost(HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.println("<html><body><table><tr><th>Product ID</th><th>Product Name</th><th>Price</th></tr>");


        InventoryService inventory = new InventoryService();
        for (Product p : inventory.getAllProducts()
        ) {
            out.println("<tr><td>" + p.getId() + "</td><td>" + p.getName() + "</td><td>" + p.getPrice() + "</td></tr>");
        }

        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.println("<html><body><table><tr><th>Product ID</th><th>Product Name</th><th>Price</th></tr>");


        InventoryService inventory = new InventoryService();
        for (Product p : inventory.getAllProducts()
        ) {
            out.println("<tr><td>" + p.getId() + "</td><td>" + p.getName() + "</td><td>" + p.getPrice() + "</td></tr>");
        }

        out.println("</body></html>");
    }
}
