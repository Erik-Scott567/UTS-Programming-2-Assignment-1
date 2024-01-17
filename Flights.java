import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Flights {
    private LinkedList<Flight> flights = new LinkedList<Flight>();

    public Flights() {
        flights.add(new Flight("American Airlines", 575, "Canada", "France", 826.58));
        flights.add(new Flight("Jetstar", 453, "France", "Canada", 417.91));
        flights.add(new Flight("United Airlines", 339, "Egypt", "France", 911.92));
        flights.add(new Flight("Etihad", 642, "France", "Egypt", 817.29));
        flights.add(new Flight("British Air", 368, "Australia", "France", 841.37));
        flights.add(new Flight("American Airlines", 162, "France", "Australia", 396.26));
        flights.add(new Flight("Jetstar", 372, "Peru", "France", 636.65));
        flights.add(new Flight("United Airlines", 687, "France", "Peru", 779.25));
        flights.add(new Flight("Etihad", 905, "Canada", "Australia", 454.54));
        flights.add(new Flight("British Air", 311, "Australia", "Canada", 415.68));
        flights.add(new Flight("American Airlines", 739, "Egypt", "Australia", 611.49));
        flights.add(new Flight("Jetstar", 829, "Australia", "Egypt", 420.67));
        flights.add(new Flight("United Airlines", 634, "Peru", "Australia", 491.86));
        flights.add(new Flight("Etihad", 885, "Australia", "Peru", 548.23));
        flights.add(new Flight("British Air", 967, "Canada", "Peru", 736.12));
        flights.add(new Flight("American Airlines", 130, "Peru", "Canada", 530.05));
        flights.add(new Flight("Jetstar", 166, "Egypt", "Peru", 299.32));
        flights.add(new Flight("United Airlines", 208, "Peru", "Egypt", 641.98));
        flights.add(new Flight("Etihad", 860, "Canada", "Egypt", 672.90));
        flights.add(new Flight("British Air", 325, "Egypt", "Canada", 806.92));
    }

    public void view_all_flights() {
        System.out.println("+----------------------+----------------+--------------+-------+-------+");
        System.out.println("|                                Flights                               |");
        System.out.println("+----------------------+----------------+--------------+-------+-------+");
        for (Flight fly : flights) {
            System.out.println(fly.getAirline()+" Flight "+fly.getFlightNo()+" from "+fly.getTakeoff_place()+" to "+fly.getLanding_place()+" for "+fly.getCost());
        }
        System.out.println("+----------------------+----------------+--------------+-------+-------+");
    }

    public void view_flights_by_country() {
        Scanner In = new Scanner(System.in);
        int match = 0;
        List<String> result = new LinkedList<>();
        while (true) {
            System.out.print("Country: ");
            String choice = In.nextLine();
            for (Flight fly : flights) {
                if (choice.equals(fly.getTakeoff_place())) {
                    result.add(fly.getAirline()+" Flight "+fly.getFlightNo()+" from "+fly.getTakeoff_place()+" to "+fly.getLanding_place()+" for "+fly.getCost());
                    match++;
                }
                if (choice.equals(fly.getLanding_place())) {
                    result.add(fly.getAirline()+" Flight "+fly.getFlightNo()+" from "+fly.getTakeoff_place()+" to "+fly.getLanding_place()+" for "+fly.getCost());
                    match++;
                }
            }
            if (match != 0) {
                System.out.println("+----------------------+----------------+--------------+-------+-------+");
                System.out.println("|                                Flights                               |");
                System.out.println("+----------------------+----------------+--------------+-------+-------+");
                for (String item : result) {
                    System.out.println(item);
                }
                System.out.println("+----------------------+----------------+--------------+-------+-------+");
                break;
            }
            else {
                System.out.println("No matching flights found.");
            }
        }
    }

    public void add_flight() {
        Scanner In = new Scanner(System.in);
        int pass = 0;
        while (true) {
            pass = 0;
            System.out.print("Airline: ");
            String Airline = In.nextLine();
            System.out.print("Flight Number: ");
            int FlightNumber = In.nextInt();
            System.out.print("Takeoff: ");
            In.nextLine();
            String TakeOffPlace= In.nextLine();
            System.out.print("Landing: ");
            String LandingPlace = In.nextLine();
            for (Flight fly : flights) {
                if (Airline.equals(fly.getAirline()) && (FlightNumber == (fly.getFlightNo())) && (TakeOffPlace.equals(fly.getTakeoff_place())) && (LandingPlace.equals(fly.getLanding_place()))) {
                    pass++;
                }
                if (pass > 0) {
                System.out.println("This flight already exists.");
                break;
                }
            }
            if (pass == 0) {
                    System.out.print("Cost: ");
                    if (In.hasNextDouble()) {
                        Double Cost = In.nextDouble();
                        if (Cost > 0) {
                            Flight flight = new Flight(Airline, FlightNumber, TakeOffPlace, LandingPlace, Cost);
                            flights.add(flight);
                            System.out.println("Flight added");
                            break;
                        }
                        else {
                            System.out.println("Invalid input.");
                            In.nextLine();
                        }
                    }
                    else {
                        System.out.println("Invalid input.");
                        In.nextLine();
                }
            }
        }
    }

    public void remove_flight() {
        Scanner In = new Scanner(System.in);
        int nomatch = 0;
        while (true) {
            System.out.print("Takeoff: ");
            String remove_takeoff = In.nextLine();
            System.out.print("Landing: ");
            String remove_landing = In.nextLine();
            Iterator<Flight> iterator = flights.iterator();
            while (iterator.hasNext()) {
                Flight fly = iterator.next();
                if (fly.matchingFlight(remove_takeoff, remove_landing)) {
                    iterator.remove();
                    System.out.println(fly.getAirline()+" Flight "+fly.getFlightNo()+" from "+fly.getTakeoff_place()+" to "+fly.getLanding_place()+" for "+fly.getCost()+" removed.");
                    nomatch = 0;
                    break;
                }
                else {
                    nomatch++;
                }
            }
            if (nomatch > 0) {
                System.out.println("No matching flight found.");
            }
            else {
                break;
            }
        }
    }
}
