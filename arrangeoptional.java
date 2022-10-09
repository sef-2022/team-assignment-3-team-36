import java.util.Scanner;

// Customer class to make request
class Client {
    private Initiater in;
    private Event e;
    private LogisticsManager lg;
    Scanner myObj = new Scanner(System.in);


    public void commencing(){
        in = new Initiater();
        e = new Event();
        lg = new LogisticsManager();

     // customer Constructor to can access unique customers with ID
        System.out.print("Enter your Id: "); // Dummy input 
        int id = myObj.nextInt();
        in.optionalservices();

    }

    public static void main(String[] args) {        // function that runs on customerr class

        Client c1 = new Client();
        c1.commencing();
    }

}


// Initiatier or system class that controls most of the objects
class Initiater {
    private Client c = new Client();
    private double change;
    private boolean musicBand;
    private boolean soundSystem;
    private boolean flowerDecoration;
    private double price;
    private Event b = new Event();
    private LogisticsManager lg = new LogisticsManager();
    Scanner myObj = new Scanner(System.in);


    public int optionalservices() {
        int eventId=b.getEventId();
        System.out.println("Would you like to select optional services: "); // dummy input for optional services
        String selectedServices = myObj.nextLine();

        return eventId;
    }

    public void Optional(){
        
        //Reading in Yes or No For optional services
        //hiring music band or not
        System.out.println("Hire music band");
        System.out.println("Enter Yes or No:");
        String music = myObj.nextLine();

        if (music.equals("Yes")){
            this.musicBand =true;
        } else {
            this.musicBand =false;
        }

        //hiring sound system or not
        System.out.println("Hire sound system");
        System.out.println("Enter Yes or No:");
        String sound = myObj.nextLine();

        if (sound.equals("Yes")){
            this.soundSystem =true;
        } else {
            this.soundSystem =false;
        }

        //hiring flower decoration or not
        System.out.println("Hire flower decoration");
        System.out.println("Enter Yes or No:");
        String flower = myObj.nextLine();

        if (flower.equals("Yes")){
            this.flowerDecoration =true;
        } else {
            this.flowerDecoration =false;
        }

        
    }
}
// Event class to retrieve customer ID
class Event {
    private Initiater in;
    
    public int getEventId(){
        return 1;
    }

    public void optionalservices() {
        Event b = new Event(); 
        int eventId=b.getEventId();
    }

}

// Manager class used for accessing optional services
class LogisticsManager {
    private Initiater in;
    private OptionalServices op = new OptionalServices();
    
    public int notifyServices() {
        int services= op.getMusicBand();
        op.getSoundSystem();
        op.getFlowerDecoration();
        return services;
    }

    public void optionalservices() {
        LogisticsManager lg = new LogisticsManager(); 
        int updateServices=lg.notifyServices();
    }

}
// Optional Services class used for selecting extra services
class OptionalServices {
    private LogisticsManager lg;
    Scanner myObj = new Scanner(System.in);

    public int getMusicBand() {
        return 1;
    }
    public int getSoundSystem() {
        return 1;
    }
    public int getFlowerDecoration() {
        return 1;
    }
    
    
}
