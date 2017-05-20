package application.user;

import org.mongodb.morphia.annotations.Id;

import java.util.Date;

/**
 * Created by hamish on 9/05/17.
 */
public class User {

    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private Date dateCreated;
    private String password;
    private String role;

    public User(){

    }

    public User(String email, String firstName, String lastName, String address, Date dateCreated, String password, String role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateCreated = dateCreated;
        this.password = password;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", dateCreated=" + dateCreated +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
