package br.ifsp.edu.dsw3.model.domain;

public class Stock {
    private int id;
    private String code;
    private String type;
    private int maxQuantity;

    public Stock() {
        id = -1;
        code = "";
        type = "";
        maxQuantity = 1;
    }

    public Stock(int id, String code, String type, int maxQuantity) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.maxQuantity = maxQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    @Override
    public String toString() {
        return "Stock [id=" + id + ", code=" + code + ", type=" + type + ", maxQuantity=" + maxQuantity + "]";
    }
}
