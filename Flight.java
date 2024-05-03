public class Flight {

    private String departureLocation;
    private String landingLocation;
    private String departureDate;
    private int capacity;

    public Flight(String departureLocation, String landingLocation, String departureDate) {
        this.departureLocation = departureLocation;
        this.landingLocation = landingLocation;
        this.departureDate = departureDate;
    }



    public String getFlightDepature(){
        return departureLocation;
    }

    public String getFlightLanding(){
        return landingLocation;
    }

    public String getFlightDepatureDate(){
        return departureDate;
    }
    public int getFlightCapacity(){
        return capacity;
    }



    public  void setFlightDepature(String departureLocation){
        this.departureLocation = departureLocation;
    }

    public void setFlightLanding(String landingLocation){
         this.landingLocation= landingLocation;
    }

    public void setFlightDepatureDate(String departureDate){
        this.departureDate=departureDate;
    }
    public void setFlightCapacity(int capacity){
         this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Flight " + departureLocation + " to " + landingLocation + " on date " +  departureDate;

    }

}
