package model;

public class Analytics {
    private int userId;
    private int currentStreak;
    private int longestStreak;
    private double completionRate;
    private double consistencyScore;

    public Analytics(int userId) {
        this.userId = userId;
        this.currentStreak = 0;
        this.longestStreak = 0;
        this.completionRate = 0.0;
        this.consistencyScore = 0.0;
    }

    public double getConsistencyScore() {
        return consistencyScore;
    }

    public void setConsistencyScore(double consistencyScore) {
        this.consistencyScore = consistencyScore;
    }

    public double getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(double completionRate) {
        this.completionRate = completionRate;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public void setLongestStreak(int longestStreak) {
        this.longestStreak = longestStreak;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Analytics{" +
                "currentStreak=" + currentStreak +
                ", longestStreak=" + longestStreak +
                ", completionRate=" + completionRate +
                ", consistencyScore=" + consistencyScore +
                '}';
    }
}
