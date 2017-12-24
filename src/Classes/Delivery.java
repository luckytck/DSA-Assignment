
package Classes;

import ADTs.CircularDoublyLinkedList;
import ADTs.ListInterface;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Delivery implements Serializable{
    private int deliveryNo;
    private Order order;
    private DeliveryMan deliveryMan;
    private GregorianCalendar deliveryDate;
    private GregorianCalendar deliveredTime;
    private int distanceTravelled;
    private String status;
    private static int nextDeliveryNo = 1000;

    public Delivery() {
        this.deliveryNo = nextDeliveryNo++;
    }

    public Delivery(Order order, DeliveryMan deliveryMan, GregorianCalendar deliveryDate) {
        this.order = order;
        this.deliveryMan = deliveryMan;
        this.deliveryDate = deliveryDate;
        this.deliveryNo = nextDeliveryNo++;
        this.distanceTravelled = 0;
        this.status = "Delivering";
    }

    public int getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(int deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public GregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(GregorianCalendar deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public static int getNextDeliveryNo() {
        return nextDeliveryNo;
    }

    public static void setNextDeliveryNo(int nextDeliveryNo) {
        Delivery.nextDeliveryNo = nextDeliveryNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GregorianCalendar getDeliveredTime() {
        return deliveredTime;
    }

    public void setDeliveredTime(GregorianCalendar deliveredTime) {
        this.deliveredTime = deliveredTime;
    }
    
    public int calTimeTaken(){
        int minutes = 0;
        if (deliveredTime != null && deliveryDate != null) {
            long start = deliveryDate.getTimeInMillis();
            long end = deliveredTime.getTimeInMillis();
            long different = end - start;
            minutes = (int)TimeUnit.MILLISECONDS.toMinutes(different);
        } 
        return minutes;
    }
    
    public String printDeliveryDate(){
        return String.format("%02d/%02d/%04d", deliveryDate.get(Calendar.DAY_OF_MONTH), (deliveryDate.get(Calendar.MONTH) + 1), deliveryDate.get(Calendar.YEAR));
    }
    
    @Override
    public String toString() {
        return String.format("%-11s %-8s %-20s %-13s %16s %22s %-10s", deliveryNo, order.getOrderNo(), deliveryMan.getName(), printDeliveryDate(), calTimeTaken(), distanceTravelled, status);
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
       
        //Create Delivery Men
        Address address3 = new Address("Jalan Suasana 3/4, Bandar Tun Hussein Onn", "Selangor", "Cheras", 43200);
        DeliveryMan user1 = new DeliveryMan("970219-14-6459","luckytck97@gmail.com", 2000.00, address3, "luckytck", "1234", "Tan Cheong Kiat", 'M', "011-37997626");
        
        //Create Delivery
        Delivery delivery1 = new Delivery(order1, user1, new GregorianCalendar(2017, 11, 8, 13, 0, 0));
        
        //Update Delivered Order
        delivery1.setDistanceTravelled(2000);
        delivery1.setDeliveredTime(new GregorianCalendar(2017, 11, 8, 13, 28, 33));
        delivery1.setStatus("Delivered");
        
        //Print Delivery
        System.out.printf("%-11s %-8s %-20s %-13s %16s %22s %-10s\n", "DELIVERY_NO", "ORDER_NO", "DELIVERY_MAN", "DELIVERY_DATE", "TIME_TAKEN(mins)", "DISTANCE_TRAVELLED(m)", "STATUS");
        System.out.println(delivery1);

    }
}
