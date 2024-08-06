import java.util.*;

// Interface that will be extended to all subclasses to display the details
interface Displayable 
{
    void displayDetails();
}

// First abstract class, Person
abstract class Person implements Displayable 
{
    private String name;
    private int age;
    private String gender;
    private boolean isDisability;

    // Constructor for Person
    public Person(String name, int age, String gender, boolean isDisability) 
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isDisability = isDisability;
    }

    // Getters for Person
    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    public String getGender() 
    {
        return gender;
    }

    public boolean isDisability() 
    {
        return isDisability;
    }

    // This block converts all the details stored in individual variables to ONE string, under the name sb i.e StringBuilder
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Age: ").append(age).append("\n");
        sb.append("Gender: ").append(gender).append("\n");
        sb.append("Disability: ").append(isDisability ? "Yes" : "No").append("\n");
        return sb.toString();
    }

    // Mentioning the abstract method but will be defined in subclass
    @Override
    public abstract void displayDetails();
}

// Passenger is a subclass of Person
class Passenger extends Person 
{
    // Additional details that define a passenger from a person
    private String passportNumber;

    // Constructor for Passenger
    public Passenger(String name, int age, String gender, boolean isDisability, String passportNumber) 
    {
        super(name, age, gender, isDisability);
        this.passportNumber = passportNumber;
    }

    // Getters for passenger
    public String getPassportNumber() 
    {
        return passportNumber;
    }

    // This block converts all the details stored in individual variables to ONE string, under the name sb i.e StringBuilder
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Passport Number: ").append(passportNumber).append("\n");
        return sb.toString();
    }

    // Displaying the passenger details 
    @Override
    public void displayDetails() 
    {
        System.out.println(toString());
    }
}

// interface that will be extended by Flight, along with Displayable
interface FlightOperations 
{
    // the bookTicket function checks if there are seats available
    // if seats are available, it returns true
    boolean bookTicket(Passenger passenger);
}

// Flight is an abstract class that implements the mentioned interfaces
abstract class Flight implements Displayable, FlightOperations 
{
    // Declaring all the parameters that define a flight
    private String flightNumber;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int totalSeats;
    private double fare;
    // This is an Array list that stores objects of class type Passenger under the variable name passengers
    private ArrayList<Passenger> passengers;

    // Constructor for Flight
    public Flight(String flightNumber, String source, String destination, String departureTime, String arrivalTime, int totalSeats, double fare) 
    {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.fare = fare;
        this.passengers = new ArrayList<>();
    }

    // Getters for Flight
    public String getFlightNumber() 
    {
        return flightNumber;
    }

    public String getSource() 
    {
        return source;
    }

    public String getDestination() 
    {
        return destination;
    }

    public String getDepartureTime() 
    {
        return departureTime;
    }

    public String getArrivalTime() 
    {
        return arrivalTime;
    }

    public int getTotalSeats() 
    {
        return totalSeats;
    }

    public int getAvailableSeats() 
    {
        // passengers.size() gives number of objects i.e passengers in the arraylist. So subtracting it from totalSeats gives available seats 
        return totalSeats - passengers.size();
    }

    public double getFare() 
    {
        return fare;
    }

    public ArrayList<Passenger> getPassengers() 
    {
        return passengers;
    }

    // Declaring the abstract method that will be defined in the appropriate subclass
    @Override
    public abstract void displayDetails();
}

// RegularFlight is a class that extends the superclass Flight
class RegularFlight extends Flight 
{
    // Constructor for RegularFlight that takes all the variables from super class Flight
    public RegularFlight(String flightNumber, String source, String destination, String departureTime, String arrivalTime, int totalSeats, double fare) 
    {
        super(flightNumber, source, destination, departureTime, arrivalTime, totalSeats, fare);
    }

