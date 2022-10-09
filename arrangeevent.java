import java.util.Scanner;

// Manager class to make request
class Manager {
    private Controller sys;
    private BookId b;
    private Menu m;
    Scanner myObj = new Scanner(System.in);


    public void initiating(){
        sys = new Controller();
        b = new BookId();
        m = new Menu();

     // manager Constructor to can access unique customers with ID
        System.out.print("Enter Customer's Id: "); // Dummy input 
        int id = myObj.nextInt();
        sys.bookVenue();

    }

    public static void main(String[] args) {        // function that runs on manager class

        Manager m1 = new Manager();
        m1.initiating();
    }

}


// Controller or system class that controls most of the objects
class Controller {
    private Manager mag = new Manager();
    private double change;
    private BookId b = new BookId();
    private Venue v = new Venue();
    private Menu m = new Menu();
    private Eventpackages ev = new Eventpackages();
    Scanner myObj = new Scanner(System.in);



    public int bookVenue() {
        int eventId=b.getEventId();
        System.out.println("Enter how many seats you would like: "); // dummy input for seating arrangements
        int selectedseats = myObj.nextInt();
        System.out.println("Customise menue for customer, type 1 for yes or 2 for no: "); // dummy input for customising menu
        int selectedmenu = myObj.nextInt();
        System.out.println("Event changes saved and stored! "); // dummy confirmation made from system

        return eventId;
    }
}
// Booking class to retrieve customer ID
class BookId {
    private Controller sys;
    
    public int getEventId(){
        return 1;
    }

    public void bookVenue() {
        BookId b = new BookId(); 
        int eventId=b.getEventId();
    }

}

// Venue class used for making seating arrangements
class Venue {
    private Controller sys;
    
    public int setSeatingArrangements(){
        return 1;
    }

    public void bookVenue() {
        Venue v = new Venue(); 
        int seating=v.setSeatingArrangements();
    }

}
// Menu class used for customising customer menu incase of change (optional)
class Menu {
    private Controller sys;
    
    public int Menu(){
        return 1;
    }

    public void CustomiseMenu() {
        Menu m = new Menu(); 
        int menuPrice=m.Menu();
    }
}
