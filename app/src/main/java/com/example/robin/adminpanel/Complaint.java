package com.example.robin.adminpanel;

public class Complaint {
    private String id;
    private String message;
    private String date;
    private String type;


    public Complaint(String id, String message,String date,String type) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}