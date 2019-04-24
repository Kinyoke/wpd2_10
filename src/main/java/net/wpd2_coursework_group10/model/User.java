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


    private int lname = this.fullName.split(" ").length;

    public void setFullName(String fullName) { this.fullName = fullName; }

    public void setEmailAddres(String emailAddres) { this.emailAddres = emailAddres; }

    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }


    public String getEmailAddres() { return emailAddres; }

    public String getPassword() { return password; }

    public String getFirstName() { this.firstName = (lname > 0)? this.fullName.split(" ")[0] : this.fullName; return this.firstName; }

    public String getMiddleName() { this.middleName = (lname > 0)? this.fullName.split(" ")[1] : this.fullName; return this.middleName; }

    public String getLastName() { this.lastName = (lname > 0)? this.fullName.split(" ")[2] : this.fullName; return this.lastName; }
}
