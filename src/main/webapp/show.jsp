<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="br.ifsp.edu.dsw3.model.dao.*, br.ifsp.edu.dsw3.model.domain.*"%>

<%
    ProductDAO dao = new ProductDAO();
    StockDAO sDao = new StockDAO();
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Smartstock | View</title>
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
        <div class="bg-white p-5 border-b-8 rounded-md drop-shadow-lg text-center">
            <h1 class="p-3 text-indigo-500 m-3 text-3xl uppercase font-bold">Products</h1>
            <table class= "table w-full p-3 text-center hover:border-collapse">
                <thead>
                    <tr class="table-row p-3 bg-gray-200 px-5 py-3 text-lg">
                        <th class="px-5 py-3">ID</th>
                        <th class="px-5 py-3">Name</th>
                        <th class="px-5 py-3">Section</th>
                        <th class="px-5 py-3">Price</th>
                        <th class="px-5 py-3">
                            <i class="bi bi-pencil-fill"></i>
                        </th>
                        <th class="px-5 py-3">
                            <i class="bi bi-trash-fill"></i>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        for (Product p : dao.getProducts()) {
                    %>
                        <tr class="table-row text-lg border-b-4">
                            <td class="px-3 py-4"><%=p.getId()%></td>
                            <td class="px-3 py-4"><%=p.getName()%></td>
                            <td class="px-3 py-4"><%=p.getSection()%></td>
                            <td class="px-3 py-4">$ <%=p.getPrice()%>0</td>
                            <td class="px-3 py-4">
                                <input id="<%=p.getId()%>" class="actionEditar" type="submit" value="Editar"/>
                            </td>
                            <td class="px-3 py-4">
                                <input id="<%=p.getId()%>" class="actionRemover" type="submit" value="Remover" />
                            </td>
                        </tr>
                    <%      
                        }
                    %>
                </tbody>
            </table>
        </div>

        <div class="bg-white p-5 border-b-8 rounded-md drop-shadow-lg text-center">
            <h1 class="p-3 text-indigo-500 m-3 text-3xl uppercase font-bold">Stocks</h1>
            <table class= "table w-full p-3 text-center hover:border-collapse">
                <thead>
                    <tr class="table-row p-3 bg-gray-200 px-5 py-3 text-lg">
                        <th class="px-5 py-3">ID</th>
                        <th class="px-5 py-3">Code</th>
                        <th class="px-5 py-3">Type</th>
                        <th class="px-5 py-3">Max Quantity</th>
                        <th class="px-5 py-3">
                            <i class="bi bi-pencil-fill"></i>
                        </th>
                        <th class="px-5 py-3">
                            <i class="bi bi-trash-fill"></i>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        for (Stock s : sDao.getStocks()) {
                    %>
                        <tr class="table-row text-lg border-b-4">
                            <td class="px-3 py-5"><%=s.getId()%></td>
                            <td class="px-3 py-5"><%=s.getCode()%></td>
                            <td class="px-3 py-5"><%=s.getType()%></td>
                            <td class="px-3 py-5"><%=s.getMaxQuantity()%></td>
                            <td class="px-3 py-5">
                                <input id="<%=s.getId()%>" class="actionEditar" type="submit" value="Editar"/>
                            </td>
                            <td class="px-3 py-5">
                                <input id="<%=s.getId()%>" class="actionRemoverStock" type="submit" value="Remover"/>
                            </td>
                        </tr>
                    <% 
                        }
                    %>
                </tbody>
            </table>
        </div>
    </section>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">

    var url='';
    var buttonEditar = $('.actionEditar');
    var buttonRemover = $('.actionRemover');
    var buttonRemoverStock = $('.actionRemoverStock');

    buttonEditar.click(() => {
        url="https://localhost:8080/smart-stock/register.jsp?id=" + buttonEditar.attr("id") + "&type=" + buttonEditar.val();
        document.location.href=url;
    });

    buttonRemover.click(() => {
        url="https://localhost:8080/smart-stock/products?id=" + buttonRemover.attr("id") + "&type=" + buttonRemover.val();
        document.location.href=url;
    });

    buttonRemoverStock.click(() => {
        url="https://localhost:8080/smart-stock/stocks?id=" + buttonRemoverStock.attr("id") + "&type=" + buttonRemoverStock.val();
        document.location.href=url;
    }) 

</script>
</body>
</html>