import java.util.Scanner;
//an abstract class that will be inherited by caterer
abstract class Staff {
    protected double salary;
    protected double bill = 4000;
    protected double allocatedMoney =7000;

    //salary for the event management team
    public double getSalary(){
        return salary; 
    }
    //printing out dummies values of tracking orders
    public void trackOrder(){
        System.out.println("food is succefully ordered");
        System.out.println("seating arrangment is done");
        System.out.println("Optional services has been ordered");
        System.out.println("Query haven't being resolved yet");
    }
}

class Caterer extends Staff {
    Booking booking = new Booking();
    Menu menu  = new  Menu();

    public double getSalary(){
        salary = allocatedMoney - bill;
        return salary;
    }
    //first find the EventId that has been booked and then find the menu that they booked
    public void orderFood(){
        int EventID = booking.getEventId();

        System.out.println("Finding the Menu that Event ID " + EventID + " selected");
        String menus = menu.getMenu();
        String[] selected = menus.split(",");
        System.out.println("Successfully Ordered " + selected[2] + " for Event ID " + EventID );

    }
    //first find the EventId that has ordered food  and then arrange the cultery for the event
    public void culteryArrangement(){
        int EventID = booking.getEventId();
        System.out.println("Successfully arranged the cultery for Event ID" + EventID );

    }
    // first find the EventId that has ordered food and then successfuly pick up the order
    public void pickupFood(){
        int EventID = booking.getEventId();
        System.out.println("Successfully picked up the food for Event ID" + EventID );
    }
    public double getAllocatedMoney(){
        return allocatedMoney;
    }
    //send bills to the finance manager
    public double sendBill(){
        double bill = this.allocatedMoney - this.salary;
        return bill;
    }

    public static void main(String[] args) {
        Caterer c = new Caterer();
        c.orderFood();
        c.culteryArrangement();
        c.pickupFood();
        
    }
}


class Booking{
    private int bookingId;
    private double bill;
    private String[] paymentOption;
    private Eventpackages packages= new Eventpackages();
    private Venue venue = new Venue();
    private Menu menu = new Menu();
    private OptionalServices optional = new OptionalServices();
    private Customer c1= new Customer();


    //Generate a dummy booking ID 
    public int getBookingId(){
        bookingId = 123;
        return bookingId;
    }
    //calculate the final bill after getting all the Prices for each section by summing it up
    public double getBill(){
        bill += packages.getPackagePrice();
        bill += venue.getVenuePrice();
        bill += menu.getMenuPrice();
        bill += optional.getPrice();
        return bill;
    }
    //Generate a dummy event ID 
    public int getEventId(){
        return 123;
    }
}


class Menu{
    private String Menu;
    private double menuPrice;
    protected boolean customiseMenu;
    Scanner myObj = new Scanner(System.in);

    //get the available menu
    public String getMenu(){
        //dummy Menu
        return Menu = "Menu 1, Menu 2, Menu 3";
    }

    //select the one from 3 dummies menu
    public void selectMenu(){
        System.out.println("Type in 1, 2 or 3 to select one of the menu");
        int menu = myObj.nextInt();
        //dummy Menu of each dummy price
        if (menu == 1){
            this.menuPrice = 50;
        } else if (menu == 2) {
            this.menuPrice = 60;
        } else {
            this.menuPrice = 70;
        }
    }
    // get the price of the menu selected
    public double getMenuPrice(){
        return this.menuPrice;      
    }

}