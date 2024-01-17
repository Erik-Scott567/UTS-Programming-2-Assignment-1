import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Destinations {

    private LinkedList<Destination> destination = new LinkedList<Destination>();
    private LinkedList<Destination> trip = new LinkedList<Destination>();
    private Flights flights;

    public Destinations(Flights flight) {

        this.flights = flights;

        destination.add(new Destination("Eiffel Tower","France"));
        destination.add(new Destination("Opera House","Australia"));
        destination.add(new Destination("Uluru","Australia"));
        destination.add(new Destination("Machu Picchu","Peru"));
        destination.add(new Destination("Great Pyramids","Egypt"));
        destination.add(new Destination("Niagara Falls","Canada"));
    }

    public void show_all_destination() {
        System.out.println("+----------------------+----------------+--------------+-------+-------+");
        System.out.println("|                              Destinations                            |");
        System.out.println("+----------------------+----------------+--------------+-------+-------+");
        for (Destination dest : destination) {
            System.out.println(dest.getName()+" in "+dest.getCountry());
        }
        System.out.println("+----------------------+----------------+--------------+-------+-------+");
    }

    public void show_destination_by_country() {
        Scanner In = new Scanner(System.in);
        int match = 0;
        List<String> result = new LinkedList<>();
        while (true) {
            System.out.print("Country: ");
            String choice = In.nextLine();
            for (Destination dest : destination) {
                if (choice.equals(dest.getCountry())) {
                    result.add(dest.getName()+" in "+dest.getCountry());
                    match++;
                }
            }
            if (match != 0) {
                System.out.println("+----------------------+----------------+--------------+-------+-------+");
                System.out.println("|                              Destinations                            |");
                System.out.println("+----------------------+----------------+--------------+-------+-------+");
                for (String item : result) {
                    System.out.println(item);
                }
                System.out.println("+----------------------+----------------+--------------+-------+-------+");
                break;
            }
            else {
                System.out.println("No matching destinations found.");
            }
        }
    }

    public void add_destination() {
        Scanner In = new Scanner(System.in);
        System.out.print("Name: ");
        String added_destination = In.nextLine();
        System.out.print("Country: ");
        String added_country = In.nextLine();
        Destination newDestination = new Destination(added_destination, added_country);
        destination.add(newDestination);
        System.out.println("Destination added.");
    }

    public void remove_destination() {
        Scanner In = new Scanner(System.in);
        int nomatch = 0;
        while (true) {
            System.out.print("Name: ");
            String remove_destination = In.nextLine();
            System.out.print("Country: ");
            String remove_country = In.nextLine();
            Iterator<Destination> iterator = destination.iterator();
            while (iterator.hasNext()) {
                Destination dest = iterator.next();
                if (dest.match(remove_destination, remove_country)) {
                    iterator.remove();
                    System.out.println("Destination removed.");
                    nomatch = 0;
                    break;
                }
                else {
                    nomatch++;
                }
            }
            if (nomatch > 0) {
                System.out.println("No matching destinations found.");
            }
            else {
                break;
            }
        }
    }

    public void add_trip() {
        Scanner In = new Scanner(System.in);
        int match = 0;
        while(true) {
            System.out.print("Name: ");
            String first = In.nextLine();
            System.out.print("Country: ");
            String second = In.nextLine();
            Iterator<Destination> iterator = destination.iterator();
            while (iterator.hasNext()) {
                Destination dest = iterator.next();
                if (dest.match(first, second)) {
                    Destination newTrip = new Destination(first, second);
                    trip.add(newTrip);
                    match++;
                    System.out.println("Destination added.");
                    break;
                }
            }
            if (match == 0) {
                System.out.println("No matching destinations found.");
            }
            else {
                break;
            }
        }
    }

    public void remove_trip() {
        Scanner In = new Scanner(System.in);
        int nomatch = 0;
        while (true) {
            System.out.print("Name: ");
            String remove_destination = In.nextLine();
            System.out.print("Country: ");
            String remove_country = In.nextLine();
            Iterator<Destination> iterator = trip.iterator();
            while (iterator.hasNext()) {
                Destination dest = iterator.next();
                if (dest.match(remove_destination, remove_country)) {
                    iterator.remove();
                    System.out.println("Destination removed.");
                    nomatch = 0;
                    break;
                }
                else {
                    nomatch++;
                }
            }
            if (nomatch > 0) {
                System.out.println("No matching destinations found.");
            }
            else {
                break;
            }
        }
    }

    public void connect() {
        if (trip.size() < 2) {
            System.out.println("At least two destinations are required for connecting flights.");
            return;
        }
        System.out.println("Connecting flights:");
        Iterator<Destination> iterator = trip.iterator();
        Destination prevDest = iterator.next();
        while (iterator.hasNext()) {
            Destination currentDest = iterator.next();
            findConnectingFlights(prevDest, currentDest);
            prevDest = currentDest;
        }
    }

    private void findConnectingFlights(Destination origin, Destination destination) {
        List<Flight> connectingFlights = flights.getFlightsBetweenCountries(origin.getCountry(), destination.getCountry());

        if (connectingFlights.isEmpty()) {
            System.out.println("No connecting flights found between " + origin.getName() + " and " + destination.getName());
        } else {
            System.out.println("Between " + origin.getName() + " and " + destination.getName() + ":");
            for (Flight flight : connectingFlights) {
                System.out.println(flight.getAirline() + " Flight " + flight.getFlightNo() + " from " + flight.getTakeoff_place() + " to " + flight.getLanding_place() + " for " + flight.getCost());
            }
        }
    }

    public void view_trip() {
        System.out.println("+----------------------+----------------+--------------+-------+-------+");
        System.out.println("|                                  Trip                                |");
        System.out.println("+----------------------+----------------+--------------+-------+-------+");
        for (Destination dest : trip) {
            System.out.println(dest.getName()+" in "+dest.getCountry());
        }
        System.out.println("Cost: 0.0");
        System.out.println("+----------------------+----------------+--------------+-------+-------+");
    }
}