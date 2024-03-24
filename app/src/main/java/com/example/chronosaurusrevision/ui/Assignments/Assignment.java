package com.example.chronosaurusrevision.ui.Assignments;

public class Assignment {
    private String title;
    private String dueDate;
    private String associatedClass;
    private String details;

    // Constructor without an ID parameter (assuming IDs are managed locally)
    public Assignment(String title, String dueDate, String associatedClass, String details) {
        this.title = title;
        this.dueDate = dueDate;
        this.associatedClass = associatedClass;
        this.details = details;
    }

    // Getters and setters for all fields (if needed)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getAssociatedClass() {
        return associatedClass;
    }

    public void setAssociatedClass(String associatedClass) {
        this.associatedClass = associatedClass;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
