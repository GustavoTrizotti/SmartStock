package br.ifsp.edu.dsw3.model.domain;

public class Product {
    private int id;
    private String name;
    private String section;
    private double price;

    public Product() {
        this.name = "";
        this.section = "";
        this.price = 0;
        this.id = -1;
    }

    public Product(int id, String name, String section, double price) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.price = price;
    }

    public Product(String name, String section, double price) {
        this.name = name;
        this.section = section;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", section=" + section + ", price=" + price + "]";
    }
}
