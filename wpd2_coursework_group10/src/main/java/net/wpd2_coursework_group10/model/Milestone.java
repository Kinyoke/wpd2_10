package net.wpd2_coursework_group10.model;

/**
 * @author Faisal Burhan Abdu
 * @since April 06 2019
 * @version 0.0.1x
 */

public class Milestone {

    private int milestoneId;

    private String description;

    private String author;

    private String user; // represented by user email address

    private String dueDate;

    private String actualCompletionDate;

    private String status; // pendind, complete, incomplete

//    private boolean isCompleted;

    public void setMilestoneId(int milestoneId) { this.milestoneId = milestoneId; }

    public void setDescription(String description) { this.description = description; }

    public void setAuthor(String author) { this.author = author; }

    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public void setActualCompletionDate(String actualCompletionDate) { this.actualCompletionDate = actualCompletionDate; }

    public void setStatus(String status) { this.status = status; }

//    public void setCompleted(boolean completed) { isCompleted = completed; }

    public void setUser(String user){ this.user = user; }

    public String getDescription() { return description; }

    public String getAuthor() { return author; }

    public String getUser() { return user; }

    public String getDueDate() { return dueDate; }

    public String getActualCompletionDate() { return actualCompletionDate; }

    public String getStatus() { return status; }

    public int getMilestoneId() { return milestoneId; }

    //    public boolean isCompleted() { return isCompleted; }

    @Override
    public String toString() {
        return " milestoneId : "+this.milestoneId+" Author : "+this.author+" user : "+this.user+
               " dueDate : "+this.dueDate+" actualCompDate : "+this.actualCompletionDate+" Description : "+this.description+
               " status : "+this.status;
    }

}
