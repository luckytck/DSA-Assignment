
package Classes;

import ADTs.CircularDoublyLinkedList;
import ADTs.ListInterface;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Order implements Serializable{
    private int orderNo;
    private ListInterface<OrderItem> itemList;
    private Customer customer;
    private Affiliate affiliate;
    private GregorianCalendar orderDate;
    private String status;
    private static int nextOrderNo = 1000; //Note - If you retrieve the Order Class from .dat, you need to initialize the nextOrderNo
                                           //becoz the value will become 1000, count the records and add 1000 to set the nextOrderNo
    public Order() {
        this.orderNo = nextOrderNo++;
    }

    public Order(ListInterface<OrderItem> itemList, Customer customer, Affiliate affiliate, GregorianCalendar orderDate) {
        this.itemList = itemList;
        this.customer = customer;
        this.affiliate = affiliate;
        this.orderDate = orderDate;
        this.orderNo = nextOrderNo++;
        this.status = "Pending Delivery";
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public ListInterface<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(ListInterface<OrderItem> itemList) {
        this.itemList = itemList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Affiliate getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }

    public GregorianCalendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(GregorianCalendar orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static int getNextOrderNo() {
        return nextOrderNo;
    }

    public static void setNextOrderNo(int nextOrderNo) {
        Order.nextOrderNo = nextOrderNo;
    }
    
    public double calTotalAmount(){
        double total = 0;
        if (itemList != null) {
            for (int i = 1; i <= itemList.getNumberOfEntries(); i++) {
                total += itemList.getEntry(i).calSubTotal();
            }
        }
        return total;
    }
    
    public String printOrderDate(){
        return String.format("%02d/%02d/%04d", orderDate.get(Calendar.DAY_OF_MONTH), (orderDate.get(Calendar.MONTH) + 1), orderDate.get(Calendar.YEAR));
    }
    
    public String printOrderTime(){
        String AM_PM = "";
        if (orderDate.get(Calendar.AM_PM) == 1) {
            AM_PM = "PM";
        } else {
            AM_PM = "AM";
        }
        return String.format("%02d:%02d:%02d%s",orderDate.get(Calendar.HOUR), orderDate.get(Calendar.MINUTE), orderDate.get(Calendar.SECOND), AM_PM);
    }
    
    @Override
    public String toString() {
        return String.format("%-8d %-15s %-30s %12s %-10s %-10s %-20s", orderNo, customer.getName(), affiliate.getRestaurantName(), String.format("%.2f",calTotalAmount()), printOrderDate(), printOrderTime(), status);
    }
    
    public static void main(String[] args) {
        //Create Customer1
        Address address1 = new Address("Jalan Suasana 3/4, Bandar Tun Hussein Onn", "Selangor", "Cheras", 43200);
        GregorianCalendar date1 = new GregorianCalendar(1997, 2, 19); //Check Customer.java if not understand
        Customer customer1 = new Customer("luckytck97@gmail.com", date1, address1, "luckytck", "1234", "Tan Cheong Kiat", 'M', "011-37997626");
        
        //Create Affiliate1
        Address address2 = new Address("AEON (Jusco) Cheras Selatan Shopping Centre", "Selangor", "Balakong", 43200);
        Affiliate affiliate1 = new Affiliate("Tealive", "962113-K", "000808083456", "03-62113891", address1, "chatime", "1234", "Bryan Loo", 'M', "012-3456789");
        
        //Create MenuItems
        MenuItem item1 = new MenuItem("Mee Goreng", "", 4.00, 0);
        MenuItem item2 = new MenuItem("Original Pearl Milk Tea", "", 5.00, 10);
        
        //Create OrderItems
        OrderItem orderItem1 = new OrderItem(item1, 2, "");
        OrderItem orderItem2 = new OrderItem(item2, 1, "Less Sugar");
        
        //Add OrderItems into itemList
        ListInterface<OrderItem> itemList = new CircularDoublyLinkedList<>();
        itemList.add(orderItem1);
        itemList.add(orderItem2);
        
        //Create Current Date
        GregorianCalendar currentDate = new GregorianCalendar();//System Time
        //Print Current Date; Month start from 0, so Month + 1
        System.out.println(currentDate.get(Calendar.DAY_OF_MONTH)+"/"+ (currentDate.get(Calendar.MONTH) + 1) +"/"+currentDate.get(Calendar.YEAR));
        //Print Current Time
        String AM_PM = "";
        if (currentDate.get(Calendar.AM_PM) == 1) { //0 = AM; 1 = PM
            AM_PM = "PM";
        } else {
            AM_PM = "AM";
        }
        System.out.printf("%02d:%02d:%02d %s\n",currentDate.get(Calendar.HOUR), currentDate.get(Calendar.MINUTE), currentDate.get(Calendar.SECOND), AM_PM);
        
        //Create Order1
        Order order1 = new Order(itemList, customer1, affiliate1, currentDate);
        
        //Print Order1 Details
        System.out.println(String.format("%-8s %-15s %-30s %-12s %-10s %-10s %-20s", "ORDER_NO", "CUSTOMER", "AFFILIATE", "TOTAL_AMOUNT", "ORDER_DATE", "ORDER_TIME", "STATUS"));
        System.out.println(order1);
        
        //Print itemList Details from order1
        System.out.println(String.format("%-30s %-10s %-8S %-20s %10s", "NAME", "UNIT_PRICE", "QUANTITY", "REMARK", "SUB_TOTAL"));
        for (int i = 1; i < order1.getItemList().getNumberOfEntries(); i++) {
            System.out.println(order1.getItemList().getEntry(i).toString());
        }
        System.out.printf("%71s %10s\n", "Total = ", String.format("%.2f", order1.calTotalAmount()));
    }
    
}
