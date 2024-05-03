
import javax.swing.*;
import java.awt.*;

public class passengermanagementsystem implements AirportManagementSystem {
    // Implement the methods of the ManagementSystem interface as per the requirements of the PassengerManagementSystem

    @Override
    public businesspassenger addBusinessPassenger(int ID, String firstName, String lastName, String passengerType,int luggageCount, int dateOfBirth) {
        businesspassenger businesspassenger = new businesspassenger(ID, firstName, lastName, passengerType, luggageCount, dateOfBirth);
    return businesspassenger;
    }
    @Override
    public void removeBusinessPassenger(businesspassenger passenger) {

    }

    @Override
    public economypassenger addEconomyPassenger(int ID,String firstName, String lastName, String passengerType,int luggageCount, int dateOfBirth) {
        economypassenger economypassenger= new economypassenger(ID, firstName, lastName,  passengerType, luggageCount, dateOfBirth);
        return economypassenger;
    }

    @Override
    public void removeEconomyPassenger(economypassenger passenger) {

    }

    @Override
    public familypassenger addFamilyPassenger(int ID, String firstName, String lastName, String passengerType,int luggageCount, int dateOfBirth) {
        familypassenger familypassenger = new familypassenger(ID, firstName, lastName,  passengerType, luggageCount, dateOfBirth);
        return familypassenger;
    }

    @Override
    public void removeFamilyPassenger(familypassenger passenger) {

    }
}
