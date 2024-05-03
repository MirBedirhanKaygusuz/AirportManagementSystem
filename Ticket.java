
public abstract class Ticket {
    private Flight flight;
    private airportpassenger passenger;
    private int seatNumber;
    private double basePrice;

    public Ticket(Flight flight, airportpassenger passenger, int seatNumber, double basePrice) {
        this.flight = flight;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
        this.basePrice = basePrice;
    }

    public Flight getFlight() {
        return flight;
    }

    public airportpassenger getPassenger() {
        return passenger;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public double getBasePrice() {
        return basePrice;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateFinalPrice();
}
