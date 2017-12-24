
package SampleData;

import ADTs.CircularDoublyLinkedList;
import ADTs.ListInterface;
import Classes.Address;
import Classes.DeliveryMan;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeliveryManList {
    public static final String DELIVERYMANFILE = "deliveryMan.dat";
    
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
        
        //Create Delivery Men
        DeliveryMan deliveryMan1 = new DeliveryMan("970219-14-6459","luckytck97@gmail.com", 2000.00, address1, "luckytck", "1234", "Tan Cheong Kiat", 'M', "011-37997626");
        DeliveryMan deliveryMan2 = new DeliveryMan("971115-14-1455","qihan@gmail.com", 1900.00, address2, "hanhan", "1234", "Tan Qi Han", 'M', "012-3456789");
        DeliveryMan deliveryMan3 = new DeliveryMan("971115-14-1455","liyi@gmail.com", 1900.00, address2, "liyi", "1234", "Wong Li Yi", 'F', "012-3456789");
        DeliveryMan deliveryMan4 = new DeliveryMan("971115-14-1455","shiouchein@gmail.com", 1900.00, address2, "shiouchein", "1234", "Wo Shiou Chein", 'F', "012-3456789");
        
        //Print Delivery Men Details
        System.out.println(String.format("%-4s %-10s %-20s %-6s %-12s %-14s %-20s %-12s %-80s %-10s %-14s", "ID", "USERNAME", "NAME", "GENDER", "CONTACT_NO", "NRIC", "EMAIL", "BASIC_SALARY", "ADDRESS", "STATUS", "WORKING_STATUS"));
        System.out.println(deliveryMan1);
        System.out.println(deliveryMan2);
        
        //Create Delivery Man List
        ListInterface<DeliveryMan> deliveryManList = new CircularDoublyLinkedList<>();
        deliveryManList.add(deliveryMan1);
        deliveryManList.add(deliveryMan2);
        deliveryManList.add(deliveryMan3);
        deliveryManList.add(deliveryMan4);
        
        //Store Delivery Man List into deliveryMan.dat
        storeList(deliveryManList, DELIVERYMANFILE);
    }
    
}
