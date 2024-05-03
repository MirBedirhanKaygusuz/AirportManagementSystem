public class economypassenger extends airportpassenger {
    public economypassenger(int ID, String firstName, String lastName, String passengerType, int luggageCount, int dateOfBirth) {
        super(ID, firstName, lastName, "Economy", luggageCount, dateOfBirth);
    }

    @Override
    public double getDiscount() {
        return 0.1; // 10% discount for economy passengers
    }

}



