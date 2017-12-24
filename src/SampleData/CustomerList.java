package SampleData;


import ADTs.CircularDoublyLinkedList;
import ADTs.ListInterface;
import Classes.Address;
import Classes.Customer;
import Classes.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class CustomerList {
    public static final String CUSTOMERFILE = "customer.dat";
    
    private static <T> ListInterface<T> initializeList(String fileName) { //Return a List from .dat file
        ListInterface<T> list = new CircularDoublyLinkedList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName));
            list = (CircularDoublyLinkedList) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return list;
    }

    private static <T> void storeList(ListInterface<T> list, String fileName) { //Store a List into .dat file
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(fileName));
            ooStream.writeObject(list);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot save to file");
        }
    }

    public static void main(String[] args) {
        //Create Addresses
        Address address1 = new Address("Jalan Suasana 3/4, Bandar Tun Hussein Onn", "Selangor", "Cheras", 43200);
        Address address2 = new Address("Jalan Han 1/2, Taman Han", "Kuala Lumpur", "Setapak", 53300);
        Address address3 = new Address("Jalan Melaka, Taman Melaka", "Melaka", "Bandar Hili", 75000);
        
        //Create Birth Dates
        GregorianCalendar date1 = new GregorianCalendar(1997, 1, 19);// 19/02/1997
        GregorianCalendar date2 = new GregorianCalendar(1996, 10, 15);// 15/11/1996
        GregorianCalendar date3 = new GregorianCalendar(1997, 0, 6);// 06/01/1997     
        
        //Create Customers
        Customer customer1 = new Customer("luckytck97@gmail.com", date1, address1, "customer1", "1234", "Tan Cheong Kiat", 'M', "011-37997626");
        Customer customer2 = new Customer("hanhan@gmail.com", date2, address2, "customer2", "1234", "Tan Qi Han", 'M', "012-3456789");
        Customer customer3 = new Customer("liyi@gmail.com", date3, address3, "customer3", "1234", "Wong Li Yi", 'F', "011-12345678");
        
        //Print Customers' Details
        System.out.println(String.format("%-4s %-10s %-20s %-6s %-12s %-20s %-10s %-80s", "ID", "USERNAME", "NAME", "GENDER", "CONTACT_NO", "EMAIL", "BIRTH_DATE", "ADDRESS"));
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        
        //Create Customer List
        ListInterface<Customer> customerList = new CircularDoublyLinkedList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        
        //Store customerList into customer.dat
        storeList(customerList, CUSTOMERFILE);
        
        //Retrieve customerList from customer.dat to sampleList
        ListInterface<Customer> sampleList = initializeList(CUSTOMERFILE);
        ListInterface<User> userList = initializeList(CUSTOMERFILE);
        
        //Print SampleList's Details
        System.out.println(String.format("\n%-4s %-10s %-20s %-6s %-12s %-20s %-10s %-80s", "ID", "USERNAME", "NAME", "GENDER", "CONTACT_NO", "EMAIL", "BIRTH_DATE", "ADDRESS"));
        for (int i = 1; i <= sampleList.getNumberOfEntries(); i++) {
            System.out.println(sampleList.getEntry(i));
        }
    }
    
}
