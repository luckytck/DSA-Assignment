
package Classes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Clocking implements Serializable{
    private DeliveryMan deliveryMan;
    private GregorianCalendar clockInTime;
    private GregorianCalendar clockOutTime;

    public Clocking() {
    }

    public Clocking(DeliveryMan deliveryMan, GregorianCalendar clockInTime) {
        this.deliveryMan = deliveryMan;
        this.clockInTime = clockInTime;
    }
    

    public Clocking(DeliveryMan deliveryMan, GregorianCalendar clockInTime, GregorianCalendar clockOutTime) {
        this.deliveryMan = deliveryMan;
        this.clockInTime = clockInTime;
        this.clockOutTime = clockOutTime;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public GregorianCalendar getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(GregorianCalendar clockInTime) {
        this.clockInTime = clockInTime;
    }

    public GregorianCalendar getClockOutTime() {
        return clockOutTime;
    }

    public void setClockOutTime(GregorianCalendar clockOutTime) {
        this.clockOutTime = clockOutTime;
    }
    
    public String printDate(GregorianCalendar date){
        if (date != null) {
            return String.format("%02d/%02d/%04d", date.get(Calendar.DAY_OF_MONTH), (date.get(Calendar.MONTH) + 1), date.get(Calendar.YEAR));
        }
        return "null";
    }
    
    public String printTime(GregorianCalendar time){
        String AM_PM = "";
        if (time != null) {
            if (time.get(Calendar.AM_PM) == 1) {
                AM_PM = "PM";
            } else {
                AM_PM = "AM";
            }
            return String.format("%02d:%02d:%02d%s",time.get(Calendar.HOUR), time.get(Calendar.MINUTE), time.get(Calendar.SECOND), AM_PM);
        }
        return "null";
    }
    
    public double calWorkingHours(){
        double hours = 0;
        if (clockInTime != null && clockOutTime != null) {
            long start = clockInTime.getTimeInMillis();
            long end = clockOutTime.getTimeInMillis();
            long different = end - start;
            int minutes = (int)TimeUnit.MILLISECONDS.toMinutes(different);
            hours = (double)minutes/60;
        } 
        return hours;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10s %-13s %-14s %13s", deliveryMan.getName(), printDate(clockInTime), printTime(clockInTime), printTime(clockOutTime), String.format("%.1f", calWorkingHours()));
    }
    
    public static void main(String[] args) {
        //Create Addresses
        Address address1 = new Address("Jalan Suasana 3/4, Bandar Tun Hussein Onn", "Selangor", "Cheras", 43200);
        Address address2 = new Address("Jalan Han 1/2, Taman Han", "Kuala Lumpur", "Setapak", 53300);
        
        //Create Delivery Men
        DeliveryMan user1 = new DeliveryMan("970219-14-6459","luckytck97@gmail.com", 2000.00, address1, "luckytck", "1234", "Tan Cheong Kiat", 'M', "011-37997626");
        DeliveryMan user2 = new DeliveryMan("971115-14-1455","qihan@gmail.com", 1900.00, address2, "hanhan", "1234", "Tan Qi Han", 'M', "012-3456789");
        
        //Create Clocking
        //new GregorianCalendar(Year,Month(start from 0),Day,24-Hour,Minute)
        Clocking clocking1 = new Clocking(user1, new GregorianCalendar(2017, 11, 4, 10, 0));// 4/11/2017 10.00AM
        clocking1.setClockOutTime(new GregorianCalendar(2017, 11, 4, 17, 30));// 4/11/2017 5.30PM
        Clocking clocking2 = new Clocking(user2, new GregorianCalendar()); //To Store Current System Time - just leave parameters empty
        
        //Print Clocking
        System.out.printf("%-20s %-10s %-13s %-13s %13s\n", "DELIVERY_MAN", "DATE", "CLOCK_IN_TIME", "CLOCK_OUT_TIME", "WORKING_HOURS");
        System.out.println(clocking1);
        System.out.println(clocking2);
    }
    
}
