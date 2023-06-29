package br.ifsp.edu.dsw3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.edu.dsw3.model.domain.Stock;

public class StockDAO {
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS stock (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "code TEXT," +
                "type TEXT," +
                "maxQuantity INTEGER" +
                ")";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertStock(Stock stock) {
        String sql = "INSERT INTO stock (code, type, maxQuantity) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, stock.getCode());
            stmt.setString(2, stock.getType());
            stmt.setInt(3, stock.getMaxQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllStocks() {
        String sql = "DELETE FROM stock";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStock(int id) {
        String sql = "DELETE FROM stock WHERE id = ?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStock(Stock stock) {
        String sql = "UPDATE stock SET code=?, type=?, maxQuantity=? WHERE id = ?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, stock.getCode());
            stmt.setString(2, stock.getType());
            stmt.setInt(3, stock.getMaxQuantity());
            stmt.setInt(4, stock.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Stock> getStocks() {
        ArrayList<Stock> stocks = new ArrayList<>();
        String sql = "SELECT * FROM stock";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Stock stock = new Stock();
                stock.setId(rs.getInt("id"));
                stock.setCode(rs.getString("code"));
                stock.setType(rs.getString("type"));
                stock.setMaxQuantity(rs.getInt("maxQuantity"));
                stocks.add(stock);
                return stocks;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocks;
    }

    public Stock getStockById(int id) {
        Stock stock = new Stock();
        String sql = "SELECT * FROM stock WHERE id = ?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                stock.setId(rs.getInt("id"));
                stock.setCode(rs.getString("code"));
                stock.setType(rs.getString("type"));
                stock.setMaxQuantity(rs.getInt("maxQuantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }
}
