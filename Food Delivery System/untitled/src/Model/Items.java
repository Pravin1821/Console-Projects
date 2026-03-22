package Model;

public class Items {
    int count=1;
    private int id;
    private int restaurantId;
    private String name;
    private double price;
    private String timeTaken;

    public Items(int restaurantId, String name, double price, String timeTaken) {
        this.id = count++;
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.timeTaken = timeTaken;
    }

    public int getId() {
        return id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }
}
