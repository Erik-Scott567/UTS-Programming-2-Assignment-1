import java.util.LinkedList;
import java.util.Scanner;

public class Trip {

    private LinkedList<Destination> trip = new LinkedList<>();

    public Trip() {
        initializeDestinations();
    }

    private void initializeDestinations() {
        destination.add(new Destination("Eiffel Tower", "France"));
        destination.add(new Destination("Opera House", "Australia"));
        destination.add(new Destination("Uluru", "Australia"));
        destination.add(new Destination("Machu Picchu", "Peru"));
        destination.add(new Destination("Great Pyramids", "Egypt"));
        destination.add(new Destination("Niagara Falls", "Canada"));
    }

    public void add_trip() {
        Scanner In = new Scanner(System.in);
        System.out.print("Name: ");
        String first = In.nextLine();
        System.out.print("Country: ");
        String second = In.nextLine();
        Destination newTrip = new Destination(first, second);
        trip.add(newTrip);
        System.out.println("Destination added.");
    }

    public void remove_trip(Destination destination) {
        trip.remove(destination);
    }

    public LinkedList<Destination> getTripDestinations() {
        return trip;
    }
}