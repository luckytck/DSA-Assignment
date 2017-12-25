package Classes;

import java.io.Serializable;

public class Executive extends User implements Serializable{
    private String NRIC;
    private String email;
    private double basicSalary;
    private Address address;
    private String department;
    private double allowance;
    private String status;

    public Executive() {
    }

    public Executive(String NRIC, String email, double basicSalary, Address address, String department, double allowance, String username, String password, String name, char gender, String contactNo) {
        super(username, password, name, gender, contactNo);
        this.NRIC = NRIC;
        this.email = email;
        this.basicSalary = basicSalary;
        this.address = address;
        this.department = department;
        this.allowance = allowance;
        this.status = "Active";
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %-20s %-14s %-20s %12s %10s %-80s %-10s", department, NRIC, email, String.format("%.2f", basicSalary), String.format("%.2f", allowance), address, status);
    }
    
    public static void main(String[] args) {
        //Create Addresses
        Address address1 = new Address("Jalan Suasana 3/4, Bandar Tun Hussein Onn", "Selangor", "Cheras", 43200);
        Address address2 = new Address("Jalan Han 1/2, Taman Han", "Kuala Lumpur", "Setapak", 53300);
        
        //Create Delivery Men
        Executive executive1 = new Executive("970219-14-6459","luckytck97@gmail.com", 2000.00, address1, "Human Resources", 500, "luckytck", "1234", "Tan Cheong Kiat", 'M', "011-37997626");
        Executive executive2 = new Executive("971115-14-1455","qihan@gmail.com", 1900.00, address2, "Accounting", 500, "hanhan", "1234", "Tan Qi Han", 'M', "012-3456789");
        
        //Print Executive Details
        System.out.println(String.format("%-4s %-10s %-20s %-6s %-12s %-20s %-14s %-20s %-12s %10s %-80s %-10s", "ID", "USERNAME", "NAME", "GENDER", "CONTACT_NO", "DEPARTMENT", "NRIC", "EMAIL", "BASIC_SALARY", "ALLOWANCE", "ADDRESS", "STATUS"));
        System.out.println(executive1);
        System.out.println(executive2);
    }
}