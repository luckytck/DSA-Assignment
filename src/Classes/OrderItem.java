
package Classes;

import java.io.Serializable;

public class OrderItem implements Serializable{
    private MenuItem menuItem;
    private int quantity;
    private String remark;

    public OrderItem() {
    }

    public OrderItem(MenuItem menuItem, int quantity, String remark) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.remark = remark;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public double calPriceAfterDiscount(){
        return menuItem.getPrice()*(1-menuItem.getDiscountRate());
    }
    
    public double calSubTotal(){
        return calPriceAfterDiscount() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%-30s %10s %8s %-20s %10s",menuItem.getName(), String.format("%.2f", calPriceAfterDiscount()), quantity, remark, String.format("%.2f", calSubTotal()));
    }

    public static void main(String[] args) {
        //Create MenuItems
        MenuItem menuItem1 = new MenuItem("Mee Goreng", "", 4.00, 0);
        MenuItem menuItem2 = new MenuItem("Nasi Goreng", "", 5.00, 10);
        MenuItem menuItem3 = new MenuItem("Lobster burger", "Special Promotion", 50.00, 10);
        //Create OrderItems
        OrderItem orderItem1 = new OrderItem(menuItem1, 2, "");
        OrderItem orderItem2 = new OrderItem(menuItem2, 1, "");
        OrderItem orderItem3 = new OrderItem(menuItem3, 1, "");
        //Print OrderItems
        System.out.println(String.format("%-30s %-10s %-8S %-20s %10s", "NAME", "UNIT_PRICE", "QUANTITY", "REMARK", "SUB_TOTAL"));
        System.out.println(orderItem1);
        System.out.println(orderItem2);
        System.out.println(orderItem3);
    }
}