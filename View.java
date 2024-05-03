import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class View {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Sabiha Gökçen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);

        JTabbedPane tabbedPane = new JTabbedPane();

        //Flight Management Panel
        JPanel flightManagementPanel = new JPanel();
        flightManagementPanel.setLayout(new FlowLayout(FlowLayout.LEFT,1,100));

        JLabel departureLabel = new JLabel("Departure:");
        JLabel landingLabel = new JLabel("Landing:");
        JLabel departureDateLabel = new JLabel("Departure Date:");
        JLabel returnDateLabel = new JLabel("Return Date:");

        JTextField departureTextField = new JTextField(5);
        JTextField landingTextField = new JTextField(5);
        JTextField departureDateTextField = new JTextField(5);
        JTextField returnDateTextField = new JTextField(5);


        JButton addFlightButton = new JButton("Add Flight");
        JButton removeFlightButton = new JButton("Remove Flight");


        JPanel generateFlightPanel = new JPanel();
        generateFlightPanel.setBorder(BorderFactory.createTitledBorder("Generate Flight"));
        generateFlightPanel.setLayout(new BorderLayout());
        generateFlightPanel.setPreferredSize(new Dimension(470,120));

        JPanel inputcategory= new JPanel();
        inputcategory.setPreferredSize(new Dimension(400,60));
        inputcategory.setLayout(new GridLayout(2,4));
        inputcategory.add(departureLabel);
        inputcategory.add(landingLabel);
        inputcategory.add(departureDateLabel);
        inputcategory.add(returnDateLabel);
        inputcategory.add(departureTextField);
        inputcategory.add(landingTextField);
        inputcategory.add(departureDateTextField);
        inputcategory.add(returnDateTextField);

        JPanel flightContentPanel = new JPanel();
        flightContentPanel.setPreferredSize(new Dimension(375,120));
        flightContentPanel.add(inputcategory);
        flightContentPanel.add(addFlightButton);
        flightContentPanel.add(removeFlightButton);
        generateFlightPanel.add(flightContentPanel,BorderLayout.CENTER);

        JPanel currentFlightsPanel = new JPanel();
        currentFlightsPanel.setBorder(BorderFactory.createTitledBorder("Current Flights"));
        currentFlightsPanel.setLayout(new BorderLayout());
        currentFlightsPanel.setPreferredSize(new Dimension(300,180));

        DefaultListModel demo3= new DefaultListModel<>();
        JList currentFlightsList = new JList(demo3);
        currentFlightsList.setPreferredSize(new Dimension(280,150));
        currentFlightsPanel.add(currentFlightsList);

        JPanel manageTicketsPanel = new JPanel();
        manageTicketsPanel.setBorder(BorderFactory.createTitledBorder("Manage Tickets"));
        manageTicketsPanel.setPreferredSize(new Dimension(500,500));
        manageTicketsPanel.setLayout(new BorderLayout());

        JList manageTicketsList = new JList();
        manageTicketsList.setPreferredSize(new Dimension(100,180));
        manageTicketsPanel.add(manageTicketsList,BorderLayout.NORTH);

        JPanel flightinputPanel = new JPanel();
        flightinputPanel.setPreferredSize(new Dimension(400,180));
        flightinputPanel.setLayout(new GridLayout(2,3));
        flightinputPanel.add(new JLabel("Passenger ID"));
        flightinputPanel.add(new JLabel("Ticket Price:",FlowLayout.LEFT));

        JTextField ticketPriceTextField= new JTextField();
        ticketPriceTextField.setEditable(false);
        JTextField passengerIdTextField = new JTextField();
        flightinputPanel.add(ticketPriceTextField);
        flightinputPanel.add(passengerIdTextField);
        JButton buyTicketButton =  new JButton("Buy Ticket");
        flightinputPanel.add(buyTicketButton);
        JButton cancelTicketButton =new JButton("Cancel Ticket");
        flightinputPanel.add(cancelTicketButton);

        manageTicketsPanel.add(flightinputPanel);

        flightManagementPanel.add(generateFlightPanel);
        flightManagementPanel.add(currentFlightsPanel);
        flightManagementPanel.add(manageTicketsPanel);

        JPanel topLevelPanel = new JPanel();
        topLevelPanel.setLayout(new BoxLayout(topLevelPanel, BoxLayout.Y_AXIS));

        JPanel passengerManagementPanel = new JPanel();
        passengerManagementPanel.setBorder(BorderFactory.createTitledBorder("Passenger Management"));
        passengerManagementPanel.setLayout(new GridLayout(2,1));

        JTextField nameTextField = new JTextField(20);
        JTextField surnameTextField = new JTextField(20);
        JTextField luggageCountTextField = new JTextField(20);
        JTextField yearOfBirthTextField = new JTextField(20);

        String[] passengerTypes = {"Family", "Economy", "Business"};
        JComboBox<String> passengerTypeComboBox = new JComboBox<>(passengerTypes);


        JPanel allPassengersPanel = new JPanel();
        allPassengersPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        allPassengersPanel.setLayout(new BoxLayout(allPassengersPanel, BoxLayout.Y_AXIS));
        allPassengersPanel.setBorder(BorderFactory.createTitledBorder("All Passengers"));

        DefaultListModel demoList = new DefaultListModel();
        JList passengerList = new JList(demoList);

        passengerList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    DefaultListModel model = (DefaultListModel) passengerList.getModel();
                    int selectedIndex = passengerList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        if(model.get(selectedIndex) instanceof businesspassenger){
                            businesspassenger businesspassenger = ((businesspassenger) model.get(selectedIndex));
                            nameTextField.setText(businesspassenger.getFirstName());
                            surnameTextField.setText(businesspassenger.getLastName());
                            luggageCountTextField.setText(String.valueOf(businesspassenger.getLuggageCount()));
                            yearOfBirthTextField.setText(String.valueOf(businesspassenger.getDateOfBirth()));
                            passengerTypeComboBox.setSelectedItem(businesspassenger.getPassengerType());

                        } else if (model.get(selectedIndex) instanceof familypassenger) {
                            familypassenger familypassenger = ((familypassenger) model.get(selectedIndex));
                            nameTextField.setText(familypassenger.getFirstName());
                            surnameTextField.setText(familypassenger.getLastName());
                            luggageCountTextField.setText(String.valueOf(familypassenger.getLuggageCount()));
                            yearOfBirthTextField.setText(String.valueOf(familypassenger.getDateOfBirth()));
                            passengerTypeComboBox.setSelectedItem(familypassenger.getPassengerType());

                        } else if (model.get(selectedIndex) instanceof economypassenger) {
                            economypassenger economypassenger = ((economypassenger) model.get(selectedIndex));
                            nameTextField.setText(economypassenger.getFirstName());
                            surnameTextField.setText(economypassenger.getLastName());
                            luggageCountTextField.setText(String.valueOf(economypassenger.getLuggageCount()));
                            yearOfBirthTextField.setText(String.valueOf(economypassenger.getDateOfBirth()));
                            passengerTypeComboBox.setSelectedItem(economypassenger.getPassengerType());
                        }
                    }
                }

            }
        });
        passengerList.setPreferredSize(new Dimension(280,150));
        allPassengersPanel.add(passengerList);

        JTextArea textArea = new JTextArea(7, 20);
        textArea.setEditable(false);
        textArea.setPreferredSize(new Dimension(7,20));


        //allPassengersPanel.add(textArea);

        passengerManagementPanel.add(allPassengersPanel);

        JPanel createUserPanel = new JPanel();
        createUserPanel.setBorder(BorderFactory.createTitledBorder("Create a new user"));
        createUserPanel.setLayout(new GridLayout(2, 5));

        JLabel nameLabel = new JLabel("Name:");
        JLabel surnameLabel = new JLabel("Surname:");
        JLabel passengerTypeLabel = new JLabel("Passenger Type:");
        JLabel luggageCountLabel = new JLabel("Luggage Count:");
        JLabel yearOfBirthLabel = new JLabel("Year of Birth:");

        createUserPanel.add(nameLabel);
        createUserPanel.add(surnameLabel);
        createUserPanel.add(passengerTypeLabel);
        createUserPanel.add(luggageCountLabel);
        createUserPanel.add(yearOfBirthLabel);

        createUserPanel.add(nameTextField);
        createUserPanel.add(surnameTextField);
        createUserPanel.add(passengerTypeComboBox);
        createUserPanel.add(luggageCountTextField);
        createUserPanel.add(yearOfBirthTextField);


        passengerManagementPanel.add(createUserPanel);

        topLevelPanel.add(passengerManagementPanel);
        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.Y_AXIS));
        finalPanel.setLayout(new GridLayout(3,1));

        JButton addUserButton = new JButton("Add User");
        JButton removeUserButton = new JButton("Remove User");
        JButton updateUserButton = new JButton("Update User");

        finalPanel.add(addUserButton);
        finalPanel.add(removeUserButton);
        finalPanel.add(updateUserButton);

        topLevelPanel.add(finalPanel);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();

        DefaultListModel planeModel = new DefaultListModel();
        JList planeList = new JList(planeModel);
        planeList.setPreferredSize(new Dimension(300,150));
        panel1.add(planeList);

        topPanel.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        JTextArea lasttextArea = new JTextArea(5, 20);
        JButton addPlaneButton = new JButton("Add Plane");
        JLabel capacityLabel = new JLabel("Capacity:");

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());

        JComboBox<String> planeIDComboBox = new JComboBox<>();
        JButton removePlaneButton = new JButton("Remove Plane");


        SpinnerModel sm = new SpinnerNumberModel(1, 1, 110, 1); //default value,lower bound,upper bound,increment by
        JSpinner capacitySpiner = new JSpinner(sm);


        panel2.add(lasttextArea);
        panel2.add(addPlaneButton);
        panel2.add(capacityLabel);
        panel2.add(capacitySpiner);
        panel3.add(planeIDComboBox);
        panel3.add(removePlaneButton);

        // Add panel2 to the topPanel
        topPanel.add(panel2);
        topPanel.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(4,3));

        JTextArea text1 = new JTextArea();
        JTextArea text2 = new JTextArea();
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();

        JButton button1 = new JButton("Add Hangar");
        JButton button2 = new JButton("Remove Hangar");
        JButton button3 = new JButton("Add Runway");
        JButton button4 = new JButton("Remove Runway");
        JButton button5 = new JButton("Reserve Hangar");
        JButton button6 = new JButton("Reset Hangar");
        JButton button7 = new JButton("Reserve Runway");
        JButton button8 = new JButton("Reset Runway");
        JButton button9 = new JButton("Reserve Runway");
        JButton button10 = new JButton("Reset Runway");

        panel4.add(text1);
        panel4.add(button1);
        panel4.add(button2);
        panel4.add(text2);
        panel4.add(button3);
        panel4.add(button4);
        panel4.add(field1);
        panel4.add(button5);
        panel4.add(button6);
        panel4.add(field2);
        panel4.add(button7);
        panel4.add(button8);

        topPanel.add(panel4);


        Controller controller = new Controller(textArea,nameTextField,surnameTextField,passengerTypeComboBox,
                luggageCountTextField,yearOfBirthTextField,addUserButton,removeUserButton,updateUserButton, passengerList,
                lasttextArea, capacitySpiner, addPlaneButton, removePlaneButton, planeIDComboBox, planeList, departureTextField,
                landingTextField, departureDateTextField, returnDateTextField, addFlightButton, removeFlightButton, currentFlightsList,
                passengerIdTextField, ticketPriceTextField, buyTicketButton, cancelTicketButton,manageTicketsList );

        addUserButton.addActionListener(controller.actionAddUserListener);
        updateUserButton.addActionListener(controller.actionUpdateUserListener);
        removeUserButton.addActionListener(controller.actionRemoveUserListener);
        removePlaneButton.addActionListener(controller.removePlaneActionListener);
        addPlaneButton.addActionListener(controller.addPlaneActionListener);
        addFlightButton.addActionListener(controller.addFlightActionListener);
        removeFlightButton.addActionListener(controller.removeFlightActionlistener);

        tabbedPane.addTab("Passenger Management System",topLevelPanel);
        tabbedPane.addTab("Plane Management System", topPanel);
        tabbedPane.addTab("Flight Management System", flightManagementPanel);

        // Add the tabbed pane to the frame
        frame.add(tabbedPane);

        frame.setVisible(true);

    }
}
