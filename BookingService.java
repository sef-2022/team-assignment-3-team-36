import java.util.Date;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;


class Customer {
    private int customerId = 0;
    private String customerName = null;
    private String phoneNumber = null;
    private String email = null;
    private String address = null;
    Scanner myObj = new Scanner(System.in);



    // customer Contructor to add their name, phone, email, adress after selecting all that required for the hiring event service
    public void setCustomerInfo(){
        System.out.print("Name:");
        this.customerName = myObj.nextLine();

        System.out.print("Phone number:");
        int phone = myObj.nextInt();
        myObj.nextLine();
        this.phoneNumber = String.valueOf(phone);


        System.out.print("Email:");
        this.email = myObj.nextLine();
        
        System.out.print("Address:");
        this.address= myObj.nextLine();

    }
    //MAIN function that runs on customer class
    public static void main(String[] args) {
        Booking c = new Booking();
        c.booking();
        
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

    public void booking(){
        //sequences of method that was in the Sequence diagram to finish booking the Services
        //get Packages
        System.out.printf("Avaliable Packages: " +packages.getPackageType()+ '\n');
        packages.selectPackage(); //selecting a package
        venue.getVenue(); //Show Venues
        venue.virtualTour(); //Dummy print for Virtual tour
        venue.selectVenue(); // Selecting a venue
        venue.getAvailableDate(); // Dummy print for availble Dates
        venue.setNumberOfGuest(); // Customer give the number of guests coming into the event
        System.out.printf(menu.getMenu()+ '\n'); //printing ou the menu
        menu.selectMenu(); //selecting a menu
        optional.Optional(); //Choosing the optional service on Music band, sound system and flower decoration
        System.out.printf("Final Bill: " +getBill()+ '\n'); // the total bill
        c1.setCustomerInfo(); //getting customer info
        System.out.printf("Event ID generated: " + getEventId()); //the EventID
    }

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

class Eventpackages{
    private String packageType = "Package 1, Package 2, Package 3";
    private double packagePrice = 200;
    private int selectedPackage;
    Scanner myObj = new Scanner(System.in);

    //Return a string of Package
    public String getPackageType(){
        return packageType;
    }
    // selecting one of the available packages
    public void selectPackage(){
        System.out.println("Type in 1, 2 or 3 to select one of the menu");
        selectedPackage = myObj.nextInt();
    }

    // get the Package Price
    public double getPackagePrice(){
        return this.packagePrice;
    }

}

class Venue{
    private String[] venueOptions = {"Venue 1", "Venue 2", "Venue 3"};
    private double venuePrice;
    protected int numberOfGuests;
    protected Date availableDate;
    protected boolean physicalTour;
    Scanner myObj = new Scanner(System.in);

    //Selecting available dummies values of venues
    public void selectVenue(){
        System.out.println("Type in 1, 2 or 3 to select one of the Venue");
        int selectedPackage = myObj.nextInt();
    }

    //print out the The available venues
    public void getVenue(){
        System.out.print("Venue: ");
        for (int i = 0; i < 3; i++){
            System.out.print(venueOptions[i] + " ");
        }
        System.out.print("\n");
    }

    //Set number of guest for the event
    public void setNumberOfGuest(){
        System.out.println("Enter number of guest:");
        this.numberOfGuests = myObj.nextInt();
    }
    //dummy value for virtuql tour
    public void virtualTour(){
        //currently accessing virtual if this print out
        System.out.println("accessing Virtual Tour Now");
    }
    // print out dummy values for available dates
    public void getAvailableDate(){
        System.out.println("Available Dates: 8/10/2022, 9/10/2022, 10/10/2022");
    }

    //get price of venue
    public double getVenuePrice(){
        return venuePrice = 20;
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

class OptionalServices{
    private boolean musicBand;
    private boolean soundSystem;
    private boolean flowerDecoration;
    private double price;
    Scanner myObj = new Scanner(System.in);
    
    // Checking if the customer wanted any optional Serivces 
    public void Optional(){
        
        //Reading in Yes or No For optional services
        //hiring music band or not
        System.out.println("Do u want to hire music band");
        System.out.println("Enter Yes or No:");
        String music = myObj.nextLine();

        if (music.equals("Yes")){
            this.musicBand =true;
        } else {
            this.musicBand =false;
        }

        //hiring sound system or not
        System.out.println("Do u want to hire sound system");
        System.out.println("Enter Yes or No:");
        String sound = myObj.nextLine();

        if (sound.equals("Yes")){
            this.soundSystem =true;
        } else {
            this.soundSystem =false;
        }

        //hiring flower decoration or not
        System.out.println("Do u want to hire flower decoration");
        System.out.println("Enter Yes or No:");
        String flower = myObj.nextLine();

        if (flower.equals("Yes")){
            this.flowerDecoration =true;
        } else {
            this.flowerDecoration =false;
        }
    }
    
    //get to total price of all optional serivce hired
    public double getPrice(){
        this.price = 0;
        //if music band is hired add 20 to the initial price
        if (musicBand){
            this.price += 20;
        }
        //if sound system is hired add 20 to the initial price
        if (soundSystem){
            this.price += 10.8;
        }
        //if folower Decoration is hired add 20 to the initial price
        if (flowerDecoration){
            this.price += 6.7;
        }
        return price;
    }

}
