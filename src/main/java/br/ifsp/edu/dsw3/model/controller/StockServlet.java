package br.ifsp.edu.dsw3.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifsp.edu.dsw3.model.dao.StockDAO;
import br.ifsp.edu.dsw3.model.domain.Stock;

@WebServlet(name = "stockServlet", value = "/stocks")
public class StockServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        StockDAO stockDAO = new StockDAO();
        stockDAO.createTable();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String type = req.getParameter("type");
        StockDAO stockDAO = new StockDAO();
        if (type.contains("Editar")) {
            resp.sendRedirect("register.jsp");
        } else {
            stockDAO.deleteStock(id);
            resp.sendRedirect("show.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String code = req.getParameter("name");
        String type = req.getParameter("section");
        int maxQuantity = Integer.parseInt(req.getParameter("maxQuantity"));
        String send = req.getParameter("send");
        Stock stock = new Stock(id, code, type, maxQuantity);
        StockDAO stockDAO = new StockDAO();
        if (send.contains("Save")) {
            stockDAO.insertStock(stock);
        } else {
            stockDAO.updateStock(stock);
        }
        resp.sendRedirect("show.jsp");
    }
}
