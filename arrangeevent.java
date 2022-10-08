import java.util.Scanner;


class Manager {
    private System sys;
    private Booking b;
    private Menu m;
    Scanner myObj = new Scanner(System.in);


    public void initiating(){
        sys = new System();
        b = new Booking();
        m = new Menu();

        System.out.print("Enter CustomerId: ");
        int id = myObj.nextLine();
        sys.bookVenue();

    }

    public static void main(String[] args) {
        Manager m1 = new Manager();
        m1.initiating();
    }

}



class System {
    private Manager mag = new Manager();
    private Booking b = new Booking();
    private Venue v = new Venue();
    private EventPackages ev = new EventPackages();
    private Menu m = new Menu();


    public int bookVenue() {
        int eventId=b.getEventId();
        int seating=v.setSeatingArrangements();
        return eventId;
    }

}

class Booking {
    private System sys;
    
    public int getEventId(){
        return 1;
    }

    public void bookVenue() {
        Booking b = new Booking(); 
        int eventId=b.getEventId();
    }

}

class Venue {
    private System sys;
    
    public int setSeatingArrangements(){
        return 1;
    }

    public void bookVenue() {
        Venue v = new Venue(); 
        int seating=v.setSeatingArrangements();
    }

}

class Menu {
    private System sys;
    
    public int Menu(){
        return 1;
    }

    public void CustomiseMenu() {
        Menu m = new Menu(); 
        int menuPrice=m.Menu();
    }

}
