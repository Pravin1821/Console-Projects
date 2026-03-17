package model;

import java.time.LocalDateTime;

public class Journal {
    private int id;
    private int userId;
    private String Content;
    private LocalDateTime dateTime;

    public Journal(int id, int userId, String content) {
        this.id = id;
        this.userId = userId;
        Content = content;
        this.dateTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = LocalDateTime.now();
    }
}
