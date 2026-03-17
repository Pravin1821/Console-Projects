package model;
public class Habit {
    private int habitId;
    private int userId;
    private String habitName;
    private int currentStreak;

    public Habit(int habitId, int UserId, String habitName) {
        this.habitId = habitId;
        this.userId = UserId;
        this.habitName = habitName;
    }

    public int getHabitId() {
        return habitId;
    }

    public void setHabitId(int habitId) {
        this.habitId = habitId;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    @Override
    public String toString() {
        return "Habit{" +
                "habitId=" + habitId +
                ", userId=" + userId +
                ", habitName='" + habitName + '\'' +
                ", Streak='" + currentStreak+
                '}';
    }
}