    // Defining the display method for Regular Flight specifically
    @Override
    public void displayDetails() 
    {
        System.out.println("");
        System.out.print("Flight Number: " + getFlightNumber());
        System.out.print("  Source: " + getSource());
        System.out.print("  Destination: " + getDestination());
        System.out.print("  Departure Time: " + getDepartureTime());
        System.out.print("  Arrival Time: " + getArrivalTime());
        System.out.print("  Available Seats: " + getAvailableSeats());
        System.out.print("  Fare: " + getFare());
        System.out.print("");
    }

    // Definition of the bookTicket function that checks if flights are available
    @Override
    public boolean bookTicket(Passenger passenger) 
    {
        if (getAvailableSeats() > 0) 
        {
            getPassengers().add(passenger);
            return true;
        }
        return false;
    }
}

// CharterFlight is a class that extends the superclass Flight
class CharterFlight extends Flight 
{
    // CharterFlight will absorb all variables from super class Flight
    // We declare additional variables for CharterFlight specifically
    private String charterCompany;

    // Constructor for charter flight
    public CharterFlight(String flightNumber, String source, String destination, String departureTime, String arrivalTime, int totalSeats, double fare, String charterCompany) 
    {
        super(flightNumber, source, destination, departureTime, arrivalTime, totalSeats, fare);
        this.charterCompany = charterCompany;
    }

    // Getters
    public String getCharterCompany() 
    {
        return charterCompany;
    }

    // Defining the display method for Charter Flight specifically
    @Override
    public void displayDetails() 
    {
        System.out.println("");
        System.out.print("Flight Number: " + getFlightNumber());
        System.out.print("  Source: " + getSource());
        System.out.print("  Destination: " + getDestination());
        System.out.print("  Departure Time: " + getDepartureTime());
        System.out.print("  Arrival Time: " + getArrivalTime());
        System.out.print("  Available Seats: " + getAvailableSeats());
        System.out.print("  Fare: " + getFare());
        System.out.print("  Company: " + getCharterCompany());
        System.out.print("");
    }

    // Definition of the bookTicket function that checks if flights are available
    @Override
    public boolean bookTicket(Passenger passenger) 
    {
        if (getAvailableSeats() > 0) 
        {
            getPassengers().add(passenger);
            return true;
        }
        return false;
    }
}

// Main method 
public class Mark13
{
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Flight> flights = new ArrayList<>();
    // private static boolean True;

