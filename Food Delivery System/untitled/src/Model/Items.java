package Model;

public class Items {
    private int id;
    private int restaurantId;
    private String name;
    private double price;
    private String timeTaken;
    private boolean isAvailable;

    public Items(int restaurantId, int id, String name, double price, String timeTaken, boolean isAvailable) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.timeTaken = timeTaken;
        this.isAvailable = isAvailable;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", timeTaken='" + timeTaken + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
