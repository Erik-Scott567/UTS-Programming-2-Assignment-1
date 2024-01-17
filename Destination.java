import java.util.LinkedList;

public class Destination {
    private String name;
    private String country;

    public Destination(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public boolean match(String name, String country) {
        return this.name.equals(name) && this.country.equals(country);
    }
}