public class businesspassenger extends airportpassenger{

    public businesspassenger(int ID, String firstName, String lastName, String passengerType, int luggageCount, int dateOfBirth) {
        super(ID, firstName, lastName, "Business", luggageCount, dateOfBirth);

    }

    @Override
    public double getDiscount() {
        return 0.2; // 20% discount for business passengers
    }

}
