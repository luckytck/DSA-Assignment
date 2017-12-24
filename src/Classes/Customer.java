
package Classes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Customer extends User implements Serializable{
    private String email;
    private GregorianCalendar birthDate;
    private Address address;

    public Customer() {
    }

    public Customer(String email, GregorianCalendar birthDate, Address address, String username, String password, String name, char gender, String contactNo) {
        super(username, password, name, gender, contactNo);
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public String printBirthDate(){
        return String.format("%02d/%02d/%04d", birthDate.get(Calendar.DAY_OF_MONTH), birthDate.get(Calendar.MONTH), birthDate.get(Calendar.YEAR));
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %-20s %-10s %-80s", email, printBirthDate(), address);
    }
    
    public static void main(String[] args) {
        //Create Addresses
        Address address1 = new Address("Jalan Suasana 3/4, Bandar Tun Hussein Onn", "Selangor", "Cheras", 43200);
        Address address2 = new Address("Jalan Han 1/2, Taman Han", "Kuala Lumpur", "Setapak", 53300);
        
        //Way to declare GregorianCalendar
        GregorianCalendar currentDate = new GregorianCalendar(); //It will set to today date
        GregorianCalendar date1 = new GregorianCalendar(1997, 1, 19);//Note - Month is start from 0, date1 is set to 19/2/1997
        
        //Way to get GregorianCalendar
        //Note - Month need + 1 & remember bracket it = (Month + 1)
        System.out.println(date1.get(Calendar.DAY_OF_MONTH) + "/" + (date1.get(Calendar.MONTH) + 1) + "/" + date1.get(Calendar.YEAR));
        
        //Way to set GregorianCalendar - date.set(year,month,day);
        GregorianCalendar date2 = new GregorianCalendar();
        date2.set(1996, 11, 15);
        
        //Create Customers
        Customer customer1 = new Customer("luckytck97@gmail.com", date1, address1, "luckytck", "1234", "Tan Cheong Kiat", 'M', "011-37997626");
        Customer customer2 = new Customer("hanhan@gmail.com", date2, address2, "hanhan", "1234", "Tan Qi Han", 'M', "012-3456789");
        
        //Print Customers' Details
        System.out.println(String.format("%-4s %-10s %-20s %-6s %-12s %-20s %-10s %-80s", "ID", "USERNAME", "NAME", "GENDER", "CONTACT_NO", "EMAIL", "BIRTH_DATE", "ADDRESS"));
        System.out.println(customer1);
        System.out.println(customer2);
    }
}
