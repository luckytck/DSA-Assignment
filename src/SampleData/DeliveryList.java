
package SampleData;

import ADTs.CircularDoublyLinkedList;
import ADTs.ListInterface;
import Classes.Address;
import Classes.Affiliate;
import Classes.Customer;
import Classes.Delivery;
import Classes.DeliveryMan;
import Classes.File;
import Classes.MenuItem;
import Classes.Order;
import Classes.OrderItem;
import Classes.User;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DeliveryList {
    public static final String DELIVERYFILE = "delivery.dat";
    
    public static void main(String[] args) {
        //Create Customer1
        Address address1 = new Address("Jalan Suasana 3/4, Bandar Tun Hussein Onn", "Selangor", "Cheras", 43200);
        GregorianCalendar date1 = new GregorianCalendar(1997, 2, 19); //Check Customer.java if not understand
        Customer customer1 = new Customer("luckytck97@gmail.com", date1, address1, "luckytck", "1234", "Tan Cheong Kiat", 'M', "011-37997626");
        
        //Create Affiliate1
        Address address2 = new Address("AEON (Jusco) Cheras Selatan Shopping Centre", "Selangor", "Balakong", 43200);
        User.setNextID(1000);
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
        Order order2 = new Order(itemList, customer1, affiliate1, currentDate);
        Order order3 = new Order(itemList, customer1, affiliate1, currentDate);
        Order order4 = new Order(itemList, customer1, affiliate1, currentDate);
       
        //Create Delivery Men
        Address address3 = new Address("Jalan Suasana 3/4, Bandar Tun Hussein Onn", "Selangor", "Cheras", 43200);
        User.setNextID(1000);
        DeliveryMan user1 = new DeliveryMan("970219-14-6459","luckytck97@gmail.com", 2000.00, address3, "luckytck", "1234", "Tan Cheong Kiat", 'M', "011-37997626");
        DeliveryMan user2 = new DeliveryMan("970219-14-6459","luckytck97@gmail.com", 2000.00, address3, "luckytck", "1234", "Tan Qi Han", 'M', "011-37997626");
        DeliveryMan user3 = new DeliveryMan("970219-14-6459","luckytck97@gmail.com", 2000.00, address3, "luckytck", "1234", "Wong Li Yi", 'F', "011-37997626");
        
        //Create Delivery
        Delivery delivery1 = new Delivery(order1, user1, new GregorianCalendar(2017, 11, 27, 13, 0, 0));
        Delivery delivery2 = new Delivery(order2, user2, new GregorianCalendar(2017, 11, 27, 14, 0, 0));
        Delivery delivery3 = new Delivery(order3, user3, new GregorianCalendar(2017, 11, 27, 15, 0, 0));
        Delivery delivery4 = new Delivery(order4, user1, new GregorianCalendar(2017, 11, 27, 16, 0, 0));
        
        //Update Delivered Order
        delivery1.setDistanceTravelled(2000);
        delivery1.setDeliveredTime(new GregorianCalendar(2017, 11, 27, 13, 15, 33));
        delivery1.setStatus("Delivered");
        
        delivery2.setDistanceTravelled(3155);
        delivery2.setDeliveredTime(new GregorianCalendar(2017, 11, 27, 14, 20, 13));
        delivery2.setStatus("Delivered");
        
        delivery3.setDistanceTravelled(2548);
        delivery3.setDeliveredTime(new GregorianCalendar(2017, 11, 27, 15, 25, 56));
        delivery3.setStatus("Delivered");
        
        delivery4.setDistanceTravelled(4012);
        delivery4.setDeliveredTime(new GregorianCalendar(2017, 11, 27, 16, 40, 13));
        delivery4.setStatus("Delivered");
        
        //Print Delivery
        System.out.printf("%-11s %-8s %-20s %-13s %16s %22s %-10s\n", "DELIVERY_NO", "ORDER_NO", "DELIVERY_MAN", "DELIVERY_DATE", "TIME_TAKEN(mins)", "DISTANCE_TRAVELLED(m)", "STATUS");
        System.out.println(delivery1);
        System.out.println(delivery2);
        System.out.println(delivery3);
        System.out.println(delivery4);
        
        //Create Delivery List
        ListInterface<Delivery> deliveryList = new CircularDoublyLinkedList<>();
        deliveryList.add(delivery1);
        deliveryList.add(delivery2);
        deliveryList.add(delivery3);
        deliveryList.add(delivery4);
        
        //Store Delivery List to delivery.dat
        File.storeList(deliveryList, DELIVERYFILE);
    }
    
}
