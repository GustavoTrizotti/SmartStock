package br.ifsp.edu.dsw3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.edu.dsw3.model.domain.Product;

public class ProductDAO {

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS product (" +
                "id integer PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, " +
                "name text NOT NULL, " +
                "section text NOT NULL, " +
                "price real NOT NULL" +
                ")";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProduct(Product product) {
        String sql = "INSERT INTO product (name, section, price) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getSection());
            stmt.setDouble(3, product.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllProducts() {
        String sql = "DELETE FROM product";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        String sql = "UPDATE product SET name=?, section=?, price=? WHERE id = ?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getSection());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setSection(rs.getString("section"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProductById(int id) {
        Product product = new Product();
        String sql = "SELECT * FROM product WHERE id = ?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setSection(rs.getString("section"));
                product.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

}
