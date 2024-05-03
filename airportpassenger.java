public abstract class airportpassenger {
    private String firstName;
    private String lastName;
    private String passengerType;
    private int luggageCount;
    private int dateOfBirth;

    private int ID;

    public airportpassenger(int ID, String firstName, String lastName, String passengerType, int luggageCount, int dateOfBirth) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.passengerType = passengerType;
        this.luggageCount = luggageCount;
        this.dateOfBirth = dateOfBirth;
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType=passengerType;
    }
    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public void setLuggageCount(int luggageCount) {
        this.luggageCount=luggageCount;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth=dateOfBirth;
    }

    public void setID(int ID) {
        this.ID=ID;
    }
    public int getID() {
        return ID;
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

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return passengerType + " Passenger: " + String.valueOf(ID) + " " + firstName + " " + lastName + " " + dateOfBirth;

    }

    // Abstract method to be implemented by subclasses
    public abstract double getDiscount();
}
