import java.util.*;

public class Agency {
    private LinkedList<Destination> destination = new LinkedList<Destination>();
    private static final String[] usernames = {"agent1", "agent2"};
    private static final String[] passwords = {"password1", "password2"};
    private static final String[] agent_names = {"David Dyer", "Mike Knox"};

    public boolean loginAgent(String username, String password) {
        int index = Arrays.asList(usernames).indexOf(username);
        if (index != -1 && password.quals(passwords[index])) {
            System.out.println("Logged in");
            return true;
        }
        else {
            System.out.println("Login Failed");
            return false;
        }
    }
    
    public Agency() {


    }

    public static void main(String[] args) {
        Flights flights = new Flights();
        Destinations destinations = new Destinations(flights);
        Scanner In = new Scanner(System.in);
        int done = 0;
        while (true) {
            System.out.print("Username: ");
            String enteredUsername = In.nextLine();
            System.out.print("Password: ");
            String enteredPassword = In.nextLine();

            boolean loggedIn = false;
            int userIndex = 0;
            for (String username : usernames) {
                if (username.equals(enteredUsername) && passwords[userIndex].equals(enteredPassword)) {
                    loggedIn = true;
                    break;
                }
                userIndex++;
            }
            if (loggedIn) {
                System.out.println("Welcome to the Prog2 Travel Agency " + agent_names[userIndex] + ", Please make a selection from the menu:");
                while (true) {
                    int count = 0;
                    System.out.println("1. Explore Flights");
                    System.out.println("2. Explore Destinations");
                    System.out.println("3. Book a Trip");
                    System.out.println("X. Exit the System");
                    System.out.print("Please enter an option: ");
                    String agent_choice = In.nextLine();
                    if (agent_choice.equals("1")) {
                        System.out.println("Welcome to the Flights section " + agent_names[userIndex] + ", Please make a selection from the menu:");
                        while (true) {
                            if (count > 0) {
                                count--;
                            }
                            System.out.println("1. View All Flights");
                            System.out.println("2. View Flights by Country");
                            System.out.println("3. Add a Flight");
                            System.out.println("4. Remove a Flight");
                            System.out.println("X. Return to Main Menu");
                            System.out.print("Please enter an option: ");
                            String agent_choice_1 = In.nextLine();
                            if (agent_choice_1.equals("1")) {
                                flights.view_all_flights();
                                count++;
                            }
                            if (agent_choice_1.equals("2")) {
                                flights.view_flights_by_country();
                                count++;
                            }
                            if (agent_choice_1.equals("3")) {
                                flights.add_flight();
                                count++;
                            }
                            if (agent_choice_1.equals("4")) {
                                flights.remove_flight();
                                count++;
                            }
                            if (agent_choice_1.equals("X")) {
                                count++;
                                break;
                            }
                            else {
                                if (count == 0) {
                                    System.out.println("Please enter a valid choice, or press X to exit.");
                                }
                            }
                        }
                    }
                    if (agent_choice.equals("2")) {
                        System.out.println("Welcome to the Destinations section " + agent_names[userIndex] + ", Please make a selection from the menu:");
                        while (true) {
                            if (count > 0) {
                                count--;
                            }
                            System.out.println("1. View All Destinations");
                            System.out.println("2. View Destinations by Country");
                            System.out.println("3. Add a Destination");
                            System.out.println("4. Remove a Destination");
                            System.out.println("X. Return to Main Menu");
                            System.out.print("Please enter an option: ");
                            String agent_choice_2 = In.nextLine();
                            if (agent_choice_2.equals("1")) {
                                destinations.show_all_destination();;
                                count++;
                            }
                            if (agent_choice_2.equals("2")) {
                                destinations.show_destination_by_country();
                                count++;
                            }
                            if (agent_choice_2.equals("3")) {
                                destinations.add_destination();
                                count++;
                            }
                            if (agent_choice_2.equals("4")) {
                                destinations.remove_destination();
                                count++;
                            }
                            if (agent_choice_2.equals("X")) {
                                count++;
                                break;
                            }
                            else {
                                if (count == 0) {
                                    System.out.println("Please enter a valid choice, or press X to exit.");
                                }
                            }
                        }
                    }
                    if (agent_choice.equals("3")) {
                        System.out.println("Welcome to the Trips section! Please make a selection from the menu: ");
                        while (true) {
                            if (count > 0) {
                                count--;
                            }
                            System.out.println("1. Add a Destination");
                            System.out.println("2. Remove a Destination");
                            System.out.println("3. Add Connecting Flights");
                            System.out.println("4. View Trip Details");
                            System.out.println("X. Return to Main Menu");
                            System.out.print("Please enter an option: ");
                            String agent_choice_3 = In.nextLine();
                            if (agent_choice_3.equals("1")) {
                                destinations.add_trip();
                                count++;
                            }
                            if (agent_choice_3.equals("2")) {
                                destinations.remove_trip();
                                count++;  
                            }
                            if (agent_choice_3.equals("3")) {
                                destinations.connect();
                                count++;       
                            }
                            if (agent_choice_3.equals("4")) {
                                destinations.view_trip();
                                count++;
                            }
                            if (agent_choice_3.equals("X")) {
                                count++;
                                break; 
                            }
                            else {
                                if (count == 0) {
                                    System.out.println("Please enter a valid choice, or press X to exit.");
                                }
                            }
                        }
                    }
                    if (agent_choice.equals("X")) {
                        System.out.println("Thanks for using the Prog2 Travel Agency.");
                        done++;
                        break;
                    }
                    
                    else {
                        if (count == 0) {
                            System.out.println("Please enter a valid choice, or press X to exit.");
                        }
                        else {
                            System.out.println("Welcome to the Prog2 Travel Agency " + agent_names[userIndex] + ", Please make a selection from the menu:");
                        }
                    }
                
                } 
            
            }
            else {
                    System.out.println("Invalid Credentials! Try Again.");
                }
            
            if (done > 0) {
                break;
            }
        }
    }
}