    public static void main(String [] args) 
    {
        // Initializing the flights with the data
        flights.add(new RegularFlight("AI101", "Delhi", "Mumbai", "08:00", "10:00", 150, 5000.00));
        flights.add(new RegularFlight("AI102", "Mumbai", "Delhi", "10:30", "12:30", 150, 5000.00));
        flights.add(new RegularFlight("AI103", "Delhi", "Kolkata", "13:00", "15:30", 120, 6000.00));
        flights.add(new RegularFlight("AI104", "Kolkata", "Delhi", "16:00", "18:30", 120, 6000.00));
        flights.add(new RegularFlight("AI105", "Mumbai", "Kolkata", "19:00", "21:30", 100, 7000.00));
        flights.add(new RegularFlight("AI106", "Kolkata", "Mumbai", "22:00", "00:30", 100, 7000.00));
        flights.add(new CharterFlight("CF101", "Chennai", "Pune", "09:00", "11:00", 50, 8000.00, "XYZ"));
        flights.add(new CharterFlight("CF102", "Pune", "Chennai", "09:30", "11:30", 50, 8000.00, "ABC"));

        // variable to stay in a menu-driven loop till exit
        boolean running = true;
        while (running) 
        {
            // Menu options
            System.out.println("");
            System.out.println("\n*** Airline Reservation System Menu ***");
            System.out.println("1. View available flights");
            System.out.println("2. Book a ticket");
            System.out.println("3. Display all passengers");
            System.out.println("4. Display ticket details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // Switch case for entered choice
            switch (choice) 
            {
                case 1:
                    displayAvailableFlights();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    displayAllPassengers();
                    break;
                case 4:
                    displayTicketDetails();
                    break;
                case 5:
                    running = false;
                    System.out.println("");
                    System.out.println("Exiting the program. Thank you for using the Airline Reservation System :)");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    // Displaying the flights initialised in the array list
    private static void displayAvailableFlights() 
    {
        System.out.println("\nAvailable flights:");
        // this for loop means that in every iteration, it takes one instance from "flights" of class Type "Flight" and stores it as "flight" 
        for (Flight flight : flights) 
        {
            // calls the display details function for flight details
            flight.displayDetails();
        }
    }
    
    //Method to book flight tickets
    private static void bookTicket() 
    {
        // Before booking, it displays all available flights
        displayAvailableFlights();
        System.out.println("");
        System.out.print("\nEnter flight number to book ticket: ");
        String flightNumber = scanner.next();

        //Checks if entered flight number exists in the the initialised flights array list
        Flight selectedFlight = findFlightByNumber(flightNumber);

        if (selectedFlight != null) 
        {
            //Error handling to check if passenger name entered is valid or not(Checks if entered string contains a number)
            boolean correct_name = false;
            String name = "";
            while (correct_name == false)
            {  
            try
            {
                System.out.print("Enter name: ");
                name = scanner.next();
                // verification acts like a count
                // If even a single name is discovered, verification is set to 1
                int verification1 = 0;
                for (int i = 0; i<name.length(); i++)
                {
                    char x = name.charAt(i);
                    if (x =='1' || x =='2' || x =='3' || x =='4' || 
                        x =='5' || x =='6' || x =='7' || x =='8' || 
                        x =='9')
                    {
                        verification1=1;
                    }
                    else
                    {
                        verification1=0;
                    }
                }
                // After iterating through the entire string, if verification is 1 then error
                // Else we exit the loop
                if (verification1 == 1)
                    {
                        throw new IllegalArgumentException("Invalid name");
                    }
                    else
                    {
                        correct_name = true;
                    }

            }
            catch (IllegalArgumentException e)
            {
                // Appropriate message for error
                System.out.println(e.getMessage());
                System.out.println("Please enter valid name (without numbers)");
            }
            }


            //check if entered age is valid, i.e above 0 and less than 110
            boolean correct_age = false;
            int age=0;
            while (correct_age == false)
            {  
            try
            {
                System.out.print("Enter passenger age: ");
                age = scanner.nextInt();
                if (age<0 || age>110)
                {
                    throw new IllegalArgumentException("Invalid age");
                }
                else
                {
                    correct_age = true;
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
                System.out.println("Please enter valid age");
            }
            }

            // checks if entered gender is between one if the 3 options, allowing for uppercase/lowercase
            boolean correct_gender = false;
            String gender="";
            while (correct_gender == false)
            {  
            try
            {
                System.out.print("Enter passenger gender (Male/Female/Other): ");
                gender = scanner.next();
                
                // Gender must be between the mentioned options
                if (!gender.equals("Male") && !gender.equals("male") && 
                    !gender.equals("Female") && !gender.equals("female") &&
                    !gender.equals("Other") && !gender.equals("other"))
                {
                    throw new IllegalArgumentException("Invalid gender");
                }
                else
                {
                    correct_gender = true;
                }
            }
            catch (IllegalArgumentException e)
            {
                // Error message to be displayed in case of invalid gender
                System.out.println(e.getMessage());
                System.out.println("Please enter valid gender");
            }
            }
            
            // Input for disability (Yes/No)
            System.out.print("Is passenger disabled? (Yes/No): ");
            boolean isDisability = scanner.next().equalsIgnoreCase("Yes");

            // Error handling for passport number, i.e should not have special characters
            boolean correct_passport_number = false;
            String passportNumber = "";
            while (correct_passport_number == false)
            {  
            try
            {
                System.out.print("Enter passport number: ");
                passportNumber = scanner.next();
                // verification acts like a count
                // If even a single special character is discovered, verification is set to 1
                int verification = 0;
                for (int i = 0; i<passportNumber.length(); i++)
                {
                    char x = passportNumber.charAt(i);
                    if (x =='`' || x =='~' || x =='!' || x =='@' || 
                        x =='#' || x =='$' || x =='%' || x =='^' || 
                        x =='&' || x =='*' || x =='(' || x ==')' || 
                        x =='-' || x =='_' || x =='+' || x =='=' || 
                        x ==';' || x ==':' || x =='<' || x =='>' || 
                        x =='.' || x =='?' || x =='"' || x =='|')
                    {
                        verification=1;
                    }
                    else
                    {
                        verification=0;
                    }
                }
                // After iterating through the entire string, if verification is 1 then error
                // Else we exit the loop
                if (verification == 1)
                    {
                        throw new IllegalArgumentException("Invalid passport number");
                    }
                    else
                    {
                        correct_passport_number = true;
                    }

            }
            catch (IllegalArgumentException e)
            {
                // Appropriate message for error
                System.out.println(e.getMessage());
                System.out.println("Please enter valid passport number (without special characters)");
            }
            }

            // If all the entered details are valid and they pass the error handling and checking, 
            // then we create a new object of Passenger class under the name passenger
            Passenger passenger = new Passenger(name, age, gender, isDisability, passportNumber);

            // Here the bookticket() function takes passenger as an argument and checks if seats are left. If yes, the ticket is booked and details are entered
            if (selectedFlight.bookTicket(passenger)) 
            {
                System.out.println("--------------------------------");
                System.out.println("Ticket booked successfully!");
                System.out.println("Passenger Details:");
                passenger.displayDetails();
                System.out.println("Flight Details:");
                selectedFlight.displayDetails();
                System.out.println("\n--------------------------------");
            } 
            else 
            {
                // Output statement if bookTicket() returns false
                System.out.println("Sorry, no seats available for the selected flight.");
            }
        } 
        else 
        {
            System.out.println("Invalid flight number.");
        }
    }

    // Function definition for displaying details of passengers of all flights
    private static void displayAllPassengers() 
    {
        // Outer loop iterates for each flight
        System.out.println("\nPassenger Details of all flights:");
        for (Flight flight : flights) 
        {
            System.out.println("Flight Number: " + flight.getFlightNumber());
            System.out.println("Source: " + flight.getSource());
            System.out.println("Destination: " + flight.getDestination());
            System.out.println("Passengers:");
            // Inner loop iterates for each passenger
            for (Passenger passenger : flight.getPassengers()) 
            {
                passenger.displayDetails();
            }
            System.out.println("-----------------------------------");
        }
    }

    // Function definition for displaying the details of tickets of an individual passenger
    private static void displayTicketDetails() 
    {
        // Identifying the passenger's ticket by their passport number
        System.out.print("Enter your passport number: ");
        String passportNumber = scanner.next();

        // Outer loop iterates through each flight
        for (Flight flight : flights) 
        {
            // Inner loop iterates through each passenger in the current instance of flight 
            for (Passenger passenger : flight.getPassengers()) 
            {
                // If passport number matches then details are displayed
                if (passenger.getPassportNumber().equalsIgnoreCase(passportNumber)) 
                {
                    System.out.println("Your ticket Details:");
                    System.out.println("");
                    System.out.println("Passenger Details:");
                    passenger.displayDetails();
                    System.out.println("Flight Details:");
                    flight.displayDetails();
                    return;
                }
            }
        }
        // If no such passport number is found then it displayes the appropriate statement
        System.out.println("Passenger not found");
    }

    // Function definition for finding the flight from the array list on the basis of flight number
    // Used to verify if entered flightnumber is valid and exists
    private static Flight findFlightByNumber(String flightNumber) 
    {
        for (Flight flight : flights) 
        {
            if (flight.getFlightNumber().equals(flightNumber)) 
            {
                return flight;
            }
        }
        return null;
    }
}