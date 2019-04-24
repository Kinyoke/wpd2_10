package net.wpd2_coursework_group10.model;

/**
 * @author Faisal Burhan Abdu
 * @since April 06 2019
 * @version 0.0.1x
 */

public class Milestone {

    private int id;

    private String description;

    private String author;

    private String user; // represented by user email address

    private String dueDate;

    private String actualCompletionDate;

    private String status; // pendind, complete, incomplete

    private boolean isCompleted;


    public void setId(int id) { this.id = id; }

    public void setDescription(String description) { this.description = description; }

    public void setAuthor(String author) { this.author = author; }

    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public void setActualCompletionDate(String actualCompletionDate) { this.actualCompletionDate = actualCompletionDate; }

    public void setStatus(String status) { this.status = status; }

    public void setCompleted(boolean completed) { isCompleted = completed; }

    public void setUser(String user){ this.user = user; }

    public int getId() { return id; }

    public String getDescription() { return description; }

    public String getAuthor() { return author; }

    public String getUser() { return user; }

    public String getDueDate() { return dueDate; }

    public String getActualCompletionDate() { return actualCompletionDate; }

    public String getStatus() { return status; }

    public boolean isCompleted() { return isCompleted; }


}
