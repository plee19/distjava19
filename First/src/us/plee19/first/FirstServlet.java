package us.plee19.first;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends javax.servlet.http.HttpServlet {
    /*protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String html = "<html><body>Hi. I received param1=" + request.getParameter("param1") +
                " via POST</body><html>";
        response.getOutputStream().println(html);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String html = "<html><body>Hi. I received param1=" + request.getParameter("param1") +
                " via GET</body><html>";
        response.getOutputStream().println(html);
    }
}
