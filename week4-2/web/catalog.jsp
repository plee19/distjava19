<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.plee19.models.Product" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop Website</title>
    <link rel="stylesheet" href="store.css">
</head>
<body>
<div id="container">
    <nav class="navbar navbar-expand-lg navbar-light fixed-top bg-light">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Shop Website</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Products
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="cat.go">Product List</a>
                            <a class="dropdown-item" href="pdetail.html">Product Detail</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cart.go">Shopping Cart</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
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
                    List recs = (List) request.getAttribute("catalog");
                    Iterator it = recs.iterator();
                    while (it.hasNext()) {
                        // Notice we're outputting some HTML. Is that a good idea?
                        // Also, notice we do not cast the object returned by the
                        // iterator to a String. Why?
                        Product product = (Product) it.next();
                        out.print("<tr><td>" + product.getName() + "</td><td>$" + product.getPrice() + "</td><td>Add to Cart<input type='checkbox' name='cartItem' value=" + product.getId()+ "></td></tr>");
                        // <td><img src='" + product.getImage() + "' height='100'></td>
                    }
                %>

            </table>
            <input type="submit" value="Purchase">
        </form>

    </div>
</div>
</body>
</html>