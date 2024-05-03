public interface AirportManagementSystem {
    default void addFlight(Flight flight){}
    default void removeFlight(Flight flight){}
    default void addPlane(Plane plane){}
    default void removePlane(Plane plane){}
    public businesspassenger addBusinessPassenger(int ID, String firstName, String lastName, String passengerType,int luggageCount, int dateOfBirth);
    default void removeBusinessPassenger(businesspassenger passenger){}
    public familypassenger addFamilyPassenger(int ID, String firstName, String lastName, String passengerType,int luggageCount, int dateOfBirth);
    default void removeFamilyPassenger(familypassenger passenger){}
    public economypassenger addEconomyPassenger(int ID, String firstName, String lastName, String passengerType,int luggageCount, int dateOfBirth);
    default void removeEconomyPassenger(economypassenger passenger){}
    default void addTicket(Ticket ticket){}
    default void removeTicket(Ticket ticket){}
    default void addHanger(Hanger hanger){}
    default void removeHanger(Hanger hanger){}
    default void addRunway(Runway runway){}
    default void removeRunway(Runway runway){}
}
