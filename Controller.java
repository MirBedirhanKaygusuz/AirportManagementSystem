import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private JTextArea textArea, lastTextArea;
    private JSpinner capacitySpiner;
    private JComboBox<String> passengerTypeComboBox;
    private JTextField luggageCountTextField, yearOfBirthTextField, surnameTextField, nameTextField, departureTextField,
            landingTextField, departureDateTextField, returnDateTextField, passengerIdTextField, ticketPriceTextField ;
    private airportpassenger airportpassenger;
    private boolean isAvaliable = true;
    private int capacity;
    private JButton removeUserButton, updateUserButton, addUserButton, addPlaneButton, removePlaneButton,
            addFlightButton, removeFlightButton, buyTicketButton, cancelTicketButton ;


    private JComboBox<String> planeIDComboBox;

    private JList planeList, passengerList, currentFlightsList, manageTicketsList;

    private String planeID;

    private int passengerCount = 0;



    public Controller(JTextArea textArea, JTextField nameTextField, JTextField surnameTextField,
                      JComboBox<String> passengerTypeComboBox, JTextField luggageCountTextField,
                      JTextField yearOfBirthTextField, JButton addUserButton, JButton removeUserButton,
                      JButton updateUserButton, JList passangerList, JTextArea lasttextArea,
                      JSpinner capacitySpiner, JButton addPlaneButton, JButton removePlaneButton, JComboBox planeIDComboBox,
                      JList planeList, JTextField departureTextField, JTextField landingTextField, JTextField departureDateTextField,
                      JTextField returnDateTextField, JButton addFlightButton, JButton removeFlightButton, JList currentFlightsList,
                      JTextField passengerIdTextField, JTextField ticketPriceTextField, JButton buyTicketButton, JButton cancelTicketButton,
                      JList manageTicketsList) {
        this.landingTextField = landingTextField;
        this.departureDateTextField = departureDateTextField;
        this.returnDateTextField = returnDateTextField;
        this.addFlightButton = addFlightButton;
        this.removeFlightButton = removeFlightButton;
        this.currentFlightsList = currentFlightsList;
        this.passengerIdTextField = passengerIdTextField;
        this.ticketPriceTextField = ticketPriceTextField;
        this.buyTicketButton = buyTicketButton;
        this.cancelTicketButton = cancelTicketButton;
        this.manageTicketsList = manageTicketsList;
        this.textArea = textArea;
        this.nameTextField = nameTextField;
        this.surnameTextField = surnameTextField;
        this.passengerTypeComboBox = passengerTypeComboBox;
        this.luggageCountTextField = luggageCountTextField;
        this.yearOfBirthTextField = yearOfBirthTextField;
        this.addUserButton = addUserButton;
        this.removeUserButton = removeUserButton;
        this.updateUserButton = updateUserButton;
        this.passengerList = passangerList;
        this.lastTextArea = lasttextArea;
        this.capacitySpiner = capacitySpiner;
        this.addPlaneButton = addPlaneButton;
        this.removePlaneButton = removePlaneButton;
        this.planeIDComboBox = planeIDComboBox;
        this.planeList = planeList;
        this.departureTextField =departureTextField;




    }

    ActionListener actionAddUserListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            String name = nameTextField.getText();
            String surname = surnameTextField.getText();
            String passengerType = (String) passengerTypeComboBox.getSelectedItem();
            int luggageCount;
            int yearOfBirth;

            try {
                luggageCount = Integer.parseInt(luggageCountTextField.getText());
                yearOfBirth = Integer.parseInt(yearOfBirthTextField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input for luggage count or year of birth.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method if there's an error
            }

            DefaultListModel model = (DefaultListModel) passengerList.getModel();
            passengermanagementsystem passengermanagementsystem = new passengermanagementsystem();
            if (passengerTypeComboBox.getSelectedItem()== "Business") {
                businesspassenger user = passengermanagementsystem.addBusinessPassenger(passengerCount, name, surname, passengerType, luggageCount, yearOfBirth);
                model.addElement(user);

            } else if (passengerTypeComboBox.getSelectedItem() == "Family") {
                familypassenger user = new familypassenger(passengerCount, name,surname,passengerType,luggageCount,yearOfBirth);
                model.addElement(user);

            } else if (passengerTypeComboBox.getSelectedItem() == "Economy") {
                economypassenger user = new economypassenger(passengerCount, name, surname,passengerType,luggageCount,yearOfBirth);
                model.addElement(user);

            }
            passengerCount++;
        }
    };

    ActionListener actionRemoveUserListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            DefaultListModel model = (DefaultListModel) passengerList.getModel();
            int selectedIndex = passengerList.getSelectedIndex();
            if (selectedIndex != -1) {
                model.remove(selectedIndex);
            }
        }
    };

    ActionListener actionUpdateUserListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            DefaultListModel model = (DefaultListModel) passengerList.getModel();
            int selectedIndex = passengerList.getSelectedIndex();
            if (selectedIndex != -1) {
                String name = nameTextField.getText();
                String surname = surnameTextField.getText();
                String passengerType = (String) passengerTypeComboBox.getSelectedItem();
                int luggageCount;
                int yearOfBirth;

                try {
                    luggageCount = Integer.parseInt(luggageCountTextField.getText());
                    yearOfBirth = Integer.parseInt(yearOfBirthTextField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for luggage count or year of birth.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method if there's an error
                }


                passengermanagementsystem passengermanagementsystem = new passengermanagementsystem();
                if (passengerTypeComboBox.getSelectedItem()== "Business") {
                    int selectedPassengerCount = 0 ;
                    if(model.get(selectedIndex) instanceof businesspassenger){
                        selectedPassengerCount = ((businesspassenger) model.get(selectedIndex)).getID();
                    } else if (model.get(selectedIndex) instanceof familypassenger) {
                        selectedPassengerCount = ((familypassenger) model.get(selectedIndex)).getID();
                    } else if (model.get(selectedIndex) instanceof economypassenger) {
                        selectedPassengerCount = ((economypassenger) model.get(selectedIndex)).getID();
                    }

                    businesspassenger user = passengermanagementsystem.addBusinessPassenger(selectedPassengerCount, name, surname, passengerType, luggageCount, yearOfBirth);

                    model.set(selectedIndex,user);
                } else if (passengerTypeComboBox.getSelectedItem() == "Family") {
                    int selectedPassengerCount = 0 ;
                    if(model.get(selectedIndex) instanceof businesspassenger){
                        selectedPassengerCount = ((businesspassenger) model.get(selectedIndex)).getID();
                    } else if (model.get(selectedIndex) instanceof familypassenger) {
                        selectedPassengerCount = ((familypassenger) model.get(selectedIndex)).getID();
                    } else if (model.get(selectedIndex) instanceof economypassenger) {
                        selectedPassengerCount = ((economypassenger) model.get(selectedIndex)).getID();
                    }
                    familypassenger user = passengermanagementsystem.addFamilyPassenger(selectedPassengerCount, name, surname, passengerType, luggageCount, yearOfBirth);
                    model.set(selectedIndex,user);

                } else if (passengerTypeComboBox.getSelectedItem() == "Economy") {
                    int selectedPassengerCount = 0 ;
                    if(model.get(selectedIndex) instanceof businesspassenger){
                        selectedPassengerCount = ((businesspassenger) model.get(selectedIndex)).getID();
                    } else if (model.get(selectedIndex) instanceof familypassenger) {
                        selectedPassengerCount = ((familypassenger) model.get(selectedIndex)).getID();
                    } else if (model.get(selectedIndex) instanceof economypassenger) {
                        selectedPassengerCount = ((economypassenger) model.get(selectedIndex)).getID();
                    }
                    economypassenger user = passengermanagementsystem.addEconomyPassenger(selectedPassengerCount, name, surname, passengerType, luggageCount, yearOfBirth);
                    model.set(selectedIndex,user);
                }

            }
        }
    };

    ActionListener addPlaneActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            DefaultListModel model = (DefaultListModel) planeList.getModel();
            String planeID = lastTextArea.getText();

            int capacity = 0;
            try{
                capacity = (int) capacitySpiner.getValue();
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "invalid input for capacity", "Error", JOptionPane.ERROR_MESSAGE);

            }
            
            Plane plane = new Plane(planeID, isAvaliable, capacity);
            model.addElement(plane);
            planeIDComboBox.removeAllItems();
            for(int i = 0; i< model.getSize(); i++){
                Plane p = (Plane) model.get(i);
                planeIDComboBox.addItem(p.getPlaneID());

            }





        }
    };

   ActionListener removePlaneActionListener = new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           DefaultListModel model = (DefaultListModel) planeList.getModel();
           int selectedIndex = planeIDComboBox.getSelectedIndex();
           if(selectedIndex != -1){
               model.remove(selectedIndex);
               planeIDComboBox.removeAllItems();
               for(int i = 0; i< model.getSize(); i++){
                   Plane p = (Plane) model.get(i);
                   planeIDComboBox.addItem(p.getPlaneID());

               }
           }

       }
   };

   ActionListener addFlightActionListener = new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
        DefaultListModel model = (DefaultListModel) currentFlightsList.getModel();

        String departureLocation = departureTextField.getText();
        String landingLocation = landingTextField.getText();
        String departureDate = departureDateTextField.getText();
        String returnDate = returnDateTextField.getText();

        Flight flight = new Flight(departureLocation, landingLocation, departureDate);
        model.addElement(flight);
        Flight flight2 = new Flight(landingLocation, departureLocation, returnDate);
        model.addElement(flight2);



       }
   };

   ActionListener removeFlightActionlistener = new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           DefaultListModel model = (DefaultListModel) currentFlightsList.getModel();
           int selectedIndex = currentFlightsList.getSelectedIndex();
           if (selectedIndex != -1) {
               model.remove(selectedIndex);
           }
       }
   };

}
