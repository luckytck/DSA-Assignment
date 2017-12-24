
package Classes;

import java.io.Serializable;

public class DeliveryMan extends User implements Serializable{
    private String NRIC;
    private String email;
    private double basicSalary;
    private Address address;
    private String status;
    private String workingStatus;

    public DeliveryMan() {
    }

    public DeliveryMan(String NRIC, String email, double basicSalary, Address address, String username, String password, String name, char gender, String contactNo) {
        super(username, password, name, gender, contactNo);
        this.NRIC = NRIC;
        this.email = email;
        this.basicSalary = basicSalary;
        this.address = address;
        this.status = "Active";
        this.workingStatus = "Offline";
    }

    public String getNRIC() {
        return NRIC;
    }

    public void setNRIC(String NRIC) {
        this.NRIC = NRIC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %-14s %-20s %12s %-80s %-10s %-14s", NRIC, email, String.format("%.2f", basicSalary), address, status, workingStatus);
    }
    
    public static void main(String[] args) {
        //Create Addresses
        Address address1 = new Address("Jalan Suasana 3/4, Bandar Tun Hussein Onn", "Selangor", "Cheras", 43200);
        Address address2 = new Address("Jalan Han 1/2, Taman Han", "Kuala Lumpur", "Setapak", 53300);
        
        //Create Delivery Men
        DeliveryMan user1 = new DeliveryMan("970219-14-6459","luckytck97@gmail.com", 2000.00, address1, "luckytck", "1234", "Tan Cheong Kiat", 'M', "011-37997626");
        DeliveryMan user2 = new DeliveryMan("971115-14-1455","qihan@gmail.com", 1900.00, address2, "hanhan", "1234", "Tan Qi Han", 'M', "012-3456789");
        
        //Print Delivery Men Details
        System.out.println(String.format("%-4s %-10s %-20s %-6s %-12s %-14s %-20s %-12s %-80s %-10s %-14s", "ID", "USERNAME", "NAME", "GENDER", "CONTACT_NO", "NRIC", "EMAIL", "BASIC_SALARY", "ADDRESS", "STATUS", "WORKING_STATUS"));
        System.out.println(user1);
        System.out.println(user2);
    }

}
