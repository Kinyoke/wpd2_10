package net.wpd2_coursework_group10.model;

/**
 * @author Faisal Burhan Abdu
 * @since April 06 2019
 * @version 0.0.1x
 */

public class User {

    private String firstName;

    private String middleName;

    private String lastName;

    private String emailAddress;

    private String password;

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setEmailAddres(String emailAddress) { this.emailAddress = emailAddress; }

    public void setPassword(String password) { this.password = password; }


    public String getFirstName() { return this.firstName; }

    public String getMiddleName() { return this.middleName; }

    public String getLastName() { return this.lastName; }

    public String getEmailAddres() { return emailAddress; }

    public String getPassword() { return password; }

    @Override
    public String toString() {
        return new StringBuffer(" FirstName: ").append(this.firstName).append(" middleName: ").append(this.middleName)
                .append(" lastName: ").append(this.lastName).append(" emailAddress: ").append(this.emailAddress).append(" password: ")
                .append(this.password).toString();
    }
}
