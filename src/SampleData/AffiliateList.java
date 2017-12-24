package SampleData;


import ADTs.CircularDoublyLinkedList;
import ADTs.LinearSinglyLinkedList;
import ADTs.ListInterface;
import Classes.Address;
import Classes.Affiliate;
import Classes.File;
import Classes.MenuItem;
import Classes.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class AffiliateList {
    public static final String AFFILIATEFILE = "affiliate.dat";
    
    public static void main(String[] args) {
        //Create Addresses
        Address address1 = new Address("AEON (Jusco) Cheras Selatan Shopping Centre", "Selangor", "Balakong", 43200);
        Address address2 = new Address("90, Jalan Peel, Maluri,", "Kuala Lumpur", "Wilayah Persekutuan", 55100);
        
        //Create Affiliates
        Affiliate affiliate1 = new Affiliate("Tealive", "962113-K", "000808083456", "03-62113891", address1, "tealive", "1234", "Bryan Loo", 'M', "012-3456789");
        Affiliate affiliate2 = new Affiliate("OldTown White Coffee", "830776-U", "000801587200", "03-12566852", address2, "oldtown", "1234", "Goh Ching Mun", 'M', "011-45621445");
        
        //Create MenuItems for Tealive
        MenuItem menuItem1 = new MenuItem("Original Pearl Milk Tea", "Regular Size", 6.50, 0);
        MenuItem menuItem2 = new MenuItem("Hazelnut Milk Tea", "Regular Size", 6.50, 0);
        MenuItem menuItem3 = new MenuItem("Superior Coco", "Regular Size", 6.50, 0); 
        ListInterface<MenuItem> beverage1 = new LinearSinglyLinkedList<>();
        beverage1.add(menuItem1);
        beverage1.add(menuItem2);
        beverage1.add(menuItem3);
        affiliate1.setBeverage(beverage1);
        
        MenuItem menuItem4 = new MenuItem("Chicken Shroom Pie", "", 4.9, 0);
        MenuItem menuItem5 = new MenuItem("Beefo Cheese Pie", "", 4.9, 0);
        MenuItem menuItem6 = new MenuItem("Cheeky Chicky Pops", "", 7.9, 0);
        MenuItem menuItem7 = new MenuItem("Hot BBQ Pops", "", 7.9, 0);
        ListInterface<MenuItem> food1 = new LinearSinglyLinkedList<>();
        food1.add(menuItem4);
        food1.add(menuItem5);
        food1.add(menuItem6);
        food1.add(menuItem7);
        affiliate1.setFood(food1);
        
        //Create MenuItems for OldTown White Coffee
        MenuItem menuItem8 = new MenuItem("Nasi Lemak With Fried Chicken", "", 10.00, 0);
        MenuItem menuItem9 = new MenuItem("Rendang Chicken Rice", "", 12.50, 0);
        MenuItem menuItem10 = new MenuItem("Curry Mee", "", 8.50, 0);
        MenuItem menuItem11 = new MenuItem("Asam Laksa", "", 8.50, 0);
        ListInterface<MenuItem> food2 = new LinearSinglyLinkedList<>();
        food2.add(menuItem8);
        food2.add(menuItem9);
        food2.add(menuItem10);
        food2.add(menuItem11);
        affiliate2.setFood(food2);
        
        MenuItem menuItem12 = new MenuItem("Enriched Chocolate", "Regular Size", 5.00, 0);
        MenuItem menuItem13 = new MenuItem("Orange Juice", "Regular Size", 5.00, 0);
        ListInterface<MenuItem> beverage2 = new LinearSinglyLinkedList<>();
        beverage2.add(menuItem12);
        beverage2.add(menuItem13);
        affiliate2.setBeverage(beverage2);
        
        //Create Affiliate List
        ListInterface<Affiliate> affiliateList = new LinearSinglyLinkedList<>();
        affiliateList.add(affiliate1);
        affiliateList.add(affiliate2);
        
        //Print Affiliates' Details
        System.out.println(String.format("%-4s %-10s %-20s %-6s %-12s %-30s %-12s %-12s %-15s %-80s", "ID", "USERNAME", "OWNER_NAME", "GENDER", "CONTACT_NO", "RESTAURANT_NAME", "BUSS_REG_No", "GST_REG_NO", "REST_CONTACT_NO", "ADDRESS"));
        for (int i = 1; i <= affiliateList.getNumberOfEntries(); i++) {
            System.out.println(affiliateList.getEntry(i));
        }
        
        //Print Tealive's Beverage List
        System.out.println("\nTealive Beverage List");
        System.out.println(String.format("%-30s %-30s %10s %12s %-15s", "NAME", "DESCRIPTION", "PRICE(RM)", "DISCOUNT(%)", "STATUS"));
        for (int i = 1; i <= affiliate1.getBeverage().getNumberOfEntries(); i++) {
            System.out.println(affiliate1.getBeverage().getEntry(i));
        }
        
        //Print OldTown's Food List
        System.out.println("\nOldTown Food List");
        System.out.println(String.format("%-30s %-30s %10s %12s %-15s", "NAME", "DESCRIPTION", "PRICE(RM)", "DISCOUNT(%)", "STATUS"));
        for (int i = 1; i <= affiliate2.getFood().getNumberOfEntries(); i++) {
            System.out.println(affiliate2.getFood().getEntry(i));
        }
        
        //Store affiliateList to affiliate.dat
        File.storeList(affiliateList, AFFILIATEFILE);
    }
    
}
