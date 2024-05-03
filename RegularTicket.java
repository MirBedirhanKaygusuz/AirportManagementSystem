
public class RegularTicket extends Ticket{
    public RegularTicket(Flight flight, airportpassenger passenger, int seatNumber, double basePrice) {
        super(flight, passenger, seatNumber, basePrice);
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() * (1 - getPassenger().getDiscount());
    }
}
