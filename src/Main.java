
import ADTs.CircularDoublyLinkedList;
import ADTs.LinearDoublyListInterface;
import ADTs.LinearSinglyLinkedList;
import ADTs.ListInterface;
import ADTs.QueueInterface;
import ADTs.SortedDoublyLinkedList;
import ADTs.SortedListInterface;
import Classes.Address;
import Classes.Affiliate;
import Classes.Clocking;
import Classes.Customer;
import Classes.Delivery;
import Classes.DeliveryMan;
import Classes.DeliveryReport;
import Classes.MenuItem;
import Classes.File;
import Classes.File;

import Classes.Order;
import Classes.OrderItem;
import Classes.User;
import Classes.Validation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static final String PENDINGDELIVERYFILE = "pendingDelivery.dat";
    public static final String ORDERFILE = "order.dat";
    public static final String CUSTOMERFILE = "customer.dat";
    public static final String AFFILIATEFILE = "affiliate.dat";
    public static final String DELIVERYMANFILE = "deliveryMan.dat";
    public static final String OPERATIONALSTAFFFILE = "operationalStaff.dat";
    public static final String EXECUTIVEFILE = "executive.dat";
    public static final String DELIVERYFILE = "delivery.dat";
    public static final String CLOCKINGFILE = "clocking.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selection[] = new int[10];
        boolean loop[] = new boolean[10];
        do {
            loop[0] = false;
            System.out.println("Fastest Deliveryman");
            System.out.println("===================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Selection: ");
            if (!scanner.hasNext("[012]{1}")) {
                System.out.println("Please select option [0-3] only.");
                scanner.nextLine();
                loop[0] = true;
            } else {
                selection[0] = scanner.nextInt();
                scanner.nextLine();
                if (selection[0] == 1) {
                    do {
                        loop[1] = false;
                        System.out.println("Type Of Account");
                        System.out.println("===============");
                        System.out.println("1. Customer");
                        System.out.println("2. Affiliate");
                        System.out.println("3. Delivery Man");
                        System.out.println("4. Operational Staff");
                        System.out.println("5. HR Executive");
                        System.out.println("0. Return to previous page");
                        System.out.print("Login As: ");
                        if (!scanner.hasNext("[012345]{1}")) {
                            System.out.println("Please select option [0-5] only.");
                            scanner.nextLine();
                            loop[1] = true;
                        } else {
                            selection[1] = scanner.nextInt();
                            scanner.nextLine();
                            String fileName = "";
                            switch (selection[1]) {
                                case 1:
                                    fileName = CUSTOMERFILE;
                                    break;
                                case 2:
                                    fileName = AFFILIATEFILE;
                                    break;
                                case 3:
                                    fileName = DELIVERYMANFILE;
                                    break;
                                case 4:
                                    fileName = OPERATIONALSTAFFFILE;
                                    break;
                                case 5:
                                    fileName = EXECUTIVEFILE;
                                    break;
                            }
                            if (selection[1] >= 1 && selection[1] <= 5) {
                                do {
                                    loop[2] = false;
                                    System.out.println("Please login your account:");
                                    System.out.print("Username: ");
                                    String username = scanner.nextLine();
                                    System.out.print("Password: ");
                                    String password = scanner.nextLine();
                                    if (Validation.ValidateAccount(username, password, fileName)) {
                                        if (selection[1] == 1) {//Customer
                                            do {
                                                loop[3] = false;
                                                System.out.println("Operation List");
                                                System.out.println("==============");
                                                System.out.println("1. Place Ad-hoc Order");
                                                System.out.println("2. Track Order");
                                                System.out.println("0. Logout");
                                                System.out.print("Selection: ");
                                                if (!scanner.hasNext("[012]{1}")) {
                                                    System.out.println("Please select option [0-3] only.");
                                                    scanner.nextLine();
                                                    loop[3] = true;
                                                } else {
                                                    selection[2] = scanner.nextInt();
                                                    scanner.nextLine();
                                                    if (selection[2] == 1) {
                                                        //TODO: Place Ad-hoc Order
                                                        placeAdHocOrder(username);
                                                    } else if (selection[2] == 2) {
                                                        //TODO: Track Order
                                                        trackOrder(username);
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        } else if (selection[1] == 2) {//Affiliate
                                            do {
                                                loop[3] = false;
                                                System.out.println("Operation List");
                                                System.out.println("==============");
                                                System.out.println("1. Add New Items");
                                                System.out.println("2. Update Item Details");
                                                System.out.println("3. Update Item Status");
                                                System.out.println("4. Remove Items");
                                                System.out.println("0. Logout");
                                                System.out.print("Selection: ");
                                                if (!scanner.hasNext("[01234]{1}")) {
                                                    System.out.println("Please select option [0-4] only.");
                                                    scanner.nextLine();
                                                    loop[3] = true;
                                                } else {
                                                    selection[2] = scanner.nextInt();
                                                    scanner.nextLine();
                                                    if (selection[2] == 1) {
                                                        //TODO: Add New Items
                                                        addNewItems(username);
                                                    } else if (selection[2] == 2) {
                                                        //TODO: Update Item Details
                                                        updateItemDetails(username);
                                                    } else if (selection[2] == 3) {
                                                        //TODO: Update Item Status
                                                        updateItemStatus(username);
                                                    } else if (selection[2] == 4) {
                                                        //TODO: Remove Items
                                                        removeItems(username);
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        } else if (selection[1] == 3) {//Delivery Man
                                            do {
                                                loop[3] = false;
                                                System.out.println("Operation List");
                                                System.out.println("==============");
                                                System.out.println("1. Clock In");
                                                System.out.println("2. Clock Out");
                                                System.out.println("3. Retrieve Customer Details");
                                                System.out.println("4. Update Working Status");
                                                System.out.println("0. Logout");
                                                System.out.print("Selection: ");
                                                if (!scanner.hasNext("[01234]{1}")) {
                                                    System.out.println("Please select option [0-4] only.");
                                                    scanner.nextLine();
                                                    loop[3] = true;
                                                } else {
                                                    selection[2] = scanner.nextInt();
                                                    scanner.nextLine();
                                                    if (selection[2] == 1) {
                                                        //TODO: Clock In
                                                        clockIn(username);
                                                    } else if (selection[2] == 2) {
                                                        //TODO: Clock Out
                                                        clockOut(username);
                                                        loop[3] = true;
                                                    } else if (selection[2] == 3) {
                                                        //TODO: Retrieve Customer Details
                                                        retrieveCustomerDetails();
                                                    } else if (selection[2] == 4) {
                                                        //TODO: Update Working Status
                                                        updateWorkingStatus(username);
                                                        loop[3] = true;
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        } else if (selection[1] == 4) {//Operational Staff
                                            do {
                                                loop[3] = false;
                                                System.out.println("Operation List");
                                                System.out.println("==============");
                                                System.out.println("1. Retrieve Pending Delivery");
                                                System.out.println("0. Logout");
                                                System.out.print("Selection: ");
                                                if (!scanner.hasNext("[01]{1}")) {
                                                    System.out.println("Please selection option [0-2] only.");
                                                    scanner.nextLine();
                                                    loop[3] = true;
                                                } else {
                                                    selection[2] = scanner.nextInt();
                                                    scanner.nextLine();
                                                    if (selection[2] == 1) {
                                                        //TODO: Retrieve Pending Delivery
                                                        retrievePendingDelivery();
                                                        loop[3] = true;
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        } else if (selection[1] == 5) {//HR Executive
                                            do {
                                                loop[3] = false;
                                                System.out.println("Operation List");
                                                System.out.println("==============");
                                                System.out.println("1. Add New Delivery Man");
                                                System.out.println("2. Update Delivery Man Contact Details");
                                                System.out.println("3. Update Delivery Man Status");
                                                System.out.println("4. Generate Daily Delivery Report");
                                                System.out.println("0. Logout");
                                                System.out.print("Selection: ");
                                                if (!scanner.hasNext("[01234]{1}")) {
                                                    System.out.println("Please select option [0-4] only.");
                                                    scanner.nextLine();
                                                    loop[3] = true;
                                                } else {
                                                    selection[2] = scanner.nextInt();
                                                    scanner.nextLine();
                                                    if (selection[2] == 1) {
                                                        //TODO: Add New Delivery Man
                                                        addNewDeliveryMan();
                                                        loop[3] = true;
                                                    } else if (selection[2] == 2) {
                                                        //TODO: Update Delivery Man Details
                                                        updateDeliveryManContactDetails();
                                                        loop[3] = true;
                                                    } else if (selection[2] == 3) {
                                                        //TODO: Update Delivery Man Status
                                                        updateDeliveryManStatus();
                                                        loop[3] = true;
                                                    } else if (selection[2] == 4) {
                                                        //TODO: Generate Daily Report
                                                        generateDailyReport();
                                                        loop[3] = true;
                                                    } else {//Logout
                                                        loop[0] = true;
                                                    }
                                                }
                                            } while (loop[3] == true);
                                        }
                                    } else {
                                        System.out.println("Access Denied!!!");
                                        System.out.println("Please enter a valid username & password.");
                                        loop[2] = true;
                                    }
                                } while (loop[2] == true);

                            } else {//Return to previous page
                                loop[0] = true;
                            }
                        }

                    } while (loop[1] == true);
                } else if (selection[0] == 2) {//Register
                    do {
                        loop[1] = false;
                        System.out.println("Type Of Account");
                        System.out.println("===============");
                        System.out.println("1. Affiliate");
                        System.out.println("0. Return to previous page");
                        System.out.print("Register As: ");
                        if (!scanner.hasNext("[01]{1}")) {
                            System.out.println("Please select option [0-1] only.");
                            scanner.nextLine();
                            loop[1] = true;
                        } else {
                            selection[1] = scanner.nextInt();
                            scanner.nextLine();
                            if (selection[1] == 1) {
                                //TODO: Register As Affiliate
                                registerAsAffiliate();
                            } else {//Return to previous page
                                loop[0] = true;
                            }
                        }
                    } while (loop[1] == true);

                } else {
                    System.out.println("Thank you for using this system.");
                    System.out.println("Please come back again~");
                }
            }
        } while (loop[0] == true);
    }

    public static void placeAdHocOrder(String username) {

        //Get customer's details
        ListInterface<Customer> customerList = File.retrieveList(CUSTOMERFILE);
        Customer customer = new Customer();
        for (int i = 1; i <= customerList.getNumberOfEntries(); i++) {

            if (customerList.getEntry(i).getUsername().equals(username)) {
                int custIndex = i;
                customer = (Customer) customerList.getEntry(custIndex);
            }
        }

        ListInterface<Affiliate> affiliateList = File.retrieveList(AFFILIATEFILE);
        String aff;

        //Get user choice of food & beverage
        int choice = 0, menu = 0, food = 0, foodQty = 0, beverage = 0, beverageQty = 0, index;
        String foodRemark, bvgRemark;
        double totalPrice = 0;
        char more, confirm;
        GregorianCalendar orderDate = new GregorianCalendar();
        Scanner scanner = new Scanner(System.in);

        System.out.println("No.\t Restaurants");
        System.out.println("======================");
        for (int i = 1; i <= affiliateList.getNumberOfEntries(); i++) {
            System.out.println(i + "\t" + affiliateList.getEntry(i).getRestaurantName());
        }

        do {
            System.out.print("Please select a restaurant> ");
            if (!scanner.hasNext("[1-" + affiliateList.getNumberOfEntries() + "]{1}")) {
                System.out.println("Please enter valid restaurant");
            } else {
                choice = scanner.nextInt();
            }
            scanner.nextLine();

        } while (choice < 1 || choice > affiliateList.getNumberOfEntries());

        //Get affiliate's details
        aff = affiliateList.getEntry(choice).getUsername();
        index = File.getAffiliateIndex(aff, AFFILIATEFILE);
        Affiliate affiliate = new Affiliate();
        affiliate = (Affiliate) affiliateList.getEntry(index);
        File.printWholeMenu(index);

        ListInterface<OrderItem> orderMenu = new LinearSinglyLinkedList<>();
        OrderItem order = new OrderItem(); //temperory store the menu which choose by customer

        do {
            do {
                System.out.print("Order food/beverage? (1=Food, 2=Beverage, 0=Exit)> ");

                menu = scanner.nextInt();
                scanner.nextLine();

                if (menu < 0 || menu > 2) {
                    System.out.println("Please enter number between 0 to 2 only");
                }
            } while (menu < 0 || menu > 2);

            switch (menu) {
                case 1:
                    do {
                        System.out.print("Please enter your food number> ");
                        if (!scanner.hasNext("[1-" + affiliateList.getEntry(index).getFood().getNumberOfEntries() + "]{1}")) {
                            System.out.println("Please enter valid food number only");
                        } else {
                            food = scanner.nextInt();

                            if (affiliateList.getEntry(index).getFood().getEntry(food).getStatus().equals("Unavailable")) {
                                System.out.println("This food item unavailable, please choose again.");
                            }
                        }
                        scanner.nextLine();
                    } while (food < 1 || food > affiliateList.getEntry(index).getFood().getNumberOfEntries()
                            || affiliateList.getEntry(index).getFood().getEntry(food).getStatus().equals("Unavailable"));

                    do {
                        System.out.print("Quantity> ");
                        foodQty = scanner.nextInt();
                        scanner.nextLine();
                        if (foodQty < 1) {
                            System.out.println("Food quantity cannot less than 1");
                        }
                    } while (foodQty < 1);

                    System.out.print("Any special remark? Please state down> ");
                    foodRemark = scanner.nextLine();

                    int datIndex = File.getDatMenuItemIndex(index, menu, food);
                    order.setMenuItem(affiliateList.getEntry(index).getFood().getEntry(datIndex));
                    order.setQuantity(foodQty);
                    order.setRemark(foodRemark);
                    orderMenu.add(order);
                    order = new OrderItem();

                    break;

                case 2:
                    do {
                        System.out.print("Please enter your beverage number> ");
                        if (!scanner.hasNext("[1-" + affiliateList.getEntry(index).getBeverage().getNumberOfEntries() + "]{1}")) {
                            System.out.println("Please enter valid beverage number only");
                        } else {
                            beverage = scanner.nextInt();

                            if (affiliateList.getEntry(index).getBeverage().getEntry(beverage).getStatus().equals("Unavailable")) {
                                System.out.println("This beverage item unavailable, please choose again.");
                            }
                        }
                        scanner.nextLine();

                    } while (beverage < 1 || beverage > affiliateList.getEntry(index).getBeverage().getNumberOfEntries()
                            || affiliateList.getEntry(index).getBeverage().getEntry(beverage).getStatus().equals("Unavailable"));

                    do {
                        System.out.print("Quantity> ");
                        beverageQty = scanner.nextInt();
                        scanner.nextLine();
                        if (beverageQty < 1) {
                            System.out.println("Beverage quantity cannot less than 1");
                        }
                    } while (beverageQty < 1);

                    System.out.print("Any special remark? Please state down> ");
                    bvgRemark = scanner.nextLine();
                    menu = 2;
                    int dat2Index = File.getDatMenuItemIndex(index, menu, beverage);
                    order.setMenuItem(affiliateList.getEntry(index).getBeverage().getEntry(dat2Index));
                    order.setQuantity(beverageQty);
                    order.setRemark(bvgRemark);
                    orderMenu.add(order);
                    order = new OrderItem();
                    break;

                case 0:
                    System.out.println("Thanks for using this function. See you again~");
                    System.exit(0);

                    break;
            }

            System.out.println("\n");
            System.out.print("Wanna choose other food/beverage? (Y=Yes, N=No)> ");
            more = scanner.next().charAt(0);
            scanner.nextLine();

        } while (Character.toUpperCase(more) == 'Y');

        System.out.println("CONFIRM YOUR ORDER:");
        System.out.println("===================");
        System.out.println("No.\tItem\t\t\tUnit Price\tDiscount Price\t\tQuantity\tSub Total\tRemark");
        for (int i = 1; i <= orderMenu.getNumberOfEntries(); ++i) {
            System.out.println(i + "\t" + orderMenu.getEntry(i).getMenuItem().getName()
                    + "\t\t" + String.format("%.2f", orderMenu.getEntry(i).getMenuItem().getPrice())
                    + "\t\t" + String.format("%.2f", orderMenu.getEntry(i).calPriceAfterDiscount())
                    + "\t\t\t" + orderMenu.getEntry(i).getQuantity()
                    + "\t\t" + String.format("%.2f", orderMenu.getEntry(i).calSubTotal())
                    + "\t" + orderMenu.getEntry(i).getRemark());
            totalPrice += orderMenu.getEntry(i).calSubTotal();
        }
        System.out.println("\n");
        System.out.println("Total item ordered: " + orderMenu.getNumberOfEntries());
        System.out.println("Total Price: RM" + String.format("%.2f", totalPrice));
        System.out.print("Confirm order? (Y=Yes, N=No)> ");
        confirm = scanner.next().charAt(0);
        scanner.nextLine();

        if (Character.toUpperCase(confirm) == 'Y') {
            ListInterface<Order> orderList = File.retrieveList(ORDERFILE);
            Order.setNextOrderNo(1000 + orderList.getNumberOfEntries());

            QueueInterface<Order> orderQueue = File.retrieveOrder(PENDINGDELIVERYFILE);

            Order confirmOrder = new Order(orderMenu, customer, affiliate, orderDate);
            orderList.add(confirmOrder);
            File.storeList(orderList, ORDERFILE);

            orderQueue.enqueue(confirmOrder);
            File.storeOrder(orderQueue, PENDINGDELIVERYFILE);

            System.out.println("Your order stored successfully.");
            System.out.println("Your meal will be delivered within 1 hour. Thank you!");

        } else {
            System.out.println("Thanks for using this function, please come again~");
        }
    }

    public static void trackOrder(String username) {
        ListInterface<Order> orderList = File.retrieveList(ORDERFILE);
        GregorianCalendar currentDate = new GregorianCalendar();
        boolean gotRecord = false;

        System.out.println("Track Food Order");
        System.out.println("===========");

        if (!orderList.isEmpty()) {
            System.out.println("Order No \t Restaurant \t\t Order Date \t Order Time \t Order Status \t\t Estimated Remaining Time ");
            for (int i = 1; i <= orderList.getNumberOfEntries(); i++) {

                if (username.equalsIgnoreCase(orderList.getEntry(i).getCustomer().getUsername())) {

                    GregorianCalendar orderDate = orderList.getEntry(i).getOrderDate();

                    if (orderDate.get(Calendar.DAY_OF_MONTH) == currentDate.get(Calendar.DAY_OF_MONTH)
                            && orderDate.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)
                            && orderDate.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR)) {

                        long hour = (currentDate.get(Calendar.HOUR_OF_DAY) - orderDate.get(Calendar.HOUR_OF_DAY)) * 60;
                        long minutes = currentDate.get(Calendar.MINUTE) - orderDate.get(Calendar.MINUTE);
                        long seconds = (currentDate.get(Calendar.SECOND) - orderDate.get(Calendar.SECOND)) / 60;

                        long diff = 60 - (hour + minutes + seconds);

                        if (diff > 60) {
                            System.out.println(orderList.getEntry(i).getOrderNo() + "\t" + orderList.getEntry(i).getAffiliate().getRestaurantName() + "\t\t" + orderList.getEntry(i).printOrderDate()
                                    + "\t" + orderList.getEntry(i).printOrderTime() + "\t" + orderList.getEntry(i).getStatus() + "\t\t" + " delivered");

                        } else if (diff < 60 && diff > 0) {
                            System.out.println(orderList.getEntry(i).getOrderNo() + "\t" + orderList.getEntry(i).getAffiliate().getRestaurantName() + "\t" + orderList.getEntry(i).printOrderDate()
                                    + "\t" + orderList.getEntry(i).printOrderTime() + "\t" + orderList.getEntry(i).getStatus() + "\t" + diff + " minute(s)");
                            gotRecord = true;
                        }
                    }

                }
            }

            if (gotRecord == false) {
                System.out.println("You have no food order.");
                System.out.println("You will be returned back to operation list in 2 seconds...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }

        } else {
            System.out.println("You have no food order.");
            System.out.println("You will be returned back to operation list in 2 seconds...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
    }

    private static void addNewItems(String username) {
        Scanner scanner = new Scanner(System.in);
        int index = File.getAffiliateIndex(username, AFFILIATEFILE);

        ListInterface<Affiliate> affiliateList = File.retrieveList(AFFILIATEFILE);
        int choice = -1;
        do {
            System.out.println("Which type of menu you want to add? :");
            System.out.println("1.Food");
            System.out.println("2.Beverage");
            System.out.print("Enter the number of your choice :");
            if (!scanner.hasNext("[12]{1}")) {
                System.out.println("\nPlease enter integer.");
            } else {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1: {

                        File.printMenuItem(index, choice);

                        System.out.print("Do you want to add new item?(Yes=Y)");
                        char answer2 = scanner.next().charAt(0);
                        scanner.nextLine();

                        if (Character.toUpperCase(answer2) == 'Y') {
                            String Name, description;
                            double price = -1;
                            double discountrate = -1;

                            do {
                                System.out.print("Item's Name:");
                                Name = scanner.nextLine();

                                System.out.print("Description :");
                                description = scanner.nextLine();
                                System.out.print("Price:");
                                price = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Discount(%):");
                                discountrate = scanner.nextDouble();
                                scanner.nextLine();
                                if (!Classes.Validation.ValidateItem(Name, price, discountrate)) {
                                    System.out.println("Invalid input, please enter again.");
                                    System.out.println("\n");
                                }
                            } while (!Classes.Validation.ValidateItem(Name, price, discountrate));

                            if (Classes.Validation.ValidateItem(Name, price, discountrate)) {
                                if (!Classes.Validation.isDuplicateItem(Name, index, choice)) {
                                    MenuItem item = new MenuItem();
                                    item.setName(Name);
                                    item.setPrice(price);
                                    item.setDiscountRate(discountrate);
                                    item.setStatus("Available");
                                    item.setDescription(description);
                                    affiliateList.getEntry(index).getFood().add(item);
                                    File.storeList(affiliateList, AFFILIATEFILE);

                                    System.out.println("Your item has been added successful.");

                                    File.printMenuItem(index, choice);
                                } else {
                                    System.out.println("\nFailed to add, this item already exist.");
                                }

                            }
                        } else {
                            System.out.println("Thanks for using.");
                        }
                        break;
                    }
                    case 2: {

                        File.printMenuItem(index, choice);

                        System.out.print("Do you want to add new item?(Yes=Y)");
                        char answer2 = scanner.next().charAt(0);
                        scanner.nextLine();

                        if (Character.toUpperCase(answer2) == 'Y') {
                            String Name, description;
                            double price = -1;
                            double discountrate = -1;
                            do {
                                System.out.print("Item's Name:");
                                Name = scanner.nextLine();

                                System.out.print("Description :");
                                description = scanner.nextLine();
                                System.out.print("Price:");
                                price = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Discount(%):");
                                discountrate = scanner.nextDouble();
                                scanner.nextLine();
                                if (!Classes.Validation.ValidateItem(Name, price, discountrate)) {
                                    System.out.println("Invalid input, please enter again.");
                                    System.out.println("\n");
                                }
                            } while (!Classes.Validation.ValidateItem(Name, price, discountrate));
                            if (Classes.Validation.ValidateItem(Name, price, discountrate)) {
                                if (!Classes.Validation.isDuplicateItem(Name, index, choice)) {
                                    MenuItem item = new MenuItem();
                                    item.setName(Name);
                                    item.setPrice(price);
                                    item.setDiscountRate(discountrate);
                                    item.setStatus("Available");
                                    item.setDescription(description);
                                    affiliateList.getEntry(index).getBeverage().add(item);

                                    File.storeList(affiliateList, AFFILIATEFILE);

                                    System.out.println("Your item has been added successful.");

                                    File.printMenuItem(index, choice);
                                } else {
                                    System.out.println("\nFailed to add, this item already exist.");
                                }

                            }
                        } else {
                            System.out.println("Thanks for using.");
                        }

                        break;
                    }
                    default: {
                        System.out.println("Invalid Input.");
                        break;
                    }
                }
            }
            scanner.nextLine();
        } while (choice != 1 && choice != 2);
    }

    private static void updateItemDetails(String username) {
        ListInterface<Affiliate> affiliateList = File.retrieveList(AFFILIATEFILE);
        int index = File.getAffiliateIndex(username, AFFILIATEFILE);
        Scanner scanner = new Scanner(System.in);
        System.out.println(affiliateList.getEntry(index).getSortBy());
        int[] choice = new int[3];
        do {
            System.out.println("\nWhich operation you want to do :");
            System.out.println("1.Update item price");
            System.out.println("2.Update item description");
            System.out.println("3.Update item discount rate");
            System.out.println("4.Set the menu display order");
            System.out.print("Enter the number of your choice:");
            if (!scanner.hasNext("[1-4]{1}")) {
                System.out.println("\nPlease enter the number that within the range.");
            } else {
                choice[0] = scanner.nextInt();
            }
            scanner.nextLine();
        } while (choice[0] != 1 && choice[0] != 2 && choice[0] != 3 && choice[0] != 4);

        if (choice[0] == 4) {

            do {
                System.out.println("\nWhich type of order you want to display to customer:");
                System.out.println("1.Newest");
                System.out.println("2.Promotion");
                System.out.print("Enter your selection (by default is newest):");

                if (!scanner.hasNext("[1-2]{1}")) {
                    System.out.println("\nPlease enter the number that within the range.");
                } else {
                    choice[2] = scanner.nextInt();
                }
                scanner.nextLine();
            } while (choice[2] != 1 && choice[2] != 2);
            if (choice[2] > 0 && choice[2] < 3) {
                String sortby;
                if (choice[2] == 1) {
                    sortby = "Newest";
                } else {
                    sortby = "Promotion";
                }
                affiliateList.getEntry(index).setSortBy(sortby);
                File.storeList(affiliateList, AFFILIATEFILE);
                File.printMenuItem(index, 1);
                File.printMenuItem(index, 2);
                System.out.println("The order of menu has changed to order by " + sortby);
            }

        } else {
            do {
                System.out.println("\nWhich type of menu item you want to modify? :");
                System.out.println("1.Food");
                System.out.println("2.Beverage");
                System.out.print("Enter the number of your choice :");

                if (!scanner.hasNext("[1-2]{1}")) {
                    System.out.println("\nPlease enter the number that within the range.");
                } else {
                    choice[1] = scanner.nextInt();
                }
                scanner.nextLine();
            } while (choice[1] != 1 && choice[1] != 2);
            boolean foodEmpty = false;
            boolean beverageEmpty = false;
            if (affiliateList.getEntry(index).getFood().isEmpty()) {
                foodEmpty = true;
            }
            if (affiliateList.getEntry(index).getBeverage().isEmpty()) {
                beverageEmpty = true;
            }

            if (choice[0] == 1 && choice[1] == 1) {
                if (!foodEmpty) {
                    File.printMenuItem(index, choice[1]);

                    do {
                        System.out.print("Choose an item to update the price :");
                        if (!scanner.hasNext("[1-" + affiliateList.getEntry(index).getFood().getNumberOfEntries() + "]{1}")) {
                            System.out.println("please enter a valid input.");
                        } else {
                            choice[2] = scanner.nextInt();
                        }
                        scanner.nextLine();
                    } while (choice[2] < 1 || choice[2] > affiliateList.getEntry(index).getFood().getNumberOfEntries());
                    if (choice[2] > 0 && choice[2] <= affiliateList.getEntry(index).getFood().getNumberOfEntries()) {
                        double price = -1;
                        do {
                            System.out.print("New Price :");
                            try {
                                price = scanner.nextDouble();
                                scanner.nextLine();
                            } catch (NumberFormatException e) {
                                System.out.println("Price must be a number.");
                            }
                            if (price > -1) {
                                int datIndex = File.getDatMenuItemIndex(index, choice[1], choice[2]);
                                affiliateList.getEntry(index).getFood().getEntry(datIndex).setPrice(price);
                                File.storeList(affiliateList, AFFILIATEFILE);
                                File.printMenuItem(index, choice[1]);
                                System.out.println("\nThe price is updated.");
                            } else {
                                System.out.println("Price cannot be a negatif number.");
                            }
                        } while (price < 0);
                    }
                } else {
                    System.out.println("\nFood Menu is empty. Please add in some items first.");
                }

            } else if (choice[0] == 1 && choice[1] == 2) {
                if (!beverageEmpty) {
                    File.printMenuItem(index, choice[1]);
                    do {
                        System.out.print("Choose an item to update the price :");
                        if (!scanner.hasNext("[1-" + affiliateList.getEntry(index).getBeverage().getNumberOfEntries() + "]{1}")) {
                            System.out.println("please enter a valid input.");
                        } else {
                            choice[2] = scanner.nextInt();
                        }
                        scanner.nextLine();
                    } while (choice[2] < 1 || choice[2] > affiliateList.getEntry(index).getBeverage().getNumberOfEntries());
                    if (choice[2] > 0 && choice[2] <= affiliateList.getEntry(index).getBeverage().getNumberOfEntries()) {
                        double price = -1;
                        do {
                            System.out.print("New Price :");
                            try {
                                price = scanner.nextDouble();
                                scanner.nextLine();
                            } catch (NumberFormatException e) {
                                System.out.println("Price must be a number.");
                            }
                            if (price > -1) {
                                int datIndex = File.getDatMenuItemIndex(index, choice[1], choice[2]);
                                affiliateList.getEntry(index).getBeverage().getEntry(datIndex).setPrice(price);
                                File.storeList(affiliateList, AFFILIATEFILE);
                                File.printMenuItem(index, choice[1]);
                                System.out.println("\nThe price is updated.");
                            } else {
                                System.out.println("Price cannot be a negatif number.");
                            }
                        } while (price < 0);
                    }
                } else {
                    System.out.println("\nBeverage Menu is empty. Please add in some items first.");
                }

            } else if (choice[0] == 2 && choice[1] == 1) {
                if (!foodEmpty) {
                    File.printMenuItem(index, choice[1]);
                    do {
                        System.out.print("Choose an item to update the description :");
                        if (!scanner.hasNext("[1-" + affiliateList.getEntry(index).getFood().getNumberOfEntries() + "]{1}")) {
                            System.out.println("please enter a valid input.");
                        } else {
                            choice[2] = scanner.nextInt();
                        }
                        scanner.nextLine();
                    } while (choice[2] < 1 || choice[2] > affiliateList.getEntry(index).getFood().getNumberOfEntries());
                    if (choice[2] > 0 && choice[2] <= affiliateList.getEntry(index).getFood().getNumberOfEntries()) {
                        String description;
                        System.out.print("New Description :");
                        description = scanner.nextLine();
                        int datIndex = File.getDatMenuItemIndex(index, choice[1], choice[2]);
                        affiliateList.getEntry(index).getFood().getEntry(datIndex).setDescription(description);
                        File.storeList(affiliateList, AFFILIATEFILE);
                        File.printMenuItem(index, choice[1]);
                        System.out.println("\nThe description is updated.");
                    }
                } else {
                    System.out.println("\nFood Menu is empty. Please add in some items first.");
                }

            } else if (choice[0] == 2 && choice[1] == 2) {
                if (!beverageEmpty) {
                    File.printMenuItem(index, choice[1]);
                    do {
                        System.out.print("Choose an item to update the description :");
                        if (!scanner.hasNext("[1-" + affiliateList.getEntry(index).getBeverage().getNumberOfEntries() + "]{1}")) {
                            System.out.println("please enter a valid input.");
                        } else {
                            choice[2] = scanner.nextInt();
                        }
                        scanner.nextLine();
                    } while (choice[2] < 1 || choice[2] > affiliateList.getEntry(index).getBeverage().getNumberOfEntries());
                    if (choice[2] > 0 && choice[2] <= affiliateList.getEntry(index).getBeverage().getNumberOfEntries()) {
                        String description;
                        System.out.print("New Description :");
                        description = scanner.nextLine();
                        int datIndex = File.getDatMenuItemIndex(index, choice[1], choice[2]);
                        affiliateList.getEntry(index).getBeverage().getEntry(datIndex).setDescription(description);
                        File.storeList(affiliateList, AFFILIATEFILE);
                        File.printMenuItem(index, choice[1]);
                        System.out.println("\nThe description is updated.");
                    }
                } else {
                    System.out.println("\nBeverage Menu is empty. Please add in some items first.");
                }

            } else if (choice[0] == 3 && choice[1] == 1) {
                if (!foodEmpty) {
                    File.printMenuItem(index, choice[1]);
                    do {
                        System.out.print("Choose an item to update the discount rate :");
                        if (!scanner.hasNext("[1-" + affiliateList.getEntry(index).getFood().getNumberOfEntries() + "]{1}")) {
                            System.out.println("please enter a valid input.");
                        } else {
                            choice[2] = scanner.nextInt();
                        }
                        scanner.nextLine();
                    } while (choice[2] < 1 || choice[2] > affiliateList.getEntry(index).getFood().getNumberOfEntries());
                    if (choice[2] > 0 && choice[2] <= affiliateList.getEntry(index).getFood().getNumberOfEntries()) {
                        double discount = -1;
                        do {
                            System.out.print("New discount rate :");
                            try {
                                discount = scanner.nextDouble();
                                scanner.nextLine();
                            } catch (NumberFormatException e) {
                                System.out.println("Discount rate must be a number.");
                            }
                            if (discount >= 0.0 && discount <= 100) {
                                int datIndex = File.getDatMenuItemIndex(index, choice[1], choice[2]);
                                affiliateList.getEntry(index).getFood().getEntry(datIndex).setDiscountRate(discount);
                                File.storeList(affiliateList, AFFILIATEFILE);
                                File.printMenuItem(index, choice[1]);
                                System.out.println("\nThe discount rate is updated.");
                            } else {
                                System.out.println("Discount rate must between 0 and 100.");
                            }
                        } while (discount < 0.0 || discount > 100);
                    }
                } else {
                    System.out.println("\nFood Menu is empty. Please add in some items first.");
                }
            } else if (choice[0] == 3 && choice[1] == 2) {
                if (!beverageEmpty) {
                    File.printMenuItem(index, choice[1]);
                    do {
                        System.out.print("Choose an item to update the discount rate :");
                        if (!scanner.hasNext("[1-" + affiliateList.getEntry(index).getBeverage().getNumberOfEntries() + "]{1}")) {
                            System.out.println("please enter a valid input.");
                        } else {
                            choice[2] = scanner.nextInt();
                        }
                        scanner.nextLine();
                    } while (choice[2] < 1 || choice[2] > affiliateList.getEntry(index).getBeverage().getNumberOfEntries());
                    if (choice[2] > 0 && choice[2] <= affiliateList.getEntry(index).getBeverage().getNumberOfEntries()) {
                        double discount = -1;
                        do {
                            System.out.print("New discount rate :");
                            try {
                                discount = scanner.nextDouble();
                                scanner.nextLine();
                            } catch (NumberFormatException e) {
                                System.out.println("Discount rate must be a number.");
                            }
                            if (discount >= 0.0 && discount <= 100) {
                                int datIndex = File.getDatMenuItemIndex(index, choice[1], choice[2]);
                                affiliateList.getEntry(index).getBeverage().getEntry(datIndex).setDiscountRate(discount);
                                File.storeList(affiliateList, AFFILIATEFILE);
                                File.printMenuItem(index, choice[1]);
                                System.out.println("\nThe discount rate is updated.");
                            } else {
                                System.out.println("Discount rate must between 0 and 100.");
                            }
                        } while (discount < 0.0 || discount > 100);
                    }
                } else {
                    System.out.println("\nBeverage Menu is empty. Please add in some items first.");
                }
            }
        }
    }

    private static void updateItemStatus(String username) {
        Scanner scanner = new Scanner(System.in);
        String up = "Available";
        String down = "Unavailable";
        int index = File.getAffiliateIndex(username, AFFILIATEFILE);
        ListInterface<Affiliate> affiliateList = File.retrieveList(AFFILIATEFILE);
        int choice = -1;
        do {
            System.out.println("Which type of menu item you want to change status? :");
            System.out.println("1.Food");
            System.out.println("2.Beverage");
            System.out.print("Enter the number of your choice :");
            if (!scanner.hasNext("[1-2]{1}")) {
                System.out.println("Invalid Input.");
            } else {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        int choice2 = -1;
                        File.printMenuItem(index, choice);
                        if (affiliateList.getEntry(index).getFood().isEmpty() == false) {
                            do {
                                System.out.print("Enter the index of item that you want to change status:");
                                if (!scanner.hasNext("[1-" + affiliateList.getEntry(index).getFood().getNumberOfEntries() + "]{1}")) {
                                    System.out.println("Invalid Input! Please enter a valid input.");
                                } else {
                                    choice2 = scanner.nextInt();
                                }
                                if (choice2 > 0 && choice2 <= affiliateList.getEntry(index).getFood().getNumberOfEntries()) {
                                    int datIndex = File.getDatMenuItemIndex(index, choice, choice2);
                                    if (affiliateList.getEntry(index).getFood().getEntry(datIndex).getStatus().equalsIgnoreCase(up)) {
                                        affiliateList.getEntry(index).getFood().getEntry(datIndex).setStatus(down);
                                    } else {
                                        affiliateList.getEntry(index).getFood().getEntry(datIndex).setStatus(up);
                                    }
                                }
                                scanner.nextLine();
                            } while (choice2 < 1 || choice2 > affiliateList.getEntry(index).getFood().getNumberOfEntries());
                            File.storeList(affiliateList, AFFILIATEFILE);
                            File.printMenuItem(index, choice);
                            System.out.println("\nStatus of the particular item has been changed.");
                        } else {
                            System.out.println("\nPlease add in some items.");
                        }

                        break;
                    }
                    case 2: {
                        int choice2 = -1;
                        File.printMenuItem(index, choice);
                        if (affiliateList.getEntry(index).getBeverage().isEmpty() == false) {
                            do {
                                System.out.print("Enter the index of item that you want to change status:");
                                if (!scanner.hasNext("[1-" + affiliateList.getEntry(index).getBeverage().getNumberOfEntries() + "]{1}")) {
                                    System.out.println("Invalid Input! Please enter a valid input.");
                                } else {
                                    choice2 = scanner.nextInt();
                                }

                                if (choice2 > 0 && choice2 <= affiliateList.getEntry(index).getBeverage().getNumberOfEntries()) {
                                    int datIndex = File.getDatMenuItemIndex(index, choice, choice2);
                                    if (affiliateList.getEntry(index).getBeverage().getEntry(datIndex).getStatus().equalsIgnoreCase(up)) {
                                        affiliateList.getEntry(index).getBeverage().getEntry(datIndex).setStatus(down);
                                    } else {
                                        affiliateList.getEntry(index).getBeverage().getEntry(datIndex).setStatus(up);
                                    }

                                }
                                scanner.nextLine();
                            } while (choice2 < 1 || choice2 > affiliateList.getEntry(index).getBeverage().getNumberOfEntries());
                            File.storeList(affiliateList, AFFILIATEFILE);
                            File.printMenuItem(index, choice);
                            System.out.println("\nStatus of the particular item has been changed.");
                            break;
                        } else {
                            System.out.println("\nPlease add in some items.");
                        }
                    }
                    default: {
                        break;
                    }
                }
            }
            scanner.nextLine();
        } while (choice != 1 && choice != 2);

    }

    private static void removeItems(String username) {
        ListInterface<Affiliate> affiliateList = File.retrieveList(AFFILIATEFILE);
        int index = File.getAffiliateIndex(username, AFFILIATEFILE);
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("Which type of menu item you want to delete? :");
            System.out.println("1.Food");
            System.out.println("2.Beverage");
            System.out.print("Enter the number of your choice :");
            if (!scanner.hasNext("[1-2]{1}")) {
                System.out.println("Invalid Input.");
            } else {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        int choice2 = -1;
                        boolean deleted = false;
                        File.printMenuItem(index, choice);
                        if (affiliateList.getEntry(index).getFood().isEmpty() == false) {
                            do {
                                System.out.print("Enter the index of item that you want to delete :");
                                if (!scanner.hasNext("[1-" + affiliateList.getEntry(index).getFood().getNumberOfEntries() + "]{1}")) {
                                    System.out.println("Invalid Input! Please enter a valid input.");
                                } else {
                                    choice2 = scanner.nextInt();
                                }
                                if (choice2 <= affiliateList.getEntry(index).getFood().getNumberOfEntries() && choice2 > 0) {

                                    deleted = true;

                                }
                                scanner.nextLine();
                            } while (choice2 > affiliateList.getEntry(index).getFood().getNumberOfEntries() || choice2 < 1);

                            if (deleted) {
                                int datIndex = File.getDatMenuItemIndex(index, choice, choice2);
                                affiliateList.getEntry(index).getFood().remove(datIndex);
                                File.storeList(affiliateList, AFFILIATEFILE);
                                File.printMenuItem(index, choice);
                                System.out.println("\nThe particular item has been deleted.");

                            }
                        } else {
                            System.out.println("\nPlease add in some items.");
                        }
                        break;
                    }
                    case 2: {
                        int choice2 = -1;
                        boolean deleted = false;
                        File.printMenuItem(index, choice);
                        if (affiliateList.getEntry(index).getBeverage().isEmpty() == false) {
                            do {
                                System.out.print("Enter the index of item that you want to delete :");
                                if (!scanner.hasNext("[1-" + affiliateList.getEntry(index).getBeverage().getNumberOfEntries() + "]{1}")) {
                                    System.out.println("Invalid Input! Please enter a valid input.");
                                } else {
                                    choice2 = scanner.nextInt();
                                }
                                if (choice2 <= affiliateList.getEntry(index).getBeverage().getNumberOfEntries() && choice2 > 0) {

                                    deleted = true;

                                }
                                scanner.nextLine();
                            } while (affiliateList.getEntry(index).getBeverage().getNumberOfEntries() < choice2 || choice2 < 1);

                            if (deleted) {
                                int datIndex = File.getDatMenuItemIndex(index, choice, choice2);
                                affiliateList.getEntry(index).getBeverage().remove(datIndex);
                                File.storeList(affiliateList, AFFILIATEFILE);
                                File.printMenuItem(index, choice);
                                System.out.println("\nThe particular item has been deleted.");
                            }
                        } else {
                            System.out.println("\nPlease add in some items.");
                        }
                        break;
                    }
                    default: {

                        break;
                    }
                }
            }
            scanner.nextLine();

        } while (choice != 1 && choice != 2);
    }

    private static void clockIn(String username) {
        ListInterface<DeliveryMan> deliveryManList = File.retrieveList(DELIVERYMANFILE);
        LinearDoublyListInterface<Clocking> clockingList = File.retrieveFromList(CLOCKINGFILE);
        GregorianCalendar currentDate = new GregorianCalendar();
        Scanner scanner = new Scanner(System.in);
        String checkUsername;
        Clocking clocking = new Clocking();
        boolean isClockIn = false;

        System.out.println("\nClock In");
        System.out.println("=====");

        for (int i = 1; i <= deliveryManList.getNumberOfEntries(); i++) {
            checkUsername = deliveryManList.getEntry(i).getUsername();

            if (checkUsername.equalsIgnoreCase(username)) {
                System.out.print("Are you want to clock in? [y/n]  ");
                String selection = scanner.next();

                if (selection.matches("y")) {
                    GregorianCalendar clockInDate = null;

                    for (int j = 1; j <= clockingList.getNumberOfEntries(); j++) {
                        if (clockingList.getEntry(j).getDeliveryMan().getUsername().equalsIgnoreCase(username)) {
                            clockInDate = clockingList.getEntry(j).getClockInTime();

                            if (clockInDate == null) {
                                isClockIn = false;
                            } else if (clockInDate.get(Calendar.DAY_OF_MONTH) == currentDate.get(Calendar.DAY_OF_MONTH)
                                    && clockInDate.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)
                                    && clockInDate.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR)) {
                                isClockIn = true;
                            }
                        }
                    }
                    if (isClockIn == true) {
                        System.out.println("You are already clock in at " + Clocking.printDate(clockInDate) + " " + Clocking.printTime(clockInDate));
                    } else {
                        System.out.println("Clock In successfully!!");
                        System.out.println("Your Clock In Time for " + Clocking.printDate(currentDate) + " is " + Clocking.printTime(currentDate));
                        deliveryManList.getEntry(i).setWorkingStatus("Available");
                        File.storeList(deliveryManList, DELIVERYMANFILE);
                        clocking = new Clocking(deliveryManList.getEntry(i), currentDate);
                        clockingList.add(clocking);
                        File.storeToList(clockingList, CLOCKINGFILE);
                    }
                } else if (selection.matches("n")) {
                    System.out.println("Clock In has been cancelled");
                }
            }
        }
    }

    private static void clockOut(String username) {
        ListInterface<DeliveryMan> deliveryManList = File.retrieveList(DELIVERYMANFILE);
        LinearDoublyListInterface<Clocking> clockingList = File.retrieveFromList(CLOCKINGFILE);
        GregorianCalendar currentDate = new GregorianCalendar();
        Scanner scanner = new Scanner(System.in);
        Clocking clocking = new Clocking();
        String checkUsername;

        System.out.println("\nClock Out");
        System.out.println("======");

        for (int i = 1; i <= deliveryManList.getNumberOfEntries(); i++) {
            checkUsername = deliveryManList.getEntry(i).getUsername();

            if (checkUsername.equalsIgnoreCase(username)) {
                System.out.print("Are you want to clock out? [y/n]  ");
                String selection = scanner.next();

                if (selection.matches("y")) {
                    boolean isClockIn = false;
                    GregorianCalendar clockInDate = null;

                    for (int j = 1; j <= clockingList.getNumberOfEntries(); j++) {
                        if (clockingList.getEntry(j).getDeliveryMan().getUsername().equalsIgnoreCase(username)) {
                            clockInDate = clockingList.getEntry(j).getClockInTime();
                            if (clockInDate == null) {
                                isClockIn = false;
                            } else if (clockInDate.get(Calendar.DAY_OF_MONTH) == currentDate.get(Calendar.DAY_OF_MONTH)
                                    && clockInDate.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)
                                    && clockInDate.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR)) {
                                isClockIn = true;
                            }
                        }
                    }
                    if (isClockIn == false) {
                        System.out.println("You are haven't clock in!!");
                        System.out.println("You will be returned back to operation list in 2 seconds...");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        System.out.println("Clock Out successfully!!");
                        System.out.println("Your Clock Out Time for " + Clocking.printDate(currentDate) + " is " + Clocking.printTime(currentDate));
                        System.out.println("Total working hour(s) for today is " + clocking.calWorkingHours());
                        deliveryManList.getEntry(i).setWorkingStatus("Offline");
                        File.storeList(deliveryManList, DELIVERYMANFILE);
                        clocking = new Clocking(deliveryManList.getEntry(i), clocking.getClockInTime(), currentDate);
                        clockingList.add(clocking);
                        File.storeToList(clockingList, CLOCKINGFILE);
                    }
                } else if (selection.matches("n")) {
                    System.out.println("Clock Out has been cancelled!");

                }
            }
        }
    }

    private static void retrieveCustomerDetails() {
        String phone, findPhoneNo, name = "", address = "", state = "", city = "";
        int postcode = 0;
        char gender = 0;
        boolean exist = false;

        ListInterface<Customer> customer = File.retrieveList(CUSTOMERFILE);

        do {
            Scanner phoneNo = new Scanner(System.in);
            System.out.print("Please enter customer phone no.(01x-xxxxxxxx):");
            phone = phoneNo.next();

            if (Validation.ValidateContactNumber(phone) == true) {
                for (int i = 1; i <= customer.getNumberOfEntries(); i++) {
                    findPhoneNo = customer.getEntry(i).getContactNo();

                    if (findPhoneNo.equals(phone)) {
                        exist = true;
                        name = customer.getEntry(i).getName();
                        address = customer.getEntry(i).getAddress().getAddress();
                        state = customer.getEntry(i).getAddress().getState();
                        city = customer.getEntry(i).getAddress().getCity();
                        postcode = customer.getEntry(i).getAddress().getPostcode();
                        gender = customer.getEntry(i).getGender();
                        break;
                    }
                }
                break;
            } else {
                System.out.println("This phone number is not valid. Please re-enter.");
            }
        } while (Validation.ValidateContactNumber(phone) == false);

        if (exist == true) {
            System.out.println("\nCustomer details");
            System.out.println("================");
            System.out.println("Customer name: " + name);
            System.out.println("Gender: " + gender);
            System.out.println("Contact No.:" + phone);
            System.out.println("Delivery address: " + address + ", " + postcode + " " + city + ", " + state);
        } else {
            System.out.println("Sorry,no such customer in the record. Thank you");
        }
    }

    private static void updateWorkingStatus(String username) {
        LinearDoublyListInterface<Clocking> clockingList = File.retrieveFromList(CLOCKINGFILE);
        ListInterface<DeliveryMan> deliveryManList = File.retrieveList(DELIVERYMANFILE);
        GregorianCalendar currentDate = new GregorianCalendar();
        GregorianCalendar clockInDate = null;
        String strDm;
        Scanner scanner = new Scanner(System.in);
        if (!deliveryManList.isEmpty()) {
            String checkUsername;

            for (int i = 1; i <= deliveryManList.getNumberOfEntries(); i++) {
                checkUsername = deliveryManList.getEntry(i).getUsername();

                if (checkUsername.matches(username)) {
                    boolean isClockIn = false;

                    for (int j = 1; j <= clockingList.getNumberOfEntries(); j++) {

                        if (clockingList.getEntry(j).getDeliveryMan().getUsername().equalsIgnoreCase(username)) {
                            clockInDate = clockingList.getEntry(j).getClockInTime();

                            if (clockingList.getEntry(j).getClockInTime() == null) {
                                isClockIn = false;
                            } else if (clockInDate.get(Calendar.DAY_OF_MONTH) == currentDate.get(Calendar.DAY_OF_MONTH)
                                    && clockInDate.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)
                                    && clockInDate.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR)) {
                                isClockIn = true;
                            }
                        }
                    }
                    if (isClockIn == true) {
                        System.out.println("Update Delivery Man Working Status");
                        System.out.println("=======================");
                        strDm = "Name: " + deliveryManList.getEntry(i).getName() + "\n" + "Contact No: " + deliveryManList.getEntry(i).getContactNo()
                                + "\n" + "Working Status: " + deliveryManList.getEntry(i).getWorkingStatus();
                        System.out.println(strDm);
                        System.out.println("=======================");
                        System.out.println("1. Available");
                        System.out.println("2. Break");
                        System.out.print("Enter selection (-1 to exit): ");

                        try {
                            int selection = scanner.nextInt();
                            scanner.nextLine();
                            if ((selection < 1 || selection > 2) && selection != -1) {
                                System.out.println("\nInvalid Option!!! Please choose an option from the list~");
                            } else if (selection == 1) {
                                if (deliveryManList.getEntry(i).getWorkingStatus().matches("Available")) {
                                    System.out.println("You already in this status.");
                                } else {
                                    deliveryManList.getEntry(i).setWorkingStatus("Available");
                                    File.storeList(deliveryManList, "deliveryMan.dat");
                                    System.out.println("Working status has been updated to Available");
                                }
                            } else if (selection == 2) {
                                if (deliveryManList.getEntry(i).getWorkingStatus().matches("Break")) {
                                    System.out.println("You already in this status.");
                                } else {
                                    deliveryManList.getEntry(i).setWorkingStatus("Break");
                                    File.storeList(deliveryManList, "deliveryMan.dat");
                                    System.out.println("Working status has been updated to Break");
                                }
                            } else if (selection == -1) {
                                System.exit(0);
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid Option!!! Please enter numeric value only~");
                            scanner.nextLine();

                        }
                    } else {
                        System.out.println("You are haven't clock in");
                        System.out.println("You will be returned back to operation list in 2 seconds...");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }

                }

            }
        }
    }

    private static void retrievePendingDelivery() {
        Scanner scanner = new Scanner(System.in);
        QueueInterface<Order> orderQueue = File.retrieveQueue(PENDINGDELIVERYFILE);
        ListInterface<DeliveryMan> deliveryManList = File.retrieveList(DELIVERYMANFILE);
        ListInterface<Delivery> deliveryList = File.retrieveList(DELIVERYFILE);
        System.out.println("RETRIEVE PENDING DELIVERY");
        System.out.println("=========================");
        System.out.print("Retrieve next pending delivery? (Y=Yes): ");
        char getNext = scanner.next().charAt(0);
        while (Character.toUpperCase(getNext) == 'Y') {
            if (!orderQueue.isEmpty()) {
                Order order = orderQueue.dequeue();
                System.out.println("ORDER DETAILS");
                System.out.println("=============");
                System.out.println("Order No            : " + order.getOrderNo());
                System.out.println("Customer Name       : " + order.getCustomer().getName());
                System.out.println("Customer Contact No.: " + order.getCustomer().getContactNo());
                System.out.println("Affiliate Name      : " + order.getAffiliate().getRestaurantName());
                System.out.println("Order Date          : " + order.printOrderDate());
                System.out.println("Order Time          : " + order.printOrderTime());
                System.out.println("Order Status        : " + order.getStatus());
                System.out.println("-----------------------------------------------------");
                System.out.println("Order has been assigned to");
                //Assign Delivery Man
                Delivery delivery = new Delivery();
                int entry = 0;
                boolean isFound = false;
                for (int i = 1; i <= deliveryManList.getNumberOfEntries(); i++) {
                    if (deliveryManList.getEntry(i).getWorkingStatus().equals("Available")) {
                        entry = i;
                        isFound = true;
                    }
                }
                if (isFound == true) {
                    //store in deliveryman
                    deliveryManList.getEntry(entry).setWorkingStatus("Delivery");
                    File.storeList(deliveryManList, DELIVERYMANFILE);

                    //store in delivery
                    delivery.setDeliveryMan(deliveryManList.getEntry(entry));
                    File.storeList(deliveryList, DELIVERYFILE);

                    System.out.println("Delivery Man : " + deliveryManList.getEntry(entry).getName());
                    File.storeQueue(orderQueue, PENDINGDELIVERYFILE);

                } else if (isFound == false) {
                    System.out.println("Sorry, there are no available delivery man");
//                    File.storeQueue(orderQueue, PENDINGDELIVERYFILE);
                    System.exit(0);
                }
                System.out.println("---------------------------------------------------------------------");
                System.out.print("Retrieve next pending delivery? (Y=Yes): ");
                getNext = scanner.next().charAt(0);
            } else {
                System.out.println("Well done!! All pending deliveries have been assigned.");
                break;
            }
        }
        System.out.println("You will be returned back to operation list in 3 seconds...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private static void retrieveScheduledOrders() {

    }

    private static void addNewDeliveryMan() {
        Scanner scanner = new Scanner(System.in);
        ListInterface<DeliveryMan> deliveryManList = File.retrieveList(DELIVERYMANFILE);
        DeliveryMan.setNextID(1000 + deliveryManList.getNumberOfEntries());
        char addOther;
        do {
            System.out.println("Add New Delivery Man");
            System.out.println("====================");
            System.out.println("Please enter following details:");
            System.out.print("                 Username : ");
            String username = scanner.nextLine();
            while (Validation.CheckDuplicateUsername(username, deliveryManList)) {
                System.out.println("Sorry, this username already exist.");
                System.out.println("Please try other username.");
                System.out.print("                 Username : ");
                username = scanner.nextLine();
            }
            System.out.print("                 Password : ");
            String password = scanner.nextLine();
            System.out.print("                     Name : ");
            String name = scanner.nextLine();
            System.out.print("             Gender (M/F) : ");
            while (!scanner.hasNext("[mMfF]{1}")) {
                System.out.println("Please enter character [M/F] only");
                System.out.print("             Gender (M/F) : ");
                scanner.next();
            }
            char gender = scanner.next().charAt(0);
            System.out.print("Contact No.(01#-########) : ");
            while (!scanner.hasNext("01[0-9]{1}-[0-9]{7,8}")) {
                System.out.println("Please enter a valid contact number.");
                System.out.print("Contact No.(01#-########) : ");
                scanner.next();
            }
            String contactNo = scanner.next();
            scanner.nextLine();
            System.out.print("     NRIC(######-##-####) : ");
            while (!scanner.hasNext("[0-9]{6}-[0-9]{2}-[0-9]{4}")) {
                System.out.println("Please enter a valid NRIC.");
                System.out.print("     NRIC(######-##-####) : ");
                scanner.next();
            }
            String NRIC = scanner.next();
            scanner.nextLine();
            System.out.print("            Email Address : ");
            while (!scanner.hasNext("([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})")) {
                System.out.println("Please enter a valid email address.");
                System.out.print("            Email Address : ");
                scanner.next();
            }
            String email = scanner.next();
            scanner.nextLine();
            System.out.print("                  Address : ");
            String address = scanner.nextLine();
            System.out.print("                    State : ");
            String state = scanner.nextLine();
            System.out.print("                     City : ");
            String city = scanner.nextLine();
            System.out.print("        Postcode(5-digit) : ");
            while (!scanner.hasNext("[0-9]{5}")) {
                System.out.println("Please enter 5-digit postcode.");
                System.out.print("        Postcode(5-digit) : ");
                scanner.next();
            }
            int postcode = scanner.nextInt();
            scanner.nextLine();
            System.out.print("         Basic Salary(RM) : ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Please enter numeric value.");
                System.out.print("         Basic Salary(RM) : ");
                scanner.next();
            }
            double basicSalary = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Confirm to add a new delivery man? (Y=Yes): ");
            char confirmation = scanner.next().charAt(0);
            scanner.nextLine();
            if (Character.toUpperCase(confirmation) == 'Y') {
                Address fullAddress = new Address(address, state, city, postcode);
                DeliveryMan newDeliveryMan = new DeliveryMan(NRIC, email, basicSalary, fullAddress, username, password, name, Character.toUpperCase(gender), contactNo);
                deliveryManList.add(newDeliveryMan);
                File.storeList(deliveryManList, DELIVERYMANFILE);
                System.out.println("Added Successfully!!!");
            } else {
                System.out.println("Operation Cancelled!!!");
            }
            System.out.print("Do you want to add another delivery man? (Y=Yes): ");
            addOther = scanner.next().charAt(0);
            scanner.nextLine();
        } while (Character.toUpperCase(addOther) == 'Y');
        System.out.println("You will be returned back to operation list in 3 seconds...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private static void updateDeliveryManContactDetails() {
        Scanner scanner = new Scanner(System.in);
        ListInterface<DeliveryMan> deliveryManList = File.retrieveList(DELIVERYMANFILE);
        DeliveryMan.setNextID(1000 + deliveryManList.getNumberOfEntries());
        int count = deliveryManList.getNumberOfEntries();
        int selection[] = new int[2];
        boolean loop[] = new boolean[3];
        do {
            loop[0] = false;
            System.out.println("Update Delivery Man Contact Details");
            System.out.println("===================================");
            System.out.println(String.format("%-3s %-4s %-10s %-20s %-6s %-12s %-14s %-20s %-12s %-80s %-10s %-14s", "NO.", "ID", "USERNAME", "NAME", "GENDER", "CONTACT_NO", "NRIC", "EMAIL", "BASIC_SALARY", "ADDRESS", "STATUS", "WORKING_STATUS"));
            for (int i = 1; i <= deliveryManList.getNumberOfEntries(); i++) {
                System.out.printf("%-3s %s\n", i + ".", deliveryManList.getEntry(i));
            }
            if (count != 0) {
                System.out.print("Please select a delivery man you want to update (0 to cancel): ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter numeric value only.");
                    scanner.nextLine();
                    loop[0] = true;
                } else {
                    selection[0] = scanner.nextInt();
                    scanner.nextLine();
                    if (selection[0] >= 0 && selection[0] <= count) {
                        if (selection[0] != 0) {
                            do {
                                loop[1] = false;
                                System.out.println("Delivery Man Contact Details");
                                System.out.println("============================");
                                System.out.println("1. Contact Number");
                                System.out.println("2. Address");
                                System.out.println("0. Reselect Delivery Man");
                                System.out.print("Please select a contact detail you want to update: ");
                                if (!scanner.hasNext("[012]{1}")) {
                                    System.out.println("Please select option [0-2] only.");
                                    scanner.nextLine();
                                    loop[1] = true;
                                } else {
                                    selection[1] = scanner.nextInt();
                                    scanner.nextLine();
                                    if (selection[1] == 1) {//Update Contact Number
                                        do {
                                            loop[2] = false;
                                            String oldContactNo = deliveryManList.getEntry(selection[0]).getContactNo();
                                            System.out.println("Update Contact Number");
                                            System.out.println("=====================");
                                            System.out.println("Old Contact No. : " + oldContactNo);
                                            System.out.println("---------------------");
                                            System.out.print("New Contact No.(01#-########): ");
                                            String newContactNo = scanner.nextLine();
                                            if (Validation.ValidateContactNumber(newContactNo)) {
                                                deliveryManList.getEntry(selection[0]).setContactNo(newContactNo);
                                                File.storeList(deliveryManList, DELIVERYMANFILE);
                                                System.out.println("Updated Successfully!!!");
                                                System.out.print("Do you want to update other details? (Y=Yes): ");
                                                char updateOtherDetails = scanner.next().charAt(0);
                                                scanner.nextLine();
                                                if (Character.toUpperCase(updateOtherDetails) == 'Y') {
                                                    loop[1] = true;
                                                }
                                            } else {
                                                System.out.println("Please enter a valid contact number.");
                                                loop[2] = true;
                                            }
                                        } while (loop[2] == true);

                                    } else if (selection[1] == 2) {//Update Address
                                        do {
                                            loop[2] = false;
                                            Address oldFullAddress = deliveryManList.getEntry(selection[0]).getAddress();
                                            String oldAddress = oldFullAddress.getAddress();
                                            String oldState = oldFullAddress.getState();
                                            String oldCity = oldFullAddress.getCity();
                                            int oldPostcode = oldFullAddress.getPostcode();
                                            System.out.println("Update Address");
                                            System.out.println("=====================");
                                            System.out.println("Old Address : " + oldAddress);
                                            System.out.println("Old State   : " + oldState);
                                            System.out.println("Old City    : " + oldCity);
                                            System.out.println("old Postcode: " + oldPostcode);
                                            System.out.println("---------------------");
                                            System.out.print("New Address : ");
                                            String newAddress = scanner.nextLine();
                                            System.out.print("New State   : ");
                                            String newState = scanner.nextLine();
                                            System.out.print("New City    : ");
                                            String newCity = scanner.nextLine();
                                            System.out.print("New Postcode: ");
                                            while (!scanner.hasNext("[0-9]{5}")) {
                                                System.out.println("Please enter 5-digit postcode.");
                                                System.out.print("New Postcode: ");
                                                scanner.next();
                                            }
                                            int newPostcode = scanner.nextInt();
                                            scanner.nextLine();
                                            Address newFullAddress = new Address(newAddress, newState, newCity, newPostcode);
                                            deliveryManList.getEntry(selection[0]).setAddress(newFullAddress);
                                            File.storeList(deliveryManList, DELIVERYMANFILE);
                                            System.out.println("Updated Successfully!!!");
                                            System.out.print("Do you want to update other details? (Y=Yes): ");
                                            char updateOtherDetails = scanner.next().charAt(0);
                                            scanner.nextLine();
                                            if (Character.toUpperCase(updateOtherDetails) == 'Y') {
                                                loop[1] = true;
                                            }

                                        } while (loop[2] == true);
                                    } else {//Reselect Delivery Man
                                        loop[0] = true;
                                    }
                                }
                            } while (loop[1] == true);

                        }
                    } else {
                        System.out.println("Please select option [0-" + count + "] only.");
                        loop[0] = true;
                    }
                }
            } else {
                System.out.println("No delivery man found in database.");
            }
        } while (loop[0] == true);
        System.out.println("You will be returned back to operation list in 3 seconds...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private static void updateDeliveryManStatus() {
        Scanner scanner = new Scanner(System.in);
        ListInterface<DeliveryMan> deliveryManList = File.retrieveList(DELIVERYMANFILE);
        DeliveryMan.setNextID(1000 + deliveryManList.getNumberOfEntries());
        int count = deliveryManList.getNumberOfEntries();
        int selection[] = new int[2];
        boolean loop[] = new boolean[2];
        do {
            loop[0] = false;
            System.out.println("Update Delivery Man Status");
            System.out.println("===================================");
            System.out.println(String.format("%-3s %-4s %-10s %-20s %-6s %-12s %-14s %-20s %-12s %-80s %-10s %-14s", "NO.", "ID", "USERNAME", "NAME", "GENDER", "CONTACT_NO", "NRIC", "EMAIL", "BASIC_SALARY", "ADDRESS", "STATUS", "WORKING_STATUS"));
            for (int i = 1; i <= deliveryManList.getNumberOfEntries(); i++) {
                System.out.printf("%-3s %s\n", i + ".", deliveryManList.getEntry(i));
            }
            if (count != 0) {
                System.out.print("Please select a delivery man you want to update (0 to cancel): ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter numeric value only.");
                    scanner.nextLine();
                    loop[0] = true;
                } else {
                    selection[0] = scanner.nextInt();
                    scanner.nextLine();
                    if (selection[0] >= 0 && selection[0] <= count) {
                        if (selection[0] != 0) {//Not select cancel
                            do {
                                loop[1] = false;
                                String name = deliveryManList.getEntry(selection[0]).getName();
                                String NRIC = deliveryManList.getEntry(selection[0]).getNRIC();
                                String oldStatus = deliveryManList.getEntry(selection[0]).getStatus();
                                System.out.println("Delivery Man Status");
                                System.out.println("===========================");
                                System.out.println("Name      : " + name);
                                System.out.println("NRIC      : " + NRIC);
                                System.out.println("Old Status: " + oldStatus);
                                System.out.println("---------------------------");
                                System.out.println("New Status List: ");
                                System.out.println("1. Active");
                                System.out.println("2. Resigned");
                                System.out.println("3. Forced Resigned");
                                System.out.println("4. Retired");
                                System.out.println("5. Other Status");
                                System.out.println("0. Reselect Delivery Man");
                                System.out.print("Selection: ");
                                if (!scanner.hasNext("[012345]{1}")) {
                                    System.out.println("Please select option [0-5] only.");
                                    scanner.nextLine();
                                    loop[1] = true;
                                } else {
                                    selection[1] = scanner.nextInt();
                                    scanner.nextLine();
                                    if (selection[1] != 0) {
                                        String newStatus = "";
                                        switch (selection[1]) {
                                            case 1://Active
                                                newStatus = "Active";
                                                break;
                                            case 2://Resigned
                                                newStatus = "Resigned";
                                                break;
                                            case 3://Force Resigned
                                                newStatus = "Forced Resigned";
                                                break;
                                            case 4://Retired
                                                newStatus = "Retired";
                                                break;
                                            case 5://Other Status
                                                System.out.print("Please specify new status: ");
                                                newStatus = scanner.nextLine();
                                                break;
                                        }
                                        deliveryManList.getEntry(selection[0]).setStatus(newStatus);
                                        File.storeList(deliveryManList, DELIVERYMANFILE);
                                        System.out.println("Status Updated to '" + newStatus + "' Successfully!!!");
                                        System.out.print("Do you want to update other delivery man status? (Y=Yes): ");
                                        char updateOtherDM = scanner.next().charAt(0);
                                        scanner.nextLine();
                                        if (Character.toUpperCase(updateOtherDM) == 'Y') {
                                            loop[0] = true;
                                        }
                                    } else {//Reselect Delivery Man
                                        loop[0] = true;
                                    }
                                }
                            } while (loop[1] == true);
                        }
                    } else {//Invalid Option Selected
                        System.out.println("Please select option [0-" + count + "] only.");
                        loop[0] = true;
                    }
                }
            } else {
                System.out.println("No delivery man found in database.");
            }
        } while (loop[0] == true);
        System.out.println("You will be returned back to operation list in 3 seconds...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private static void generateDailyReport() {
        Scanner scanner = new Scanner(System.in);
        ListInterface<Delivery> deliveryList = File.retrieveList(DELIVERYFILE);
        boolean loop[] = new boolean[2];
        do {
            loop[0] = false;
            System.out.println("Generate Daily Delivery Report");
            System.out.println("==============================");
            System.out.print("Please select a date(dd/mm/yyyy): ");
            if (!scanner.hasNext("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
                System.out.println("Please enter a valid date format.");
                scanner.nextLine();
                loop[0] = true;
            } else {
                String[] date = scanner.nextLine().split("/");
                int day = Integer.parseInt(date[0]);
                int month = Integer.parseInt(date[1]);
                int year = Integer.parseInt(date[2]);
                //Retrieve delivery man list
                ListInterface<DeliveryMan> deliveryManList = File.retrieveList(DELIVERYMANFILE);
                int count = deliveryManList.getNumberOfEntries();
                int[] deliveryManId = new int[count];
                int[] deliveryCompleted = new int[count];
                int[] distanceTravelled = new int[count];
                //Set Delivery Man ID to deliveryManId array;
                for (int i = 1; i <= deliveryManList.getNumberOfEntries(); i++) {
                    deliveryManId[i - 1] = deliveryManList.getEntry(i).getId();
                }
                //Set deliveryCompleted and distanceTravelled for each deliveryManId
                for (int i = 1; i <= deliveryList.getNumberOfEntries(); i++) {
                    if (deliveryList.getEntry(i).getStatus().equalsIgnoreCase("Delivered")) {//Check delivery status
                        GregorianCalendar deliveryDate = deliveryList.getEntry(i).getDeliveryDate();
                        int tempDay = deliveryDate.get(Calendar.DAY_OF_MONTH);
                        int tempMonth = deliveryDate.get(Calendar.MONTH) + 1;
                        int tempYear = deliveryDate.get(Calendar.YEAR);
                        if (day == tempDay && month == tempMonth && year == tempYear) {//Check delivery date
                            int tempDeliveryManId = deliveryList.getEntry(i).getDeliveryMan().getId();
                            int tempDistanceTravelled = deliveryList.getEntry(i).getDistanceTravelled();
                            for (int j = 0; j < deliveryManId.length; j++) {
                                if (deliveryManId[j] == tempDeliveryManId) {//Check delivery man id
                                    deliveryCompleted[j]++;
                                    distanceTravelled[j] += tempDistanceTravelled;
                                    break;
                                }
                            }
                        }
                    }
                }
                //Store deliveryMan according to total deliveries completed & distance travelled in sorted list
                DeliveryReport report = new DeliveryReport();
                //Sort in ascending order based on deliveries completed
                SortedListInterface<DeliveryReport> reportList = new SortedDoublyLinkedList<>();
                for (int i = 0; i < deliveryManId.length; i++) {
                    report = new DeliveryReport(deliveryManList.getEntry(i + 1), deliveryCompleted[i], distanceTravelled[i]);
                    reportList.add(report);
                }
                //Print Report in descending order
                System.out.println("                            DAILY DELIVERY REPORT");
                System.out.printf("                                %02d-%02d-%04d\n", day, month, year);
                System.out.printf("%-4s %-20s %-6s %-12s %-13s %-13s\n", "ID", "NAME", "GENDER", "CONTACT_NO", "OOMPLETED_DEL", "DIST_TRAVELLED(m)");
                for (int i = reportList.getLength(); i >= 1; i--) {
                    System.out.println(reportList.getEntry(i));
                }
                if (count == 0) {
                    System.out.println("No Delivery Man Found");
                }
            }

        } while (loop[0]);

    }

    private static void registerAsAffiliate() {
        Scanner scanner = new Scanner(System.in);
        ListInterface<Affiliate> affiliateList = new LinearSinglyLinkedList<>();
        affiliateList = File.retrieveList(AFFILIATEFILE);

        String username, password, name, contactNo, restaurantName, businessRegNo, GSTRegNo, restaurantContactNo, address, state, city;
        char gender;
        int postcode = 0;
        System.out.println("Register as Affiliate");
        System.out.println("===========================================================================================");

        System.out.println("Please enter your :");

        do {
            System.out.print("Username    :");
            username = scanner.nextLine();
            if (Validation.CheckDuplicateUsername(username, affiliateList)) {
                System.out.println("The username already exist.");
            }
        } while (Validation.CheckDuplicateUsername(username, affiliateList));

        System.out.print("Passowrd    :");
        password = scanner.nextLine();

        System.out.print("Name        :");
        name = scanner.nextLine();
        do {
            System.out.print("Gender (M=Male or F=Female):");
            gender = scanner.next().charAt(0);
            gender = Character.toUpperCase(gender);
            if (gender != 'M' && gender != 'F') {
                System.out.println("Please enter M or F.");
            }
        } while (gender != 'M' && gender != 'F');
        scanner.nextLine();
        do {

            System.out.print("Contact No. (01#-########) :");
            contactNo = scanner.nextLine();

            if (!Validation.ValidateContactNumber(contactNo)) {
                System.out.println("Please enter a valid contact No.");
            }
        } while (!Validation.ValidateContactNumber(contactNo));
        System.out.println("");
        System.out.println("Please fill up restaurant's detail :");
        System.out.print("Resaturant Name :");
        restaurantName = scanner.nextLine();

        System.out.print("Business Registration No. :");
        businessRegNo = scanner.nextLine();

        System.out.print("GST Registration No. :");
        GSTRegNo = scanner.nextLine();
        do {
            System.out.print("Restaurant Contact No.(01#-########) :");
            restaurantContactNo = scanner.nextLine();
            if (!Validation.ValidateContactNumber(restaurantContactNo)) {
                System.out.println("Please enter a valid contact No.");
            }
        } while (!Validation.ValidateContactNumber(restaurantContactNo));

        System.out.println("");
        System.out.println("Restaurant Location :");
        System.out.print("Address :");
        address = scanner.nextLine();

        System.out.print("State :");
        state = scanner.nextLine();

        System.out.print("City :");
        city = scanner.nextLine();
        boolean isNotInteger = false;
        do {
            System.out.print("Postcode :");
            try {
                postcode = scanner.nextInt();

            } catch (NumberFormatException e) {
                System.out.println("Please enter integer.");
                isNotInteger = true;
            }
        } while (isNotInteger);
        char ans;

        System.out.print("Are you confirm to register?(Yes = Y) : ");
        ans = scanner.next().charAt(0);
        if (Character.toUpperCase(ans) == 'Y') {
            Address affiliateAddress = new Address(address, state, city, postcode);
            Affiliate newAffiliate = new Affiliate(restaurantName, businessRegNo, GSTRegNo, restaurantContactNo, affiliateAddress, username, password, name, gender, contactNo);
            affiliateList.add(newAffiliate);

            File.storeList(affiliateList, AFFILIATEFILE);
            System.out.println("\nRegister successful.");
        } else {
            System.out.println("\nYou had cancel to register.");
        }

    }
}
