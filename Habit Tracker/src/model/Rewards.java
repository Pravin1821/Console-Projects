package model;

public class Rewards {
    private int userId;
    private int point;
    private int level;
    private String badge;

    public Rewards(int userId) {
        this.userId = userId;
        this.point = 0;
        this.level = 0;
        this.badge = "Beginner";
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Rewards{" +
                "point=" + point +
                ", level=" + level +
                ", badge='" + badge + '\'' +
                '}';
    }
}
