<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.plee19.models.Product" %>
<%@ page import="us.plee19.models.InventoryService" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop Website</title>
    <link rel="stylesheet" href="store.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</head>
<body>
<div id="container">
    <nav class="navbar navbar-expand-lg navbar-light fixed-top bg-light">
        <div class="container">
            <a class="navbar-brand" href="home.jsp">Shop Website</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Products
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="cat.go">Product List</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cart.go">Shopping Cart</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchTerm">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
    <div id="rcorners">
        <h3>Catalog</h3>
        <form action="cartplace.go">
            <table>
                <%
                    Cookie searchTerm = new Cookie("searchTerm", request.getParameter("searchTerm"));
                    searchTerm.setMaxAge(60*60*24);
                    response.addCookie(searchTerm);
                    String searchString = "";
                    searchString = request.getParameter("searchTerm");
                    if (searchString == null) {
                        List recs = (List) request.getAttribute("catalog");
                        Iterator it = recs.iterator();
                        while (it.hasNext()) {
                            // Notice we're outputting some HTML. Is that a good idea?
                            // Also, notice we do not cast the object returned by the
                            // iterator to a String. Why?
                            Product product = (Product) it.next();
                            out.print("<tr><td>" + product.getName() + "</td><td>$" + product.getPrice() + "</td><td>Add to Cart<input type='checkbox' name='cartItem' value=" + product.getId() + "></td></tr>");
                            // <td><img src='" + product.getImage() + "' height='100'></td>
                        }
                    } else {
                        List recs = (List) request.getAttribute("catalog");
                        Iterator it = recs.iterator();
                        while (it.hasNext()) {
                            Product product = (Product) it.next();
                            if (product.getName().toUpperCase().contains(searchString.toUpperCase())) {
                                out.print("<tr><td>" + product.getName() + "</td><td>$" + product.getPrice() + "</td><td>Add to Cart<input type='checkbox' name='cartItem' value=" + product.getId() + "></td></tr>");
                            }
                        }
                }
                %>

            </table>
            <input type="submit" value="Purchase">
        </form>

    </div>
</div>
</body>
</html>