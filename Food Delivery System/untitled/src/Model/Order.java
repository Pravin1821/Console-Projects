package Model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Order {
    static int count=1;
    private int id;
    private List<Items> itemsList;
    private double totalAmount;
    private double deliveryCharge;
    private String deliveryLoc;
    private LocalDateTime dateTime;

    public Order(List<Items> itemsList, double totalAmount, double deliveryCharge, String deliveryLoc) {
        this.itemsList = itemsList;
        this.totalAmount = totalAmount;
        this.deliveryCharge = deliveryCharge;
        this.deliveryLoc = deliveryLoc;
        this.dateTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getDeliveryLoc() {
        return deliveryLoc;
    }

    public void setDeliveryLoc(String deliveryLoc) {
        this.deliveryLoc = deliveryLoc;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", itemsList=" + itemsList +
                ", totalAmount=" + totalAmount +
                ", deliveryCharge=" + deliveryCharge +
                ", deliveryLoc='" + deliveryLoc + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
