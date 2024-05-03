import java.util.ArrayList;
import java.util.List;

public class Airport {
    private List<Flight> flights;
    private List<Plane> planes;
    private List<airportpassenger> passengers;
    private List<Ticket> tickets;
    private List<Hanger> hangers;
    private List<Runway> runways;

    public Airport() {
        flights = new ArrayList<>();
        planes = new ArrayList<>();
        passengers = new ArrayList<>();
        tickets = new ArrayList<>();
        hangers = new ArrayList<>();
        runways = new ArrayList<>();
    }

    // Add getters and setters for each list
    // Add methods to add and remove flights, planes, passengers, tickets, hangers, and runways
}
