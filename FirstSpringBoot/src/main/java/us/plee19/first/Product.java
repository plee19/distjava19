package us.plee19.first;

public class Product {
    private int prodNum;
    private String description;
    private double price;
    public Product(int prodNum, String description, double price) {
        this.prodNum = prodNum;
        this.description = description;
        this.price = price;
    }
    public int getProdNum() {
        return prodNum;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
}