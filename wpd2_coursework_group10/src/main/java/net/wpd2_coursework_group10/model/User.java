package net.wpd2_coursework_group10.model;

/**
 * @author Faisal Burhan Abdu
 * @since April 06 2019
 * @version 0.0.1x
 */

public class User {

    private String fullName;

    private String emailAddres;

    private String password;

    private String firstName;

    private String middleName;

    private String lastName;


    private int lname = 0;

    public void setFullName(String fullName) {
        this.lname = fullName.split(" ").length;
        this.firstName = (lname > 0)? fullName.split(" ")[0] : "";
        this.middleName = (lname > 0)? fullName.split(" ")[1] : "";
        this.lastName = (lname > 0)? fullName.split(" ")[2] : "";
        this.fullName = fullName;
    }

    public void setEmailAddres(String emailAddres) { this.emailAddres = emailAddres; }

    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }


    public String getEmailAddres() { return emailAddres; }

    public String getPassword() { return password; }

    public String getFirstName() { return this.firstName; }

    public String getMiddleName() { return this.middleName; }

    public String getLastName() { return this.lastName; }
}
