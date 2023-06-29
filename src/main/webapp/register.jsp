<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="br.ifsp.edu.dsw3.model.dao.*"%>
<%@page import="br.ifsp.edu.dsw3.model.domain.*"%>

<%
    Product p = null;
    String button;

    if (request.getParameter("id")!=null){
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO dao = new ProductDAO();
        for (Product pA : dao.getProducts()) {
            if (pA.getId() == id) {
                p = pA;
            }
        }
        button = "Update";
    } else {
        p = new Product();
        button = "Save";
    }

%>

<%
    Stock s = null;
    String buttonS;

    if (request.getParameter("id")!=null){
        int id = Integer.parseInt(request.getParameter("id"));
        StockDAO dao = new StockDAO();
        for (Stock sA : dao.getStocks()) {
            if (sA.getId() == id) {
                s = sA;
            }
        }
        buttonS = "Update";
    } else {
        s = new Stock();
        buttonS = "Save";
    }

%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Smartstock | Home</title>
</head>
<body>
    <nav class="p-5 text-indigo-500 flex flex-row justify-between border-b-8">
        <h1 class="text-start font-bold text-3xl">SmartStock</h1>
        <div>
            <a href="register.jsp" class="text-2xl font-bold self-center mx-3">
                <i class="bi bi-house-fill"></i>
                Home
            </a>
            <a href="show.jsp" class="text-2xl font-bold self-center mx-3">
                <i class="bi bi-bar-chart-fill"></i>
                View
            </a>
        </div>
    </nav>

    <section class="bg-gradient-to-r from-sky-300 to-purple-600 flex items-center justify-evenly min-h-screen">
        <div class="w-1/4 bg-white p-5 border-b-8 rounded-md drop-shadow-lg">
            <h1 class="text-3xl font-bold text-center p-3 m-3 text-indigo-500 uppercase">Products</h1>
            <form method="POST" action="products" class="p-3 flex flex-col my-auto">
                <input type="text" hidden name="id" value="<%=p.getId()%>">
                <label class="text-lg font-semibold" for="name">Name</label>
                <input type="text" class="text-lg p-3 bg-gradient-to-r from-sky-100 to-purple-100 outline-none my-3" id="name" name="name" value="<%=p.getName()%>">
                <label class="text-lg font-semibold" for="section">Section</label>
                <input type="text" class="text-lg p-3 bg-gradient-to-r from-sky-100 to-purple-100 outline-none my-3" id="section" name="section" value="<%=p.getSection()%>">
                <label class="text-lg font-semibold">Price</label>
                <input type="text" class="text-lg p-3 bg-gradient-to-r from-sky-100 to-purple-100 outline-none my-3" id="price" name="price" value="<%=p.getPrice()%>">
                <input type="submit"
                    class="w-full bg-gradient-to-r from-sky-300 to-purple-400 text-white p-3 text-lg uppercase font-bold my-3 hover:opacity-80 transition-all" value="<%=button%>" name="send">
            </form>
        </div>

        <div class="w-1/4 bg-white p-5 border-b-8 rounded-md drop-shadow-lg">
            <h1 class="text-3xl font-bold text-center p-3 m-3 text-indigo-500 uppercase">Stocks</h1>
            <form method="POST" action="stocks" class="p-3 flex flex-col my-auto">
                <input type="text" hidden name="id" value="<%=s.getId()%>">
                <label class="text-lg font-semibold" for="code">Code</label>
                <input type="text" class="text-lg p-3 bg-gradient-to-r from-sky-100 to-purple-100 outline-none my-3" id="code" name="code" value="">
                <label class="text-lg font-semibold" for="type">Type</label>
                <input type="text" class="text-lg p-3 bg-gradient-to-r from-sky-100 to-purple-100 outline-none my-3" id="type" name="type" value="">
                <label class="text-lg font-semibold" for="maxQuantity">Max Quantity</label>
                <input type="number" min="1" max="40" class="text-lg p-3 bg-gradient-to-r from-sky-100 to-purple-100 outline-none my-3" id="maxQuantity" name="maxQuantity" value="">
                <input type="submit"
                    class="w-full bg-gradient-to-r from-sky-300 to-purple-400 text-white p-3 text-lg uppercase font-bold my-3 hover:opacity-80 transition-all" value="<%=button%>" name="send">
            </form>
        </div>
    </section>
</body>
</html>