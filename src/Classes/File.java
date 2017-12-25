package Classes;

import ADTs.CircularDoublyLinkedList;
import ADTs.CircularDoublyLinkedQueue;
import ADTs.LinearDoublyLinkedList;
import ADTs.LinearDoublyLinkedStack;
import ADTs.LinearDoublyListInterface;
import ADTs.LinearSinglyLinkedList;
import ADTs.LinkedQueue;
import ADTs.ListInterface;
import ADTs.QueueInterface;
import ADTs.StackInterface;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class File {

    /**
     * Task: Store a new list to a specified file name within the project
     * directory.
     *
     * @param list an ListInterface being saved into the specified file name
     * @param fileName an String of the file name
     */
    public static <T> void storeList(ListInterface<T> list, String fileName) {
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

    /**
     * Task: Retrieve a list from a specified file name within the project
     * directory.
     *
     * @param fileName an String of the file name where the list stored at
     * @return a reference to the indicated list or null, if either file does
     * not exist or the file does not contains a list
     */
    public static <T> ListInterface<T> retrieveList(String fileName) {
        ListInterface<T> list = new CircularDoublyLinkedList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName));
            list = (ListInterface<T>) (oiStream.readObject());
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

    /**
     * Task: Store a new queue to a specified file name within the project
     * directory.
     *
     * @param queue an QueueInterface being saved into the specified file name
     * @param fileName an String of the file name
     */
    public static <T> void storeQueue(QueueInterface<T> queue, String fileName) {
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(fileName));
            ooStream.writeObject(queue);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot save to file");
        }
    }

    /**
     * Task: Retrieve a queue from a specified file name within the project
     * directory.
     *
     * @param fileName an String of the file name where the list stored at
     * @return a reference to the indicated queue or null, if either file does
     * not exist or the file does not contains a queue
     */
    public static <T> QueueInterface<T> retrieveQueue(String fileName) {
        QueueInterface<T> queue = new CircularDoublyLinkedQueue<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName));
            queue = (QueueInterface<T>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return queue;
    }

    public static <T> void storeOrder(QueueInterface<T> queue, String fileName) {
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(fileName));
            ooStream.writeObject(queue);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot save to file");
        }
    }

    public static <T> QueueInterface<T> retrieveOrder(String fileName) {
        QueueInterface<T> queue = new LinkedQueue<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName));
            queue = (QueueInterface<T>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return queue;
    }

    public static <T> void storeToList(LinearDoublyListInterface<T> doublylist, String fileName) {
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(fileName));
            ooStream.writeObject(doublylist);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot save to file");
        }
    }

    public static <T> LinearDoublyListInterface<T> retrieveFromList(String fileName) {
        LinearDoublyListInterface<T> doublylist = new LinearDoublyLinkedList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName));
            doublylist = (LinearDoublyListInterface<T>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return doublylist;
    }

    public static int getAffiliateIndex(String username, String fileName) {
        ListInterface<User> list = retrieveList(fileName);
        int index = -1;
        for (int i = 1; i <= list.getNumberOfEntries(); ++i) {
            if (list.getEntry(i).getUsername().equals(username)) {//matching the username
                index = i;//store the index number into variable index
            }
        }
        return index;
    }

    public static ListInterface getSortedMenuItem(int index, int menuCode) {
        ListInterface<Affiliate> list = retrieveList("affiliate.dat");
        ListInterface<MenuItem> tempMenu = new LinearSinglyLinkedList<>();
        if (menuCode == 1) {
            if (list.getEntry(index).getSortBy().equals("Newest")) {
                StackInterface<MenuItem> menulist = new LinearDoublyLinkedStack<>();
                for (int i = 1; i <= list.getEntry(index).getFood().getNumberOfEntries(); ++i) {
                    menulist.push(list.getEntry(index).getFood().getEntry(i));
                }
                int num = 1;
                //to reverse the sequence
                while (num <= list.getEntry(index).getFood().getNumberOfEntries()) {
                    tempMenu.add(menulist.pop());
                    ++num;
                }

            } else if (list.getEntry(index).getSortBy().equals("Promotion")) {
                ListInterface<MenuItem> menulist = new LinearSinglyLinkedList<>();
                //to get the items order by discount rate 
                while (!list.getEntry(index).getFood().isEmpty()) {
                    int indexAddtoList = -1;
                    double bigest = -1;
                    for (int a = 1; a <= list.getEntry(index).getFood().getNumberOfEntries(); ++a) {

                        if (list.getEntry(index).getFood().getEntry(a).getDiscountRate() > bigest) {
                            bigest = list.getEntry(index).getFood().getEntry(a).getDiscountRate();
                            indexAddtoList = a;
                        }
                    }
                    menulist.add(list.getEntry(index).getFood().getEntry(indexAddtoList));
                    list.getEntry(index).getFood().remove(indexAddtoList);
                }
                tempMenu = menulist;
            }
            return tempMenu;
        } else {
            if (list.getEntry(index).getSortBy().equals("Newest")) {
                StackInterface<MenuItem> menulist = new LinearDoublyLinkedStack<>();
                for (int i = 1; i <= list.getEntry(index).getBeverage().getNumberOfEntries(); ++i) {
                    menulist.push(list.getEntry(index).getBeverage().getEntry(i));
                }
                int num = 1;
                //reverse the sequence
                while (num <= list.getEntry(index).getBeverage().getNumberOfEntries()) {
                    tempMenu.add(menulist.pop());
                    ++num;
                }
            } else if (list.getEntry(index).getSortBy().equals("Promotion")) {
                ListInterface<MenuItem> menulist = new LinearSinglyLinkedList<>();
                //get the sequence order by discount rate
                while (!list.getEntry(index).getBeverage().isEmpty()) {
                    int indexAddtoList = -1;
                    double bigest = -1;
                    for (int a = 1; a <= list.getEntry(index).getBeverage().getNumberOfEntries(); ++a) {

                        if (list.getEntry(index).getBeverage().getEntry(a).getDiscountRate() > bigest) {
                            bigest = list.getEntry(index).getBeverage().getEntry(a).getDiscountRate();
                            indexAddtoList = a;
                        }
                    }
                    menulist.add(list.getEntry(index).getBeverage().getEntry(indexAddtoList));
                    list.getEntry(index).getBeverage().remove(indexAddtoList);
                }
                tempMenu = menulist;
            }
            return tempMenu;
        }

    }

    public static int getDatMenuItemIndex(int index, int menuCode, int choice) {
        ListInterface<Affiliate> list = retrieveList("affiliate.dat");
        ListInterface<MenuItem> tempMenu = getSortedMenuItem(index, menuCode);
        int datIndex = -1;
        //matching the item by item name
        if (menuCode == 1) {
            for (int i = 1; i <= list.getEntry(index).getFood().getNumberOfEntries(); ++i) {
                if (list.getEntry(index).getFood().getEntry(i).getName().equals(tempMenu.getEntry(choice).getName())) {
                    datIndex = i;
                }
            }
        } else {
            for (int i = 1; i <= list.getEntry(index).getBeverage().getNumberOfEntries(); ++i) {
                if (list.getEntry(index).getBeverage().getEntry(i).getName().equals(tempMenu.getEntry(choice).getName())) {
                    datIndex = i;
                }
            }
        }
        return datIndex;//return the item index in dat file
    }

    public static void printMenuItem(int index, int menuCode) {
        ListInterface<Affiliate> list = retrieveList("affiliate.dat");
        if (menuCode == 1) {
            System.out.println("Food           sort by " + list.getEntry(index).getSortBy());
            System.out.println("=====================================");
            String Title, Price, Discount, Status, Description;
            Title = "TiTle";
            Description = "Description";
            Price = "Price";
            Discount = "Discount(%)";
            Status = "Status";
            String outputStr = String.format("%-30s %-30s %14s %12s %-15s \n", Title, Description, Price, Discount, Status);
            if (list.getEntry(index).getFood().isEmpty() == true) {
                System.out.println("No item in the list.");
            } else {
                if (list.getEntry(index).getSortBy().equals("Newest")) {
                    //reverse the sequence
                    StackInterface<MenuItem> menulist = new LinearDoublyLinkedStack<>();
                    for (int i = 1; i <= list.getEntry(index).getFood().getNumberOfEntries(); ++i) {
                        menulist.push(list.getEntry(index).getFood().getEntry(i));
                    }
                    int num = 1;
                    while (num <= list.getEntry(index).getFood().getNumberOfEntries()) {
                        outputStr += num + ". " + menulist.pop() + "\n";
                        ++num;
                    }
                    System.out.println(outputStr);
                } else if (list.getEntry(index).getSortBy().equals("Promotion")) {
                    ListInterface<MenuItem> menulist = new LinearSinglyLinkedList<>();
                    //sort the item by discount rate
                    while (!list.getEntry(index).getFood().isEmpty()) {
                        int indexAddtoList = -1;
                        double bigest = -1;
                        for (int a = 1; a <= list.getEntry(index).getFood().getNumberOfEntries(); ++a) {
                            if (list.getEntry(index).getFood().getEntry(a).getDiscountRate() > bigest) {
                                bigest = list.getEntry(index).getFood().getEntry(a).getDiscountRate();
                                indexAddtoList = a;
                            }
                        }
                        menulist.add(list.getEntry(index).getFood().getEntry(indexAddtoList));
                        list.getEntry(index).getFood().remove(indexAddtoList);
                    }
                    for (int i = 1; i <= menulist.getNumberOfEntries(); ++i) {
                        outputStr += i + ". " + menulist.getEntry(i) + "\n";
                    }
                    System.out.println(outputStr);
                }
            }
        } else {
            System.out.println("Beverage       sort by " + list.getEntry(index).getSortBy());
            System.out.println("=====================================");
            if (list.getEntry(index).getBeverage().isEmpty()) {
                System.out.println("No item in the list.");
            } else {
                String Title, Price, Discount, Status, Description;
                Title = "TiTle";
                Description = "Description";
                Price = "Price";
                Discount = "Discount(%)";
                Status = "Status";
                String outputStr = String.format("%-30s %-30s %14s %12s %-15s \n", Title, Description, Price, Discount, Status);
                if (list.getEntry(index).getBeverage().isEmpty() == true) {
                    System.out.println("No item in the list.");
                } else {
                    if (list.getEntry(index).getSortBy().equals("Newest")) {
                        //reverse the sequence
                        StackInterface<MenuItem> menulist = new LinearDoublyLinkedStack<>();
                        for (int i = 1; i <= list.getEntry(index).getBeverage().getNumberOfEntries(); ++i) {
                            menulist.push(list.getEntry(index).getBeverage().getEntry(i));
                        }
                        int num = 1;
                        while (num <= list.getEntry(index).getBeverage().getNumberOfEntries()) {
                            outputStr += num + ". " + menulist.pop() + "\n";
                            ++num;
                        }
                        System.out.println(outputStr);
                    } else if (list.getEntry(index).getSortBy().equals("Promotion")) {
                        ListInterface<MenuItem> menulist = new LinearSinglyLinkedList<>();
                        //sort the item by discount rate
                        while (!list.getEntry(index).getBeverage().isEmpty()) {
                            int indexAddtoList = -1;
                            double bigest = -1;
                            for (int a = 1; a <= list.getEntry(index).getBeverage().getNumberOfEntries(); ++a) {

                                if (list.getEntry(index).getBeverage().getEntry(a).getDiscountRate() > bigest) {
                                    bigest = list.getEntry(index).getBeverage().getEntry(a).getDiscountRate();
                                    indexAddtoList = a;
                                }
                            }
                            menulist.add(list.getEntry(index).getBeverage().getEntry(indexAddtoList));
                            list.getEntry(index).getBeverage().remove(indexAddtoList);
                        }
                        for (int i = 1; i <= menulist.getNumberOfEntries(); ++i) {
                            outputStr += i + ". " + menulist.getEntry(i) + "\n";
                        }
                        System.out.println(outputStr);
                    }
                }
            }
        }
    }

    public static void printWholeMenu(int index) {
        ListInterface<Affiliate> list = retrieveList("affiliate.dat");
        if (list.getEntry(index).getFood().isEmpty() == true) {
            System.out.println("No item in the list.");
        } else {
            String title = "Item", description = "Description", price = "Price", discount = "Discount", status = "Status";
            String outputStr = String.format("%-30s %-30s %14s %12s %-15s \n", title, description, price, discount, status);
            System.out.println("\nAvailable Food Menu");
            System.out.println("===================");
            if (list.getEntry(index).getSortBy().equals("Newest")) {
                StackInterface<MenuItem> menulist = new LinearDoublyLinkedStack<>();
                for (int i = 1; i <= list.getEntry(index).getFood().getNumberOfEntries(); ++i) {
                    menulist.push(list.getEntry(index).getFood().getEntry(i));
                }
                int num = 1;
                while (num <= list.getEntry(index).getFood().getNumberOfEntries()) {
                    outputStr += num + ". " + menulist.pop() + "\n";
                    ++num;
                }
                System.out.println(outputStr);
            } else if (list.getEntry(index).getSortBy().equals("Promotion")) {
                ListInterface<MenuItem> menulist = new LinearSinglyLinkedList<>();
                while (!list.getEntry(index).getFood().isEmpty()) {
                    int indexAddtoList = -1;
                    double bigest = -1;
                    for (int a = 1; a <= list.getEntry(index).getFood().getNumberOfEntries(); ++a) {

                        if (list.getEntry(index).getFood().getEntry(a).getDiscountRate() > bigest) {
                            bigest = list.getEntry(index).getFood().getEntry(a).getDiscountRate();
                            indexAddtoList = a;
                        }
                    }
                    menulist.add(list.getEntry(index).getFood().getEntry(indexAddtoList));
                    list.getEntry(index).getFood().remove(indexAddtoList);
                }
                for (int i = 1; i <= menulist.getNumberOfEntries(); ++i) {
                    outputStr += i + ". " + menulist.getEntry(i) + "\n";
                }
                System.out.println(outputStr);
            }
        }

        System.out.println("\n");
        if (list.getEntry(index).getFood().isEmpty() == true) {
            System.out.println("No item in the list.");
        } else {
            String title = "Item", description = "Description", price = "Price", discount = "Discount", status = "Status";
            String outputStr = String.format("%-30s %-30s %14s %12s %-15s \n", title, description, price, discount, status);
            System.out.println("\nAvailable Beverage Menu");
            System.out.println("===================");
            if (list.getEntry(index).getSortBy().equals("Newest")) {
                StackInterface<MenuItem> menulist = new LinearDoublyLinkedStack<>();
                for (int i = 1; i <= list.getEntry(index).getBeverage().getNumberOfEntries(); ++i) {
                    menulist.push(list.getEntry(index).getBeverage().getEntry(i));
                }
                int num = 1;
                while (num <= list.getEntry(index).getBeverage().getNumberOfEntries()) {
                    outputStr += num + ". " + menulist.pop() + "\n";
                    ++num;
                }
                System.out.println(outputStr);
            } else if (list.getEntry(index).getSortBy().equals("Promotion")) {
                ListInterface<MenuItem> menulist = new LinearSinglyLinkedList<>();
                while (!list.getEntry(index).getBeverage().isEmpty()) {
                    int indexAddtoList = -1;
                    double bigest = -1;
                    for (int a = 1; a <= list.getEntry(index).getBeverage().getNumberOfEntries(); ++a) {

                        if (list.getEntry(index).getBeverage().getEntry(a).getDiscountRate() > bigest) {
                            bigest = list.getEntry(index).getBeverage().getEntry(a).getDiscountRate();
                            indexAddtoList = a;
                        }
                    }
                    menulist.add(list.getEntry(index).getBeverage().getEntry(indexAddtoList));
                    list.getEntry(index).getBeverage().remove(indexAddtoList);
                }
                for (int i = 1; i <= menulist.getNumberOfEntries(); ++i) {
                    outputStr += i + ". " + menulist.getEntry(i) + "\n";
                }
                System.out.println(outputStr);
            }
        }
    }
}
