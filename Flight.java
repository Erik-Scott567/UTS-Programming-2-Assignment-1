public class Flight {
    private String airline;
    private int flightNo;
    private String takeoff_place;
    private String landing_place;
    private double cost;

    public Flight(String airline, int flightNo, String takeoff_place, String landing_place, double cost) {
        this.airline = airline;
        this.flightNo = flightNo;
        this.takeoff_place = takeoff_place;
        this.landing_place = landing_place;
        this.cost = cost;
    }

    public String getAirline() {
        return airline;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public String getTakeoff_place() {
        return takeoff_place;
    }

    public String getLanding_place() {
        return landing_place;
    }

    public double getCost() {
        return cost;
    }

    public boolean matchingFlight(String takeoff_place, String landing_place) {
        return this.takeoff_place.equals(takeoff_place) && this.landing_place.equals(landing_place);
    }
}