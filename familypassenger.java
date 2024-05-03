public class familypassenger extends airportpassenger{

    public familypassenger(int ID, String firstName, String lastName, String passengerType, int luggageCount, int dateOfBirth) {
        super(ID, firstName, lastName, "Family", luggageCount, dateOfBirth);
    }


    public double getDiscount() {
        return 0.15; // 15% discount for family passengers
    }
}
