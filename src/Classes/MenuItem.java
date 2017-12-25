package Classes;

import java.io.Serializable;

public class MenuItem implements Serializable{
    private String name;
    private String description;
    private double price;
    private double discountRate;
    private String status;

    public MenuItem() {
    }

    public MenuItem(String name, String description, double price, double discountRate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountRate = discountRate/100;
        this.status = "Available";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate/100;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return String.format("%-30s %-30s %10s %12s %-15s", name, description, String.format("%.2f", price), String.format("%.0f",discountRate*100) + "%", status);
    }
    
    public static void main(String[] args) {
        MenuItem item1 = new MenuItem("Mee Goreng", "", 4.00, 0);
        MenuItem item2 = new MenuItem("Nasi Goreng", "", 5.00, 10);
        MenuItem item3 = new MenuItem("Lobster burger", "Special Promotion", 50.00, 10);
        
        System.out.println(String.format("%-30s %-30s %10s %12s %-15s", "NAME", "DESCRIPTION", "PRICE(RM)", "DISCOUNT(%)", "STATUS"));
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
    }
}