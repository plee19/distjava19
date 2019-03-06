package us.plee19.controllers;

import us.plee19.models.Product;
import us.plee19.models.InventoryService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet")
public class CartController extends HttpServlet {
    private String RESULT_PAGE = "cart.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        // Get an array of Cookies associated with the this domain
        cookies = request.getCookies();
        PrintWriter out = response.getWriter();
        List<Product> products = new ArrayList();
        products.add(new Product(0," ",0.0));
        if( cookies != null ) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                out.print(cookie.getValue());
                if (cookie.getName().equals("cartItem")) {
                    products = orderedProducts( cookie.getValue( ));
                }
            }
        }
        request.setAttribute("catalog", products);

        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    protected List<Product> orderedProducts(String productsNumbers) {
        List<Product> products = new ArrayList<>();
        InventoryService inventoryService = new InventoryService();
        String[] nums = productsNumbers.split(",");
        for (int i=0;i<nums.length;i++) {
            products.add(inventoryService.getSingleProduct(Integer.parseInt(nums[i])));
        }
        return products;
    }
}
