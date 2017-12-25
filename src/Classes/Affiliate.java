package Classes;

import ADTs.CircularDoublyLinkedList;
import ADTs.LinearSinglyLinkedList;
import ADTs.ListInterface;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Affiliate extends User implements Serializable{
    private String restaurantName;
    private String businessRegNo; //Format - ######-# e.g 123456-M
    private String GSTRegNo; //Format - 12-digit number e.g 000130928640
    private String restaurantContactNo; //Format - 03-########
    private Address address;
      private String sortBy="Newest";
    private ListInterface<MenuItem> food;
    private ListInterface<MenuItem> beverage;

    public Affiliate() {
    }

    public Affiliate(String restaurantName, String businessRegNo, String GSTRegNo, String restaurantContactNo, Address address, String username, String password, String name, char gender, String contactNo) {
        super(username, password, name, gender, contactNo);
        this.restaurantName = restaurantName;
        this.businessRegNo = businessRegNo;
        this.GSTRegNo = GSTRegNo;
        this.restaurantContactNo = restaurantContactNo;
        this.address = address;
        this.food = new LinearSinglyLinkedList<>();
        this.beverage = new LinearSinglyLinkedList<>();
        this.sortBy="Newest";
    }
      public String getSortBy(){
        return sortBy;
    }
    public void setSortBy(String sortBy){
        this.sortBy=sortBy;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getBusinessRegNo() {
        return businessRegNo;
    }

    public void setBusinessRegNo(String businessRegNo) {
        this.businessRegNo = businessRegNo;
    }

    public String getGSTRegNo() {
        return GSTRegNo;
    }

    public void setGSTRegNo(String GSTRegNo) {
        this.GSTRegNo = GSTRegNo;
    }

    public String getRestaurantContactNo() {
        return restaurantContactNo;
    }

    public void setRestaurantContactNo(String restaurantContactNo) {
        this.restaurantContactNo = restaurantContactNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ListInterface<MenuItem> getFood() {
        return food;
    }

    public void setFood(ListInterface<MenuItem> food) {
        this.food = food;
    }

    public ListInterface<MenuItem> getBeverage() {
        return beverage;
    }

    public void setBeverage(ListInterface<MenuItem> beverage) {
        this.beverage = beverage;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %-30s %-12s %-12s %-15s %-80s", restaurantName, businessRegNo, GSTRegNo, restaurantContactNo, address);
    }

    public static void main(String[] args) { //Run it to understand
        Address address1 = new Address("AEON (Jusco) Cheras Selatan Shopping Centre", "Selangor", "Balakong", 43200);
        Address address2 = new Address("90, Jalan Peel, Maluri,", "Kuala Lumpur", "Wilayah Persekutuan", 55100);
        
        //2 way to declare Affiliate object
        User affiliate1 = new Affiliate("Tealive", "962113-K", "000808083456", "03-62113891", address1, "chatime", "1234", "Bryan Loo", 'M', "012-3456789");
        Affiliate affiliate2 = new Affiliate("OldTown White Coffee", "830776-U", "000801587200", "03-12566852", address2, "oldtown", "1234", "Goh Ching Mun", 'M', "011-45621445");
         Affiliate affiliate3 = new Affiliate("OldTown White Coffee", "830776-U", "000801587200", "03-12566852", address2, "Ali BABA", "1234", "Goh Ching Mun", 'M', "011-45621445");
        System.out.println(String.format("%-4s %-10s %-20s %-6s %-12s %-30s %-12s %-12s %-15s %-80s", "ID", "USERNAME", "OWNER_NAME", "GENDER", "CONTACT_NO", "RESTAURANT_NAME", "BUSS_REG_No", "GST_REG_NO", "REST_CONTACT_NO", "ADDRESS"));
        System.out.println(affiliate1);
        System.out.println(affiliate2);
        
        //Note - If you want use getter & setter in child class, u need cast it to the child class first e.g below
        System.out.println(((Affiliate)affiliate1).getBusinessRegNo());
        
        //Note - If you declare the class using child class name, you no need cast it to the child class e.g below
        System.out.println(affiliate2.getBusinessRegNo());

        //Example to store food to the affiliate class
        ListInterface<MenuItem> food1 = new CircularDoublyLinkedList<>();
         ListInterface<MenuItem> beverage1 = new CircularDoublyLinkedList<>();
        MenuItem item1 = new MenuItem("Mee Goreng", "", 4.00, 0);
        MenuItem item2 = new MenuItem("Nasi Goreng", "", 5.00, 10);
        MenuItem item3 = new MenuItem("Lobster burger", "Special Promotion", 50.00, 10);
           MenuItem item4 = new MenuItem("burger juice", "Special Promotion", 50.00, 10);
           MenuItem item5 = new MenuItem("Nasi tea", "", 5.00, 10);
        food1.add(item1);
        food1.add(item2);
        food1.add(item3);
        beverage1.add(item4);
        beverage1.add(item5);
        affiliate2.setFood(food1);
        affiliate3.setFood(food1);
        affiliate3.setBeverage(beverage1);
        //Example to retrive food from the affiliate class
        ListInterface<MenuItem> food2 = affiliate2.getFood();
        System.out.println(String.format("%-30s %-30s %10s %12s %-15s", "NAME", "DESCRIPTION", "PRICE(RM)", "DISCOUNT(%)", "STATUS"));
        for (int i = 1; i <= food2.getNumberOfEntries(); i++) {
            System.out.println(food2.getEntry(i).toString());
        }
        ListInterface<Affiliate> A=new CircularDoublyLinkedList<>();
        A.add(affiliate3);
        A.add(affiliate2);
         try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("Affiliate.dat"));
            ooStream.writeObject(A);          
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot save to file");
        }   
    }
}