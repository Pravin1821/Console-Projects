package Model;

import java.util.List;

public class Restaurant extends ParentFoodDelivery{
    int count=1;
    private int id;
    private String location;
    private boolean isOpen;
    private float totalRating;
    private int noOfRating;
    private float avgRating;
    private List<String> feedback;

    public Restaurant(int name, String email, String password, String phoneNum, String location, boolean isOpen) {
        super(name, email, password, phoneNum);
        this.id = count++;
        this.location = location;
        this.isOpen = isOpen;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getRating() {
        return avgRating;
    }

    public void setRating(float rating) {
        totalRating+=rating;
        noOfRating++;
        avgRating=calAvgRating();
    }

    public List<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(String name,String fb) {
        String feed = name+" : "+fb;
        feedback.add(feed);
    }
    public float calAvgRating()
    {
        return totalRating/noOfRating;
    }
}
