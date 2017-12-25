package Classes;

import ADTs.ListInterface;
import ADTs.SortedDoublyLinkedList;
import ADTs.SortedListInterface;

/**
 *
 * @author Tan Cheong Kiat
 */
public class DeliveryReport implements Comparable<DeliveryReport> {

    private DeliveryMan deliveryMan;
    private int deliveriesCompleted;
    private int distanceTravelled;

    public DeliveryReport() {
    }
        
    public DeliveryReport(DeliveryMan deliveryMan, int deliveriesCompleted, int distanceTravelled) {
        this.deliveryMan = deliveryMan;
        this.deliveriesCompleted = deliveriesCompleted;
        this.distanceTravelled = distanceTravelled;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public int getDeliveriesCompleted() {
        return deliveriesCompleted;
    }

    public void setDeliveriesCompleted(int deliveriesCompleted) {
        this.deliveriesCompleted = deliveriesCompleted;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    @Override
    public int compareTo(DeliveryReport other) {
        return (this.getDeliveriesCompleted() + "").compareTo((other.getDeliveriesCompleted() + ""));
    }

    @Override
    public String toString() {
        return String.format("%-4d %-20s %-6s %-12s %13d %16d", deliveryMan.getId(), deliveryMan.getName(), deliveryMan.getGender(), deliveryMan.getContactNo(), deliveriesCompleted, distanceTravelled);
    }

    public static void main(String[] args) {
        SortedListInterface<DeliveryReport> reportList = new SortedDoublyLinkedList<>();
        ListInterface<DeliveryMan> deliveryManList = File.retrieveList("deliveryMan.dat");
        DeliveryReport report1 = new DeliveryReport(deliveryManList.getEntry(1), 3, 1000);
        DeliveryReport report2 = new DeliveryReport(deliveryManList.getEntry(2), 1, 1500);
        DeliveryReport report3 = new DeliveryReport(deliveryManList.getEntry(3), 2, 3000);
        DeliveryReport report4 = new DeliveryReport(deliveryManList.getEntry(4), 4, 5000);
        reportList.add(report1);
        reportList.add(report2);
        reportList.add(report3);
        reportList.add(report4);
        System.out.printf("%-4s %-20s %-6s %-12s %-13s %-13s\n", "ID", "NAME", "GENDER", "CONTACT_NO", "DEL_COMPLETED", "DIST_TRAVELLED(m)");
        for (int i = 1; i <= reportList.getLength(); i++) {
            System.out.println(reportList.getEntry(i));
        }
    }
}