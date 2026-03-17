package model;

import java.time.LocalDateTime;

public class HabitLog {
    int count = 0;
    private int logID;
    private int habitId;
    private LocalDateTime dateTime;
    private boolean isCompleted;

    public HabitLog() {
        this.logID = count++;
        this.habitId = 0;
        this.dateTime = LocalDateTime.now();
        this.isCompleted = false;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID() {
        this.logID = count++;
    }

    public int getHabitId() {
        return habitId;
    }

    public void setHabitId(int habitId) {
        this.habitId = habitId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "HabitLog{" +
                "dateTime=" + dateTime +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
