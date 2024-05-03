public class Plane {
    private String planeID;

    private boolean  isAvaliable ;

    private int capacity;


    public Plane(String planeID, Boolean isAvaliable, int  capacity) {
        this.isAvaliable = isAvaliable;
        this.planeID = planeID;
        this.capacity = capacity;
    }

    public String getPlaneID(){
        return planeID;
    }

    public String toString(){
        return "Plane " + planeID + " is avaliable : " +isAvaliable + " Capacity " + String.valueOf(capacity);

    }


}
