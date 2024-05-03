public abstract class Passenger {
    private String firstName;
    private String lastName;
    private String passengerType;
    private int luggageCount;
    private String dateOfBirth;

    public Passenger(String firstName, String lastName, String passengerType, int luggageCount, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passengerType = passengerType;
        this.luggageCount = luggageCount;
        this.dateOfBirth = dateOfBirth;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public int getLuggageCount() {
        return luggageCount;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // Abstract method to be implemented by subclasses
    public abstract double getDiscount();
}
