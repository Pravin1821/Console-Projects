package Model;

public class DeliveryBoy extends ParentFoodDelivery{
    int count=1;
    private int id;
    private String curLocation;
    private boolean isOnline;
    private float avgRating;
    private float totalRating;
    private int noOfRating;

    public DeliveryBoy(int name, String email, String password, String phoneNum, boolean isOnline) {
        super(name, email, password, phoneNum);
        this.id = count++;
        this.isOnline = isOnline;
    }

    public int getId() {
        return id;
    }

    public String getCurLocation() {
        return curLocation;
    }

    public void setCurLocation(String curLocation) {
        this.curLocation = curLocation;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void addRating(float rating)
    {
        totalRating+=rating;
        noOfRating++;
        avgRating = calAvgRating();
    }

    public float calAvgRating()
    {
        return totalRating/noOfRating;
    }
}
