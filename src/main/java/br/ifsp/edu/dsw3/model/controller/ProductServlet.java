package br.ifsp.edu.dsw3.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifsp.edu.dsw3.model.dao.ProductDAO;
import br.ifsp.edu.dsw3.model.domain.Product;

@WebServlet(name = "productServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ProductDAO productDAO = new ProductDAO();
        productDAO.createTable();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String type = req.getParameter("type");
        ProductDAO productDAO = new ProductDAO();
        if (type.contains("Editar")) {
            resp.sendRedirect("register.jsp");
        } else {
            productDAO.deleteProduct(id);
            resp.sendRedirect("show.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String section = req.getParameter("section");
        double price = Double.parseDouble(req.getParameter("price"));
        String send = req.getParameter("send");
        Product product = new Product(id, name, section, price);
        ProductDAO productDAO = new ProductDAO();
        if (send.contains("Save")) {
            productDAO.insertProduct(product);
        } else {
            productDAO.updateProduct(product);
        }
        resp.sendRedirect("show.jsp");
    }
}
