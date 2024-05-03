
public class VIPticket extends Ticket{
    public VIPticket(Flight flight, airportpassenger passenger, int seatNumber, double basePrice) {
        super(flight, passenger, seatNumber, basePrice);
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() * (1 - getPassenger().getDiscount()) + 100; // VIP ticket has an additional fee of $100
    }
}
